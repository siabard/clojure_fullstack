(ns backend.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.util.response :as response]
            [ring.middleware.cors :refer [wrap-cors]]
            [reitit.ring :as ring]))


;; 1. API Router설정

(def app-routes
  (ring/ring-handler
   (ring/router
    ["/api/hello" {:get (fn [_] (response/response "HELLO. I'm API8"))}])
   (ring/create-default-handler)))

(def app 
  (wrap-cors app-routes
             :access-control-allow-origin [#".*"]
             :access-control-allow-methods [:get :put :post :delete]))

;; 2. 서버 인스탄스 관리
(defonce server (atom nil))

(defn start-server []
  (when-not @server
    (println "백엔드 서버 포트 3000 에서 시작")
    (reset! server (jetty/run-jetty #'app {:port 3000 :join? false}))))

(defn stop-server []
  (when @server
    (println "서버 중단")
    (.stop @server)
    (reset! server nil)))

(defn restart-server []
  (stop-server)
  (start-server))


;; (start-server)
