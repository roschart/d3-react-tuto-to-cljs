(ns d3-react-tuto-to-clj.core
  (:require
    [sablono.core :as sab]
    [d3-react-tuto-to-clj.components.like-seymore :refer [like-seymore]]
    [d3-react-tuto-to-clj.components.chart :refer [chart random-data-set]]))

(def app-state (atom {:data (random-data-set)}))


(enable-console-print!)


;; define your app data so that it doesn't get over-written on reload


(defn on-js-reload [])
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)


(defn render! []
  (.render js/ReactDOM
           (chart app-state)
           (.getElementById js/document "app")))

(add-watch app-state :on-change (fn [_ _ _ _] (render!)))

(render!)
