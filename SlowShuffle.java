package A2Practical;
import java.util.Arrays;
import java.util.Random;

public class SlowShuffle {

    private static final Random rand = new Random();

    /* -------------------------------------------------
     * 1. slowshuffle (improved very bad method)
     * ------------------------------------------------- */
    public static int[] slowshuffle(int N) {
        int[] shuffled = new int[N];
        boolean[] isNotPresent = new boolean[N + 1];

        // initially all values are not present
        for (int i = 1; i <= N; i++) {
            isNotPresent[i] = true;
        }

        int i = 0;

        // generate first N-1 numbers
        while (i < N - 1) {
            int r = rand.nextInt(N) + 1; // [1..N]

            if (isNotPresent[r]) {
                shuffled[i] = r;
                isNotPresent[r] = false;
                i++;
            }
        }

        // find the last remaining number efficiently
        for (int r = 1; r <= N; r++) {
            if (isNotPresent[r]) {
                shuffled[N - 1] = r;
                break;
            }
        }

        return shuffled;
    }
}
