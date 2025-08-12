import java.util.*;

public class IndianCoinChange {

    public static void findMinCoins(int amount) {
        int[] denominations = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        List<Integer> result = new ArrayList<>();

        for (int coin : denominations) {
            while (amount >= coin) {
                amount -= coin;
                result.add(coin);
            }
        }

        // Output the result
        System.out.println("Coins used to make the amount:");
        for (int coin : result) {
            System.out.print(coin + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount: ");
        int amount = scanner.nextInt();

        findMinCoins(amount);
	   scanner.close();
    }
}
