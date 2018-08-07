import java.util.List;

public class Main {

    public static void main(String[] args) {
        String points = "ABABAABAAAAB";
        String gamesWithPoints = ScorerUtils.reducePointsToGames(points);
        String setsWithGames = ScorerUtils.reduceGamesToSets(gamesWithPoints);

        String[] gamesList = setsWithGames.split("#");

        ScorerUtils.printScores(gamesList[0]);
        ScorerUtils.printScores(gamesList[1]);
        ScorerUtils.printPoints(gamesList[2]);

    }
}
