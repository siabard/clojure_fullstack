(ns backend.routes
  (:require [compojure.core :refer :all]
            [ring.middleware.cors :refer [wrap-cors]]))

(defroutes api-routes
  (GET "/api/hello" [] "HELLO. I'm API9"))

(def app 
  (wrap-cors api-routes 
             :access-control-allow-origin [#".*"]
             :access-control-allow-methods [:get :put :post :delete]))
