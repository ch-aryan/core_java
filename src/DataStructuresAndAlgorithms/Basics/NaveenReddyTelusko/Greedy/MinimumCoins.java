package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Greedy;

public class MinimumCoins {
    public static  int findMin1(int n){
        int arr[] = {10,5,2,1};
        int coins = 0;
        for(int i:arr){

            coins = coins + n / i;
            n = n%i;
        }
        return coins;
    }


        public static int findMin(int n) {

            int currency = n;
            int coins = 0;

            while (currency > 0) {
                if (currency >= 10) {
                    coins += currency / 10;
                    currency = currency % 10;
                } else if (currency >= 5) {
                    coins += currency / 5;
                    currency = currency % 5;
                } else if (currency >= 2) {
                    coins += currency / 2;
                    currency = currency % 2;
                } else {
                    coins += currency; // handle 1
                    break;
                }
            }
            return coins;
        }

    public static void main(String[] args) {

        int min = findMin(39);
        System.out.println(min);

        System.out.println(findMin1(39));

    }
}
/*
🧠 Is your approach correct?

👉 Yes, but only for fixed denominations

Coins you assumed:

10, 5, 2, 1

✔️ For this system → greedy works perfectly

⚠️ But here’s the important limitation

Your approach is hardcoded

👉 If coins change:

[1, 3, 4]

Greedy may fail ❌

Example:

n = 6
Greedy → 4 + 1 + 1 = 3 coins
Optimal → 3 + 3 = 2 coins
💡 Better scalable approach

Instead of hardcoding:

int coins[] = {10, 5, 2, 1};

Loop:

for (int coin : coins) {
    coinsUsed += currency / coin;
    currency %= coin;
}

Concept	Status
Greedy idea	✅ correct
Implementation	⚠️ missing edge case
Scalability	❌ hardcoded
🚀 Insight for you

You’re now thinking like:

“Use largest value first to minimize count”

👉 That’s core greedy mindset
 */