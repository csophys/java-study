package books.headfirst.patternDesign.facade;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csophys on 16/7/9.
 */
public class SimpleFacadeImpl implements SimpleFacade {
    @Override
    public List<String> getName() {
        ArrayList<String> list = Lists.newArrayList();
        list.addAll(new AImpl().getName());
        list.addAll(new BImpl().getName());
        list.addAll(new CImpl().getName());
        return list;
    }
}
