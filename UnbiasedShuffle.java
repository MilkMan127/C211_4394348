import java.util.Random;
public class UnbiasedShuffle {
    public static int[] shuffle(int N) {

        int[] a = new int[N];


        for (int i = 0; i < N; i++) {
            a[i] = i + 1;
        }
        Random rand = new Random();
        for (int i = 0; i < N - 1; i++) {
            int j = i + rand.nextInt(N - i); // [i..N-1]
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return a;

    }
}