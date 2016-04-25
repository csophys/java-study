package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;

/**
 * Created by csophys on 16/4/25.
 */
public class FreemarkerDemo {

    public static void main(String[] args) throws IOException {
        //1.配置ftl 目录
        Configuration configuration = configureFTLDirecotry();

        //2.金额测试
        AmountFTL(configuration);
    }

    private static void AmountFTL(Configuration configuration) throws IOException {
        Template template = null;
        try {
            template = configuration.getTemplate("amount.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put("amount", 1234567);
        map.put("amountStr", "1234567");
        Writer writer = new OutputStreamWriter(new FileOutputStream("amount.txt"));
        try {
            template.process(map, writer);
            writer.flush();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    private static Configuration configureFTLDirecotry() {
        Configuration configuration = new Configuration();
        try {
            File file = new File("");
            configuration.setDirectoryForTemplateLoading(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configuration;
    }
}
