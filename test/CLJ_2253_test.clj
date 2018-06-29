;
; Copyright © 2016-2017 Peter Monks
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
  (:require [clojure.test :refer :all]
            [CLJ-2253     :refer :all]))

(println "\n☔️ Tests running on Clojure" (clojure-version) "/ JVM" (System/getProperty "java.version"))

(deftest base64-encoding
  (testing "Basic BASE64 encoding (note: private fn under test)"
    (is (thrown? java.lang.NullPointerException                               (#'CLJ-2253/base64-encode nil)))
    (is (= ""                                                                 (#'CLJ-2253/base64-encode "")))
    (is (= "Zm9v"                                                             (#'CLJ-2253/base64-encode "foo")))
    (is (= "VGhpcyBsaWJyYXJ5IHJlYWxseSBzaG91bGRuJ3QgaGF2ZSB0byBleGlzdC4uLg==" (#'CLJ-2253/base64-encode "This library really shouldn't have to exist...")))
    (is (= "8J+SqQ=="                                                         (#'CLJ-2253/base64-encode "💩")))))

; Commented out these tests, since webhook.site seems to get overloaded a lot, and I haven't found a good alternative yet...

;(println "Please open https://webhook.site/#/8f45a5ba-d1a7-48be-bc17-416c7699de05 in a browser, in order to confirm that basic auth information is being sent correctly.")
;(println "Please also note that when java.net.SocketExceptions are thrown, it indicates that webhook.site has been overloaded and is shedding load.")

;(deftest slurping-urls
;  (testing "Slurping from URLs"
;    (is (= ""                        (slurp "https://webhook.site/8f45a5ba-d1a7-48be-bc17-416c7699de05")))
;    (is (= ""                        (slurp "https://username:password@webhook.site/8f45a5ba-d1a7-48be-bc17-416c7699de05")))
;    (is (= ""                        (slurp "https://someoneelse:letmein@webhook.site/8f45a5ba-d1a7-48be-bc17-416c7699de05")))
;    (is (thrown? java.io.IOException (slurp "https://invalid:invalid@webhook.site/8f45a5ba-d1a7-48be-bc17-416c7699de05/401")))))
