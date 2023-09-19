//You are given an Integer 'N' you have to convert thr integer to words

import java.util.*;
import java.io.*;

public class Solution {

	// English strings of first 19 numbers

	static String initials[] = { "", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ",
			"ten ", "eleven ",

			"twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen " };

	// English strings till 90 that can't be made with 2 words

	static String seconds[] = { "", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ",
			"ninety " };

	// Function for converting a number less then 100 to string

	public static String convertDigitsUtil(int n, String s) {

		String str = "";

		if (n > 19) {

			str += seconds[n / 10] + initials[n % 10];

		} else {

			str += initials[n];

		}

		if (n != 0) {

			str += s;

		}

		return str;

	}

	public static String handleAll(long n) {
		// Write your code here
		// Initialize answer string

		StringBuilder sb = new StringBuilder();

		// Finding coefficients of crore,lakh,thousand and hundreds

		sb.append(convertDigitsUtil((int) (n / 10000000), "crore "));

		sb.append(convertDigitsUtil((int) ((n / 100000) % 100), "lakh "));

		sb.append(convertDigitsUtil((int) ((n / 1000) % 100), "thousand "));

		sb.append(convertDigitsUtil((int) ((n / 100) % 10), "hundred "));

		if ((n > 100) && (n % 100 != 0)) {

			sb.append("and ");

		}

		// Adding remaining 2 digits

		sb.append(convertDigitsUtil((int) (n % 100), ""));

		return sb.toString();
	}

    
}