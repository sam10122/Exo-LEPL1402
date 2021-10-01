import java.util.Arrays;
public class Valley {
    /**
     * Compute the deepest valley and highest mountain
     *
     * @param slopes A non-empty array of slope
     * @return An array of two element. The first is the
     *         depth of the deepest valley and the second
     *         the height of the highest mountain
     */
    public static int[] valley (int[] slopes){
        int posWalker = 0;
        int negWalker = 0;
        int maxHigh = 0;
        int maxProf = 0;
        int[] laValley = new int[2];
        for(int i = 0; i < slopes.length; i++){
            if(slopes[i] > 0){
                posWalker += slopes[i];
                maxHigh = posWalker;
                negWalker = 0;
                if(maxProf + posWalker <= 0){
                    laValley[0] = max(posWalker,laValley[0]);
                }

            }
            if(slopes[i] < 0){
                negWalker += slopes[i];
                maxProf = negWalker;
                posWalker = 0;
                if(maxHigh + negWalker >= 0){
                    laValley[1] = max(-negWalker,laValley[1]);
                }
            }
        }
        return laValley;
    }

    public static int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }
}
