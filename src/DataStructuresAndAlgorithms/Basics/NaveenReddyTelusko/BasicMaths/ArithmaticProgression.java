package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

public class ArithmaticProgression {

        public static int sumAP(int a, int d, int n) {

            int sum = n * (2 * a + (n - 1) * d) / 2;

            return sum;
        }

        public static void main(String[] args) {

            int a = 3;   // first term
            int d = 3;   // common difference
            int n = 10;  // number of terms

            int result = sumAP(a, d, n);

            System.out.println("Sum of AP = " + result);
        }
    }
