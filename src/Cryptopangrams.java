import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Cryptopangrams {

	public static void main(String[] args) {
		Scanner in = createScaner();

		int testCases;

		testCases = in.nextInt();
		in.nextLine();

		for (int i = 1; i <= testCases; i++) {
			BigInteger N = in.nextBigInteger();
			int L = in.nextInt();
			BigInteger[] ciphertext = new BigInteger[L];

			for (int j = 0; j < L; j++) {
				ciphertext[j] = in.nextBigInteger();
			}

			solve(i, N, L, ciphertext);
		}
	}

	private static void solve(int testCase, BigInteger n, int l, BigInteger[] ciphertext) {
		BigInteger[] plainText = new BigInteger[ciphertext.length + 1];

		int firstDifferent = findFirstDifferent(ciphertext);

		// find GCD of first two numbers
		// that will be second letter in plain text
		plainText[firstDifferent + 1] = ciphertext[firstDifferent].gcd(ciphertext[firstDifferent + 1]);
		// set first and second letter
		plainText[firstDifferent] = ciphertext[firstDifferent].divide(plainText[firstDifferent + 1]);
		plainText[firstDifferent + 2] = ciphertext[firstDifferent + 1].divide(plainText[firstDifferent + 1]);

		if (firstDifferent != 0) {
			for (int i = firstDifferent; i > 0; i--) {
				plainText[i-1] = ciphertext[i-1].divide(plainText[i]);
			}
		}

		// get the rest of the letters
		for (int i = firstDifferent+2; i < ciphertext.length; i++) {
			plainText[i + 1] = ciphertext[i].divide(plainText[i]);
		}

		// create a map with values and their below assigned chars
		Map<BigInteger, Character> uniqueChars = new TreeMap<>();
		for (BigInteger plainTextChar : plainText) {
			uniqueChars.put(plainTextChar, '#');
		}

		int alphabetChar = 65;
		for (BigInteger plainTextChar : uniqueChars.keySet()) {
			uniqueChars.put(plainTextChar, (char) alphabetChar);
			alphabetChar++;
		}

		StringBuilder solution = new StringBuilder();
		for (BigInteger plainTextChar : plainText) {
			solution.append(uniqueChars.get(plainTextChar));
		}
		
		
//		for (int i = 0 ; i<solution.toString().toCharArray().length;i++) {			
//			char ch = solution.toString().toCharArray()[i];
//			System.out.println(ch + " " + plainText[i]);
//		}
		

		System.out.println("Case #" + testCase + ": " + solution.toString());
	}

	private static int findFirstDifferent(BigInteger[] ciphertext) {
		int firstDifferent = 0;
		for (int i = 1; i < ciphertext.length; i++) {
			if (ciphertext[i - 1].compareTo(ciphertext[i]) != 0) {
				return firstDifferent;
			}
			firstDifferent++;
		}
		return 0;
	}

	public static Scanner createScaner() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		return sc;
	}
}
