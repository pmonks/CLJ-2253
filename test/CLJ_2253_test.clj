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

(ns CLJ-2253-test
  (:require [clojure.test     :refer :all]
            [test-http-server :refer :all]
            [CLJ-2253         :refer :all]))

(println "\n☔️ Running tests on Clojure" (clojure-version) "/ JVM" (System/getProperty "java.version"))

(deftest base64-encoding
  (testing "Basic BASE64 encoding (note: private fn under test)"
    (is (thrown? java.lang.NullPointerException                               (#'CLJ-2253/base64-encode nil)))
    (is (= ""                                                                 (#'CLJ-2253/base64-encode "")))
    (is (= "Zm9v"                                                             (#'CLJ-2253/base64-encode "foo")))
    (is (= "VGhpcyBsaWJyYXJ5IHJlYWxseSBzaG91bGRuJ3QgaGF2ZSB0byBleGlzdC4uLg==" (#'CLJ-2253/base64-encode "This library really shouldn't have to exist...")))
    (is (= "8J+SqQ=="                                                         (#'CLJ-2253/base64-encode "💩")))))

(def ^:private port-number (let [socket (java.net.ServerSocket. 0)]
                             (.close socket)
                             (.getLocalPort socket)))

(deftest slurping-urls
  (println "  ⬆️ Starting test HTTP server on port" port-number "...")
  (start-test-http-server port-number)
  (testing "Slurping from URLs"
    (is (= "Successful"              (slurp (str "http://localhost:" port-number "/"))))
    (is (= "Successful"              (slurp (str "http://knockknock:whosthere@localhost:" port-number "/secure"))))
    (is (thrown? java.io.IOException (slurp (str "http://invalid:invalid@localhost:" port-number "/secure")))))
  (println "  ⬇️ Stopping test HTTP server...")
  (stop-test-http-server))
