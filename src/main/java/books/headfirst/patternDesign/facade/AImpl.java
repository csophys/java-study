package books.headfirst.patternDesign.facade;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by csophys on 16/7/9.
 */
public class AImpl implements A {
    @Override
    public List<String> getName() {
        return Lists.newArrayList("chensheng");
    }
}
