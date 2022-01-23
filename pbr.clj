;
; Copyright © 2021 Peter Monks
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
; SPDX-License-Identifier: Apache-2.0
;

(def lib 'com.github.pmonks/clj-2253)

#_{:clj-kondo/ignore [:unresolved-namespace]}
(def version (format "1.0.%s" (b/git-count-revs nil)))

(defn set-opts
  [opts]
  (assoc opts
         :lib          lib
         :version      version
         :write-pom    true
         :validate-pom true
         :pom          {:description      "A workaround for https://dev.clojure.org/jira/browse/CLJ-2253."
                        :url              "https://github.com/pmonks/CLJ-2253"
                        :licenses         [:license   {:name "Apache License 2.0" :url "http://www.apache.org/licenses/LICENSE-2.0.html"}]
                        :developers       [:developer {:id "pmonks"  :name "Peter Monks" :email "pmonks+CLJ-2253@gmail.com"}
                                                      {:id "slipset" :name "Erik Assum"}]
                        :scm              {:url "https://github.com/pmonks/CLJ-2253" :connection "scm:git:git://github.com/pmonks/CLJ-2253.git" :developer-connection "scm:git:ssh://git@github.com/pmonks/CLJ-2253.git"}
                        :issue-management {:system "github" :url "https://github.com/pmonks/CLJ-2253/issues"}}
         :test-deps    {'http-kit/http-kit {:mvn/version "2.5.3"}}))
