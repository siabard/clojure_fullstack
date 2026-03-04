(ns frontend.core
  (:require [reagent.dom.client :as rdomc]))


;;  렌더링 컨테이너
(defonce root-container (atom nil))



;; UI 컴포넌트 

(defn hello-world 
  []
  [:div 
   [:h1 "안녕하세요!"]
   [:p "Emacs 와 shadow-cljs 환경 구축이 완료되었습니다. 하하하"]])

;; 앱을 HTML의 "app" 에 마운트 
(defn ^:dev/after-load mount-root []
  (let [root-el (.getElementById js/document "app")]
    (when-not @root-container 
      (reset! root-container (rdomc/create-root root-el)))
    (rdomc/render @root-container [hello-world])))

;; shadow-cljs 가 처음 실행될 때
(defn init! []
  (js/console.log "앱이 시작되었습니다.")
  (mount-root))
