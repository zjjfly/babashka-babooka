#!/usr/bin/env bb

(require '[babashka.cli :as cli])
(require '[journal.add :as add])
(require '[journal.list :as list])

(def cli-opts
  {:entry     {:alias   :e
               :desc    "Your dreams."
               :require true}
   :timestamp {:alias  :t
               :desc   "A unix timestamp, when you recorded this."
               :coerce {:timestamp :long}}
   })

(defn help
      [_]
      (println
        (str
          "add\n"
          (cli/format-opts {:spec cli-opts}))))

(def table
  [{:cmds ["add"] :fn add/add-entry :spec cli-opts}
   {:cmds ["list"] :fn list/list-entries}
   {:cmds [] :fn help}])

(cli/dispatch table *command-line-args*)
