import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class ForegoneSolution {

	public static void main(String[] args) {
		Scanner in = createScaner();

		int testCases;

		testCases = in.nextInt();
		in.nextLine();

		for (int i = 1; i <= testCases; i++) {
			String N = in.nextLine();
			solve(i, N);
		}
	}

	private static void solve(int testCase, String N) {
		ArrayList<Integer> A, B;
		A = new ArrayList<>();
		B = new ArrayList<>();

		boolean isDigitFourFound = false;

		for (char c : N.toCharArray()) {
			int digit = c - 48;
			if (digit == 4) {
				A.add(2);
				B.add(2);
				isDigitFourFound = true;
			} else {
				A.add(digit);
				if (isDigitFourFound) {
					B.add(0);
				}
			}
		}

		System.out.print("Case #" + testCase + ": ");

		for (int digit : A) {
			System.out.print(digit);
		}

		System.out.print(" ");

		if (B.size() == 0) {
			System.out.println(0);
			return;
		}

		for (int digit : B) {
			System.out.print(digit);
		}

		System.out.println();
	}

	public static Scanner createScaner() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		return sc;
	}
}
