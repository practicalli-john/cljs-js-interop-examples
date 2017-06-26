(ns js-interop.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(defonce app-state (atom {:text "Hello Chestnut!"}))

(defn root-component [app owner]
  (reify
    om/IRender
    (render [_]
      (dom/div nil (dom/h1 nil (:text app))))))

(om/root
 root-component
 app-state
 {:target (js/document.getElementById "app")})


;; ClojureScript defines special js namespace to allow accessing JavaScript types/functions/methods/objects defined in global scope (i.e. window object for browser).

;; (def text js/globalName)
;; JS output: namespace.text = globalName;
