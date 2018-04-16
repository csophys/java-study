package books.headfirst.patternDesign.builder;

/**
 * Created by csophys on 2018/4/16.
 */
public class ScrumTeamBuilder implements TeamBuilder{

    private Team team = new Team();

    @Override
    public void buildRD() {
        team.setRdNum(5);
    }

    @Override
    public void buildPM() {
        team.setPmNum(1);
    }

    @Override
    public void buildQA() {
        team.setQaNum(3);
    }

    @Override
    public Team getTeam() {
        return team;
    }
}
