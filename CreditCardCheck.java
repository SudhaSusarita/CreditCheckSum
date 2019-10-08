/**
 * Credit card sum check
 * Reverse the digits in the number
 * Sum the odd digits
 * Multiply the even digits with 2 and if their value appears in 2 digits them sum those digits
 * Now add overall even digits
 * Sum both odd and even digits if they are divisible by 10 print yes, else no
 * */
import java.util.Scanner;

class CreditCardCheck {

	public static void main(String[] args) {
		System.out.println("Enter the credit card number");
		Scanner sc = new Scanner(System.in);
		long creditNo = sc.nextLong();
		creditSumCheck(creditNo);
	}

	private static void creditSumCheck(long creditNo) {
		long reversedNum = reverse(creditNo);
		long oddEvenSum = calOddEvenSum(reversedNum);

		if (oddEvenSum != 0 && oddEvenSum % 10 == 0) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

	private static long calOddEvenSum(long reversedNum) {
		String digit = "" + reversedNum;
		char[] digits = digit.toCharArray();
		long sumOdd = 0, sumEven = 0;
		long mulEven = 0, addMul = 0;
		for (int i = 0; i < digits.length; i++) {
			if (i % 2 == 0 || i == 0) {
				sumOdd += Character.getNumericValue(digit.charAt(i));
			} else {
				mulEven = Character.getNumericValue(digit.charAt(i)) * 2;
				if (mulEven / 10 != 0) {

					addMul += mulEven / 10 + mulEven % 10;

					sumEven += addMul;
					addMul = 0;
				} else {
					sumEven += mulEven;

				}
			}
		}
		return sumOdd + sumEven;
	}

	private static long reverse(long creditNo) {
		StringBuilder sb = new StringBuilder("" + creditNo);
		return Long.parseLong(sb.reverse().toString());
	}

}
