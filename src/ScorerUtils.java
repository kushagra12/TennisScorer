public class ScorerUtils {

    private static final char PLAYER_A = 'A';
    private static final char Player_B = 'B';

    public static String reduce(String points, int minGames){
        StringBuilder games = new StringBuilder();

        int aPoints = 0;
        int bPoints = 0;

        int cutoff = -1;
        char[] pointsArr = points.toCharArray();

        for(int i = 0; i < pointsArr.length; i++){
            if(pointsArr[i] == PLAYER_A)
                aPoints++;
            else
                bPoints++;

            if(Math.max(aPoints, bPoints) >= minGames && Math.abs(aPoints - bPoints) > 1){
                cutoff = i;
                games.append((aPoints > bPoints) ? "A":"B");
                aPoints = bPoints = 0;
            }
        }


        return games.toString() + "#" + points.substring(cutoff + 1);
    }


    public static String reducePointsToGames(String points){
        return reduce(points, 4);
    }

    public static String reduceGamesToSets(String games){
        String[] gamesList = games.split("#");
        String sets = reduce(gamesList[0], 6) + "#";

        if(gamesList.length > 1)
            sets += gamesList[1];

        return sets;
    }

    public static void printPoints(String points){
        String[] arr={"0","15","30","De","Ad"};

        int aPoints = 0;
        int bPoints = 0;

        for(char p : points.toCharArray()) {
            if (p == PLAYER_A)
                aPoints++;
            else
                bPoints++;
        }

        if(Math.min(aPoints, bPoints) >= 4) {
            if (aPoints == bPoints)
                System.out.println("DEUCE");
            else if (Math.abs(bPoints - aPoints) == 1)
                System.out.println((aPoints > bPoints) ? "ADV" : "   ADV");
        }
        else
            System.out.println(arr[aPoints] + " " + arr[bPoints]);
    }


    public static void printScores(String games){
        int aGames = 0;
        int bGames = 0;

        for(char g : games.toCharArray()){
            if(g == PLAYER_A)
                aGames++;
            else
                bGames++;
        }


        System.out.println(aGames + " " + bGames);
    }
}
