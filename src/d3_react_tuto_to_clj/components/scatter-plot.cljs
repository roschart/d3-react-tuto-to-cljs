(ns d3-react-tuto-to-clj.components.scatter-plot
    (:require [sablono.core :as sab]
              [cljsjs.d3 :as d3]))

(def data [[20 40]
           [40 90]
           [250 150]
           [550 10]])

(defn- xScale []
 #(-> (.scaleLinear js/d3)
     (.domain [0, 1000])
     (.range [0, 600])))

(defn- chart->vector [chart]
  ; (let [data (:data @chart)]
    (let [x (.range  (.scaleLinear js/d3) (clj->js [40 90]))
          y (-> (.scaleLinear js/d3)
                (.domain (clj->js [40 900]))
                (.range (clj->js [40 90])))]

       (y 900)))


(defn scatter-plot [chart]
  (sab/html [:div
             [:p (str (:data @chart))]
             [:p "salto"]
             [:p (str (chart->vector chart))]
             [:svg {:width (:width @chart) :height (:height @chart) :class "svg"}
              [:g (map-indexed (fn [id [x y]]
                                 [:circle {:cx x :cy y :r 10 :key id}])
                               data)]]]))
