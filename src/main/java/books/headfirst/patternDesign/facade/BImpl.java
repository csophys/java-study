package books.headfirst.patternDesign.facade;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by csophys on 16/7/9.
 */
public class BImpl implements B {
    @Override
    public List<String> getName() {
        return Lists.newArrayList("carson");
    }
}
