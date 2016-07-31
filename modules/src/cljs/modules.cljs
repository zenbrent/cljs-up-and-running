(ns modules.core
  ; in cljs, these are the only forms allowed in a ns decleration:
  (:require [modules.something :as s]
            [cljsjs.d3])
  (:use [modules.something :only [say-hi]]) ; loads all the symbols in modules.something into the current ns
  )

(enable-console-print!)

(say-hi)
(s/say-hi)
(modules.something/say-hi)

;; An example from http://christopheviau.com/d3_tutorial/
; var sampleSVG = d3.select("#viz")
;     .append("svg")
;     .attr("width", 100)
;     .attr("height", 100);    
;
; sampleSVG.append("circle")
;     .style("stroke", "gray")
;     .style("fill", "white")
;     .attr("r", 40)
;     .attr("cx", 50)
;     .attr("cy", 50)

(let [sample-svg (.append (.select js/d3 "#viz") "svg")
      a-circle (.append sample-svg "circle")]
  (do (.attr sample-svg "width" 100)
      (.attr sample-svg "height" 100)

      (.style a-circle "stroke" "gray")
      (.style a-circle "fill" "white")
      (.attr a-circle "r" 40)
      (.attr a-circle "cx" 50)
      (.attr a-circle "cy" 50)))

