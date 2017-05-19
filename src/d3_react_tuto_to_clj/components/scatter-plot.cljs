(ns d3-react-tuto-to-clj.components.scatter-plot
    (:require [sablono.core :as sab]
              [cljsjs.d3 :as d3]))

(defn- chart->vector [data, config]
    (let [width (:width config)
          height (:height config)
          max-range (:max-range config)
          x (-> (.scaleLinear js/d3)
                (.domain (clj->js [0 max-range]))
                (.range (clj->js [0 width])))
          y (-> (.scaleLinear js/d3)
                (.domain (clj->js [0 max-range]))
                (.range (clj->js [height  0])))]
       (map (fn [[a b]] [(x a) (y b)]) data)))


(defn scatter-plot [chart config]
  (let [data (:data @chart)
        scaled-data (chart->vector data config)]
    (sab/html
      [:div
       [:svg {:width (:width config) :height (:height config) :class "svg"}
        [:g (map-indexed (fn [id [x y]]
                           [:circle {:cx x :cy y :r 10 :key id}])
                         scaled-data)]]

       [:p (str "original data:" data)]
       [:p (str "scaled data:" scaled-data)]])))
