package books.headfirst.patternDesign.facade;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by csophys on 16/7/9.
 */
public class CImpl implements C {
    @Override
    public List<String> getName() {
        return Lists.newArrayList("csophys");
    }
}
