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
  (:require [midje.sweet :refer :all]
            [CLJ-2253    :refer :all]))

(facts "Basic BASE64 encoding tests"
  (base64-encode nil)                                              => throws java.lang.NullPointerException
  (base64-encode "")                                               => ""
  (base64-encode "foo")                                            => "Zm9v"
  (base64-encode "This library really shouldn't have to exist...") => "VGhpcyBsaWJyYXJ5IHJlYWxseSBzaG91bGRuJ3QgaGF2ZSB0byBleGlzdC4uLg=="
  (base64-encode "💩")                                            => "8J+SqQ=="
  )

(println "Please open https://webhook.site/#/8f45a5ba-d1a7-48be-bc17-416c7699de05 in a browser, in order to confirm that basic auth information is being sent correctly.")

(facts "Slurping from URLs"
  (slurp "https://webhook.site/8f45a5ba-d1a7-48be-bc17-416c7699de05")                     => ""
  (slurp "https://user:password@webhook.site/8f45a5ba-d1a7-48be-bc17-416c7699de05")       => ""
  (slurp "https://someoneelse:letmein@webhook.site/8f45a5ba-d1a7-48be-bc17-416c7699de05") => ""
  )
