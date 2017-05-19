(ns d3-react-tuto-to-clj.core
  (:require
    [sablono.core :as sab]
    [d3-react-tuto-to-clj.components.chart :refer [chart random-data-set]]))

(def ^private config
  {:width 600
   :height 300
   :repetitions 5
   :max-range 100})

(def app-state (atom {:data (random-data-set (:repetitions config)(:max-range config))}))



(enable-console-print!)


;; define your app data so that it doesn't get over-written on reload


(defn on-js-reload [])
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)


(defn render! []
  (.render js/ReactDOM
           (chart app-state config)
           (.getElementById js/document "app")))

(add-watch app-state :on-change (fn [_ _ _ _] (render!)))

(render!)
