package A2Practical;

import java.util.Random;
public class BiasedShuffle {
public static int[] biasedshuffle(int N) {
    int[] a = new int[N];

    // initialise array
    for (int i = 0; i < N; i++) {
        a[i] = i + 1;
    }

    Random rand = new Random();

    for (int i =0 ; i<N; i++){
        int r = rand.nextInt(N);
        int temp = a[i];
        a[i]=a[r];
        a[r]= temp;
    }

    return a;
}}