;
; Copyright © 2018 Peter Monks
; SPDX-License-Identifier: Apache-2.0
;
; Licensed under the Apache License, Version 2.0 (the "License");
; you may not use this file except in compliance with the License.
; You may obtain a copy of the License at
;
;     http://www.apache.org/licenses/LICENSE-2.0
;
; Unless required by applicable law or agreed to in writing, software
; distributed under the License is distributed on an "AS IS" BASIS,
; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
; See the License for the specific language governing permissions and
; limitations under the License.
;

(ns test-http-server
  (:require [org.httpkit.server :as http]))

(def ^:private http-server (atom nil))

(def ^:private response-200 {:status 200 :headers {"Content-Type" "text/plain"} :body "Successful"})
(def ^:private response-401 {:status 401 :headers {"Content-Type" "text/plain" "WWW-Authenticate" "Basic"} :body "Unauthorized"})
(def ^:private response-403 {:status 403 :headers {"Content-Type" "text/plain"} :body "Forbidden"})
(def ^:private response-404 {:status 404 :headers {"Content-Type" "text/plain"} :body "Not found"})

(defn- test-http-server
  [req]
  (let [{:keys [request-method headers uri]} req]
    (if (= :get request-method)
      (cond
        (.endsWith ^String uri "/401") response-401  ; Client requested a 401
        (.endsWith ^String uri "/403") response-403  ; Client requested a 403
        (.endsWith ^String uri "/404") response-404  ; Client requested a 404
        (.endsWith ^String uri "/secure")            ; Client requested the secure resource
          (if-let [auth (get headers "authorization")]
            (if (= auth "Basic a25vY2trbm9jazp3aG9zdGhlcmU=")   ; username=knockknock password=whosthere
              response-200                      ; Client provided correct creds
              response-403)                     ; Client provided incorrect creds
            response-401)                       ; Client provided no creds
        :else response-200)                     ; Some other path that we don't care about
      response-404)))                           ; Not a GET request

(defn start-test-http-server
  [port]
  (reset! http-server (http/run-server test-http-server {:port port})))

(defn stop-test-http-server
  []
  (if @http-server
    (@http-server)))
