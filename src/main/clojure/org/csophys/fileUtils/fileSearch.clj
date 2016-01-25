(ns org.csophys.fileUtils.fileSearch)

(defn search-files-in-directory [reg-str dirName]
  (filter #(re-matches (re-pattern reg-str) %)
          (map #(.getName %)
               (tree-seq #(.isDirectory %) #(.listFiles %) (clojure.java.io/file dirName)))))
