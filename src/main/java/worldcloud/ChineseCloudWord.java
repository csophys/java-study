package worldcloud;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.font.FontWeight;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.image.AngleGenerator;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ChineseCloudWord {
    static String text="test\ntest1";
    public static void main(String[] args) {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        Collection<String> stopWorld = new ArrayList<>();
        frequencyAnalyzer.setStopWords(stopWorld);
        frequencyAnalyzer.setMinWordLength(3);
        String[] textList = text.split("\n");
        //处理文本之间的相似度。

        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(Arrays.asList(textList));
        final Dimension dimension = new Dimension(1000, 600);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(5);
        wordCloud.setKumoFont(new KumoFont("monospace", FontWeight.BOLD));
        wordCloud.setBackground(new RectangleBackground(dimension));
        //设置背景色
        wordCloud.setBackgroundColor(new Color(251, 179, 163));
        wordCloud.setColorPalette(new ColorPalette(new Color(11,67,144), new Color(7,46,143), new Color(15,38,144), new Color(17,100,135)));

        //调整最大字体和最小字体之间的大小
        wordCloud.setFontScalar(new SqrtFontScalar(10, 100));
        //调整文字放置的方向。
        wordCloud.setAngleGenerator(new AngleGenerator(0,0,2));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("kumo-core/1.png");
    }
}

