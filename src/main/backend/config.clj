(ns backend.config)

;; System/getenv 로 환경변수값을 읽어들임 
(def config
  {:db-url (or (System/getenv "DATABASE_URL") "")
   :secret-key (or (System/getenv "SECRET_KEY") "")
   :port (if-let [p (System/getenv "PORT")]
           (Integer/parseInt p)
           3000)
   })
