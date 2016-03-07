(ns org.csophys.textProcess.fileInputAndGenerateSQL)


;;返回所有的文本内容的二维数组
(with-open [reader (clojure.java.io/reader "/Users/csophys/Desktop/1.csv")]
  (loop [text '() line (.readLine reader)]
    (if (= line nil)
      text
      (recur (conj text (clojure.string/split line #";")) (.readLine reader)))
    )
  )