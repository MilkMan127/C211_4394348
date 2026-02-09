package A2Practical;

import java.util.HashMap;
import java.util.Map;

    public class Question2C {

        static int N = 3;
        static int TRIALS = 60000;

        public static void main(String[] args) {
            System.out.println("Biased shuffle results:");
            testShuffle(true);

            System.out.println("\nUnbiased shuffle results:");
            testShuffle(false);
        }

        private static void testShuffle(boolean biased) {
            Map<String, Integer> counts = new HashMap<>();


            String[] perms = {
                    "123", "132", "213", "231", "312", "321"
            };
            for (String p : perms) {
                counts.put(p, 0);
            }


            for (int t = 0; t < TRIALS; t++) {
                int[] B = {1, 2, 3};

                if (biased) {
                    biasedShuffle(B);
                } else {
                    unbiasedShuffle(B);
                }

                String key = "" + B[0] + B[1] + B[2];
                counts.put(key, counts.get(key) + 1);
            }


            for (String p : perms) {
                System.out.println(p + " : " + counts.get(p));
            }
        }


        private static void biasedShuffle(int[] B) {
            for (int i = 0; i < B.length; i++) {
                int r = (int)(Math.random() * B.length);
                swap(B, i, r);
            }
        }


        private static void unbiasedShuffle(int[] B) {
            for (int i = 0; i < B.length; i++) {
                int r = i + (int)(Math.random() * (B.length - i));
                swap(B, i, r);
            }
        }

        private static void swap(int[] B, int i, int j) {
            int temp = B[i];
            B[i] = B[j];
            B[j] = temp;
        }
    }
    //When the unbiased shuffling method was applied 60000 times for 𝑁=3
//N=3, each of the six possible permutations appeared approximately 10000 times. The small differences between counts are consistent with random variation and indicate that no permutation is favoured. In contrast, the alternative method produced noticeably uneven frequencies, with some permutations occurring significantly more often than others.
// This experimental result demonstrates that the method is unbiased, while the other efficient method is biased.


