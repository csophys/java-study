(ns org.csophys.fileUtils.fileSearch)

(defn search-files-in-directory [reg dirName]
  (filter #(re-matches reg %)
          (map #(.getName %)
               (tree-seq #(.isDirectory %) #(.listFiles %) (clojure.java.io/file dirName)))))
