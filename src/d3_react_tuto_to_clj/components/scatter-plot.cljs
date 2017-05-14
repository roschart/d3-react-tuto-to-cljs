(ns d3-react-tuto-to-clj.components.scatter-plot
    (:require [sablono.core :as sab]))

(defn scatter-plot [data]
  (sab/html [:div
             [:p (str (:data @data))]]))
