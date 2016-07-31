(ns modules.something)

(enable-console-print!)

(defn say-hi [] (println "hi!"))

(defn ^:export this-will-not-be-munged-by-goog-closure []
  (println "hi!"))
