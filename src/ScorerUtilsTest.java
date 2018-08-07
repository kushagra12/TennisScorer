import org.junit.Assert;
import org.junit.Test;

public class ScorerUtilsTest {

    public static final String testCase = "AAAAAAABBABBBAAABBAAAAAAAAAAAAB";

    @Test
    public void reduceGamesTest(){
        Assert.assertEquals("AA#B", ScorerUtils.reduce("ABABAABAAAAB", 4));
    }

    @Test
    public void reduceGamesComplexTest(){
        String games = ScorerUtils.reducePointsToGames(testCase);
        Assert.assertEquals("AABAAAA#B", games);
        String sets = ScorerUtils.reduceGamesToSets(games);
        Assert.assertEquals("A##B", sets);
    }
}
