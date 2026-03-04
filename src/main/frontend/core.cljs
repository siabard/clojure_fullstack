(ns frontend.core
  (:require [reagent.core :as r] ;; 상태관리 (atom)이 이용 
            [ajax.core :refer [GET]] ;; HTTP GET 요청 
            [reagent.dom.client :as rdomc]))

;; shadow-cljs.edn에서 주입해 주는 환경 변수를 받을 그릇을 만듭니다.
(goog-define api-address "http://localhost:3000")

;;  렌더링 컨테이너
(defonce root-container (atom nil))

;; 백엔드 호출시 결과 보존용 
(defonce api-response (r/atom "아직 데이터를 가져오지 못함"))


;; 백엔드 호출 
(defn fetch-hello []
  (GET (str api-address "/api/hello")
       {:handler (fn [response]
                   (reset! api-response response))
        :error-handler (fn [{:keys [status status-text]}]
                         (reset! api-response (str "에러 발생: " status " " status-text)))}))

;; UI 컴포넌트 

(defn hello-world 
  []
  [:div 
   [:h1 "안녕하세요!"]
   [:p "백엔드 응답: " [:strong @api-response]]
   [:button {:on-click fetch-hello} "데이터 불러오기"]])

;; 백엔드 호출 


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
