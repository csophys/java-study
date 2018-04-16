package books.headfirst.patternDesign.builder;

/**
 * Created by csophys on 2018/4/16.
 */
public class ProjectClient {

    public static void main(String[] args) {
        TeamBuilder teamBuilder = new ScrumTeamBuilder();
        new ScrumDirector(teamBuilder);
        System.out.println(teamBuilder.getTeam().getQaNum());
    }
}
