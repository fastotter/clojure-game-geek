(ns clojure-game-geek.system
  (:require
    [com.stuartsierra.component :as component]
    [clojure-game-geek.schema :as schema]
    [clojure-game-geek.server :as server]))

(defn new-system
  []
  ; merge literally merges multiple maps into a single map
  ; so each of the three functions is returning a map
  (let
    [sys-map (merge (component/system-map)
                    (server/new-server)
                    (schema/new-schema-provider))]
    (clojure.pprint/pprint sys-map)
    sys-map))
