import java.util.*;

public class MaxAcivityWhenNotSorted {
	public static void main(String[] args) {
		int start[] = {1, 3, 0, 5, 8, 5};
		int end[] = {2, 4, 6, 7, 9, 9};

		int n = start.length;
		int[][] activities = new int[n][3];

		for (int i = 0; i < n; i++) {
			activities[i][0] = i;
			activities[i][1] = start[i];
			activities[i][2] = end[i];
		}

		Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));

		int maxAct = 1;
		ArrayList<Integer> ans = new ArrayList<>();

		ans.add(activities[0][0]);
		int lastEnd = activities[0][2];

		for (int i = 1; i < n; i++) {
			if (activities[i][1] >= lastEnd) {
				maxAct++;
				ans.add(activities[i][0]);
				lastEnd = activities[i][2];
			}
		}

		System.out.println("Max Activities = " + maxAct);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println("A" + ans.get(i) + " ");
		}
		System.out.println();
	}
}
