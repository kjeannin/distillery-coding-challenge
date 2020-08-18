package code;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		assert (solution("cccda").length() == 3);
		assert (solution("ababbababcff").length() == 11);
		assert (solution("abcdefgiiiihjj").length() == 7);
		assert (solution("").length() == 0);
		assert (solution("i").length() == 1);

	}

	public static String solution(String S) {
		int N = S.length();
		// Edge cases
		if (N <= 1)
			return S;

		// Convert and sort input
		char[] chars = S.toCharArray();
		Arrays.sort(chars); // O(nlog(n))

		// In case we need to insert a character in the middle
		boolean usedMiddleChar = false;

		// To build our palindrome, max length = N
		StringBuilder pal = new StringBuilder(N);

		// To parse the array, memc is the working character, count is the number of
		// occurence
		// Each time we have 2 occurences of memc, we insert it in our stringbuilder.
		int count = 0;
		char memc = 0;

		for (int i = 0; i < N; i++) { // O(n)
			if (memc == chars[i]) {
				// Same character
				count++;
				if (count == 2) {
					pal.insert(0, memc);
					pal.append(memc);
					count = 0;
				}
			} else {
				// Different character, insert it in the middle if possible
				if (count == 1 && !usedMiddleChar) {
					pal.insert(pal.length() / 2, memc);
					usedMiddleChar = true;
				}
				memc = chars[i];
				count = 1;
			}

		}
		return pal.toString();
	}
}
