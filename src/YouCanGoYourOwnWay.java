import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class YouCanGoYourOwnWay {

	public static void main(String[] args) {
		Scanner in = createScaner();

		int testCases;

		testCases = in.nextInt();
		in.nextLine();

		for (int i = 1; i <= testCases; i++) {
			in.nextInt();
			in.nextLine();

			String L = in.nextLine();
			solve(i, L);
		}
	}

	private static void solve(int testCase, String L) {
		StringBuilder sb = new StringBuilder();
		for (char c : L.toCharArray()) {
			switch (c) {
			case 'E':
				sb.append("S");
				break;
			case 'S':
				sb.append("E");
				break;
			}
		}
		System.out.println("Case #" + testCase + ": " + sb.toString());
	}

	public static Scanner createScaner() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		return sc;
	}
}
