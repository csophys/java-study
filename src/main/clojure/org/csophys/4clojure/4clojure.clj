(ns org.csophys.4clojure.4clojure)

;28
(filter (complement sequential?) (tree-seq sequential? identity '(1 2 3 [1 3 (12 [1 3] 3)] 3)))

;39
((fn [s1 s2] (reverse (loop [result '() remain-s1 s1 remain-s2 s2]
                        (if (not (last remain-s1)) result (recur (conj result (first remain-s1) (first remain-s2)) (rest remain-s1) (rest remain-s2)))))) [2 3] [6 73 3 4])


#(reverse (loop [a %1 b %2 result '()]
            (if (or (= 0 (count b) (= 0 (count a)))) result  (recur (rest a) (rest b) (conj result (first a) (first b))))))