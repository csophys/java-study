package books.headfirst.patternDesign.builder;

/**
 * Created by csophys on 2018/4/16.
 */
public interface TeamBuilder {

    void buildRD();

    void buildPM();

    void buildQA();

    Team getTeam();
}
