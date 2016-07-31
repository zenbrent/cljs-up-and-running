(ns modules.something
  ; (:require-macros [... as ...]) ; macros are loaded differently in cljs files.
  )

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


