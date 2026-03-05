(ns backend.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.util.response :as response]
            [ring.middleware.cors :refer [wrap-cors]]
            [reitit.ring :as ring]
            [backend.config :as config]
            [backend.routes :refer [app]]))


;; 1. 서버 인스탄스 관리
(defonce server (atom nil))

(defn start-server []
  (when-not @server
    (let [port (:port config/config)]
      (println "백엔드 서버 포트 3000 에서 시작")
      (reset! server (jetty/run-jetty #'app {:port port :join? false})))))

(defn stop-server []
  (when @server
    (println "서버 중단")
    (.stop @server)
    (reset! server nil)))

(defn restart-server []
  (stop-server)
  (start-server))


;; (start-server)
