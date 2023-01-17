#!/usr/bin/env bb

(require '[clojure.string :as str])

(str/join " " ["Hello" "from" *ns* ",inner world!"])
