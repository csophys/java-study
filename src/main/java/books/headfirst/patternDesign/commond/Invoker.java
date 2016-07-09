package books.headfirst.patternDesign.commond;

import lombok.Data;

/**
 * Created by csophys on 16/7/9.
 */

@Data
public class Invoker {
    private ICommond commond;

    public void fire(){
        commond.execute();
    }

    public void cancel(){
        commond.undo();
    }
}
