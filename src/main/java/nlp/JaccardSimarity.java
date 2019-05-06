package nlp;

import org.apache.commons.text.similarity.JaccardSimilarity;

public class JaccardSimarity {

    public static void main(String[] args) {
        JaccardSimilarity jaccardSimilarity = new JaccardSimilarity();
        System.out.println(jaccardSimilarity.apply("骑手还没有送达了", "骑手还没有送达"));
    }
}
