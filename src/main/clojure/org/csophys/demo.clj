(ns org.csophys.demo)
(use 'org.csophys.fileUtils.fileSearch)

(println (search-files-in-directory ".*png" "/Users/csophys/Desktop"))

(comment (reverse
           (list
             (+ 1
                (- 4 2))
             3)))




