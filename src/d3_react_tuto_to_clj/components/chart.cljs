(ns d3-react-tuto-to-clj.components.chart
  (:require [sablono.core :as sab]
            [d3-react-tuto-to-clj.components.scatter-plot :refer [scatter-plot]]))

(def styles
  {:width   500
   :height  300
   :padding 30})

(def ^private numDataPoints 50)
(def ^private rangeData 1000)

(def ^private getRandomData (partial rand-int rangeData))


(defn random-data-set
  []
  (repeatedly numDataPoints #(vector (getRandomData) (getRandomData))))


(defn chart [data]
  (sab/html [:div
              [:h1 "Playing with D3 and clojure"]
              (scatter-plot data)
              [:div {:class "controls"}
                [:button {:class "btn randomize" :onClick #(swap! data update-in [:data] random-data-set)}
                 "Randomize Data"]]]))
