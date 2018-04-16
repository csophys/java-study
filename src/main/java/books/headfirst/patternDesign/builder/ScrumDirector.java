package books.headfirst.patternDesign.builder;

/**
 * Created by csophys on 2018/4/16.
 */
public class ScrumDirector {

    public ScrumDirector(TeamBuilder teamBuilder) {
        teamBuilder.buildPM();
        teamBuilder.buildRD();
        teamBuilder.buildQA();
    }
}
