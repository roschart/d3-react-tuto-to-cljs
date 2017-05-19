(ns d3-react-tuto-to-clj.components.chart
  (:require [sablono.core :as sab]
            [d3-react-tuto-to-clj.components.scatter-plot :refer [scatter-plot]]))


(defn random-data-set
  [r n]
  (repeatedly r #(vector (rand-int n) (rand-int n))))


(defn chart [data config]
  (sab/html [:div
              [:h1 "Playing with D3 and clojure"]
              [:div {:class "controls"}
                [:button {:class "btn randomize" :onClick #(swap! data update-in [:data] (partial random-data-set (:repetitions config) (:max-range config)))}
                      "Randomize Data"]]
              (scatter-plot data config)]))
