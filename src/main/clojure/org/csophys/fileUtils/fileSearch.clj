(ns org.csophys.fileUtils.fileSearch
  (:gen-class
    :methods [[searchFilesInDirectory [String String] void]]))

(defn -searchFilesInDirectory [reg-str dirName]
  (filter #(re-matches (re-pattern reg-str) %)
          (map #(.getName %)
               (tree-seq #(.isDirectory %) #(.listFiles %) (clojure.java.io/file dirName)))))
