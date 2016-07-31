(ns modules.something
  ; (:require-macros [... as ...]) ; macros are loaded differently in cljs files.
  (:require [cljs.reader :as reader]))

(enable-console-print!)

(defn say-hi [] (println "hi!"))

(defn ^:export this-will-not-be-munged-by-goog-closure []
  (println "hi!"))

; Macros!

; (defmacro when2
;   ([condition & body]
;    (list 'if condition
;          (cons 'do body))))

; or with syntax quoting
(defmacro when2
  [condition & body]
  `(if ~condition (do ~@body))) ; ~@ -- unquote splicing: inserts the contents of the list

(when2 true
       (println "when2!"))

; auto-gensyms: keyword# is guranteed to be unique, it won't clash with anything passed in to the macro.
(defmacro debug [expr]
  `(let [result# ~expr]
     (println "Evaluating:" '~expr) ; quote unquote: so you can print the literal code of expr w/o evaluating it.
     (println "Result:" result#)
     result#))

(println (:a (reader/read-string "{:a 1 :b 2}")))
(println (pr-str {:a "1" :b "2"})) ; pr, prn, pr-str all print string escapes special characters

; Tagged literals
(println (.toDateString #inst "2016-07-31T10:16:03.253Z"))
; the implementation can be different, but is a literal representation of a date thing.
; DATES ARE JUST FUCKING SERIALIZED CORRECTLY OMG



