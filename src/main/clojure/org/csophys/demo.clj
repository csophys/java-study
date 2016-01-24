(ns org.csophys.demo)
(use 'org.csophys.fileUtils.fileSearch)

(println (search-files-in-directory #".*class" "/Users/csophys/Desktop"))