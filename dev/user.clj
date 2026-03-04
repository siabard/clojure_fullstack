(ns user
  (:require [backend.core :as backend]))

(println "=========================================")
(println "JVM 부팅 완료: user.clj를 자동 실행합니다.")
(println "=========================================")

;; 백엔드 서버 시작 함수를 자동으로 호출합니다.
(backend/start-server)
