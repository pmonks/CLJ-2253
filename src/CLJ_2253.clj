;
; Copyright 2018 Peter Monks
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

(ns CLJ-2253
  "A workaround for https://clojure.atlassian.net/browse/CLJ-2253.  Simply require (or use) this namespace before using slurp and you're done."
  (:require [clojure.java.io :as io]))

(try
  (Class/forName "java.util.Base64")
  (load "base64/jdk18up")
  (catch ClassNotFoundException _
    (load "base64/jdk17down")))

(defn- open-input-stream [^java.net.URL url]
  (if-let [user-info (.getUserInfo url)]
    (let [uc    (.openConnection url)
          creds (base64-encode user-info)
          basic (str "Basic " creds)]
      (.setRequestProperty uc "Authorization" basic)
      (.getInputStream uc))
    (.openStream url)))

(extend java.net.URL
  io/IOFactory
  (assoc io/default-streams-impl
    :make-input-stream (fn [^java.net.URL x opts]
                         (io/make-input-stream
                          (if (= "file" (.getProtocol x))
                            (java.io.FileInputStream. (io/as-file x))
                            (open-input-stream x)) opts))
    :make-output-stream (fn [^java.net.URL x opts]
                          (if (= "file" (.getProtocol x))
                            (io/make-output-stream (io/as-file x) opts)
                            (throw (IllegalArgumentException. (str "Can not write to non-file URL <" x ">")))))))

