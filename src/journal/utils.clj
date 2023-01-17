(ns journal.utils
  (:require
    [babashka.fs :as fs]
    [clojure.edn :as edn]))


(def ENTRIES_LOCATION "entries.edn")

(defn read-entries
  []
  (if (fs/exists? ENTRIES_LOCATION)
    (edn/read-string (slurp ENTRIES_LOCATION))
    []))
