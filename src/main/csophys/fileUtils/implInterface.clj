(ns org.csophys.fileUtils.implInterface)

(gen-class :name TstAppender :extends org.apache.log4j.AppenderSkeleton)

(defn -append [this event]
  (println (.getMessage event)))

(defn -close [this]) ;nothing to clean up

(defn -requireLayout [this] false)
