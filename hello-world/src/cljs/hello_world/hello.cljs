(ns hello-world.main)

(enable-console-print!)

(def my-name "Brent")

; Multi-arity fns
(defn greeting 
  ([] (greeting "Hello" "world"))
  ([name] (str "Hello" name "."))
  ([salutation name] (str salutation ", " name ".")))

(println (greeting  "Sup" "Brent")) 

(defn average
  ([x] x)
  ([x y] (/ (+ x y) 2))
  ([x y & extra] (/ (reduce + (+ x y) extra)
                    (+ 2 (count extra)))))

(println (average 3)
         (average 1 2 3)
         (average 9 90 900 999))

(let [x 4
      y 9]
  (println "The product of" x "and" y "is" (* x y)))

; Destructuring!
(def nums (list 9 8 7 6 5 4))
(let [[a b & r] nums]
  (println "a is" a)
  (println "b is" b)
  (println "r is" r))

(println (if (even? 41) "Even!" "Odd!"))
(when (even? 42)
  (println "When Even!")
  (println "Even is (if predicate (do ...body...))"))
; nil, false, and the js/undefined are falsy
; Everything else is truthy!

; (println (cond
;            test-expr-1 body-expr-1
;            test-expr-2 body-expr-2
;            test-expr-3 body-expr-3
;            :else else-expr)) ; else is not nil or false, so it always evaluates to true.

; Do is usually used for side effects. The last value is what's returned.
(println (let [x 100]
  (cond
    (< x 10) (do (println "x is a small number.") :small) 
    (< x 100) (do (println "x is a medium number.") :medium) 
    (< x 1000) (do (println "x is a large number.") :large))))

; 4 basic data types:
; vectors, maps, sets - evaluate to themselves
; (1 2 3), (print "Hello")  ; Lists
; [:a :b :c 1 2 3] ; Vector
; {:a 1, "b" 2} ; Map
; #{3 7 :z} ; Set

; The js namespace is the global js scope.
; Method access is (.methodName obj)
; Field access is (.-field obj)
(def message "Hello, world!")
(def msg-length (.-length message))
(def insult (.replace message #"world" "idiots"))
(println message msg-length insult)

; Constructors end with a .
(println "Today is" (.toString (js/Date. 2016 7 30)))
(println "Today is" (js/Date 2016 7 30))

; (try
;   ;; body
;   (catch ErrClass err
;     ;; somze
;     ;; shiz
;     )
;   (catch js/Err err
;     ;; more shiz
;     )
;   (finally
;     ;; always this shiz
;     ))

(println :keywords :can/have-namespaces ::this-is-in-the-current-ns)

(println :a (:a  {:a 1 :b 2}))
(println \a\ \s\e \r \i \e \s \ \o \f \  \c \h \a \r \a \c \t \e \r)
