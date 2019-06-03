package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] stringAsChars;
		stringAsChars = string.toCharArray();
		char[] revStringAsChars = new char[stringAsChars.length];
		for (int iter = 0; iter < stringAsChars.length; iter++)
		{
			revStringAsChars[iter] = stringAsChars[stringAsChars.length - iter -1];
		}
		String revString = new String(revStringAsChars);
		
		return revString.intern();
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String phraseSpaced = phrase.replace('-', ' ');
		phraseSpaced = phraseSpaced.replace('_', ' ');
		String[] phraseSplit = phraseSpaced.split(" ");
		char[] acronymChars = new char[phraseSplit.length];
		for (int iter = 0; iter < acronymChars.length; iter++)
		{
			acronymChars[iter] = phraseSplit[iter].charAt(0);
		}
		String acronym = new String(acronymChars).toUpperCase().intern();
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (this.sideOne == this.sideTwo && this.sideOne == this.sideThree) return true;
			return false;
		}

		public boolean isIsosceles() {
			if (this.isScalene()) return false;
			return true;
		}

		public boolean isScalene() {
			if (this.sideOne != this.sideTwo && this.sideOne != this.sideThree && this.sideTwo != this.sideThree) return true;
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		char cur = '\0';
		char[] stringToChar = string.toUpperCase().toCharArray();
		for (int iter = 0; iter < stringToChar.length; iter++)
		{
			cur = stringToChar[iter];
			switch (cur)
			{
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'L':
			case 'N':
			case 'R':
			case 'S':
			case 'T':
				score += 1;
				break;
			case 'D':
			case 'G':
				score += 2;
				break;
			case 'B':
			case 'C':
			case 'M':
			case 'P':
				score += 3;
				break;
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				score += 4;
				break;
			case 'K':
				score += 5;
				break;
			case 'J':
			case 'X':
				score += 8;
				break;
			case 'Q':
			case 'Z':
				score += 10;
				break;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException{
		int cindex = 0;
		char[] stringAsChars = string.toCharArray();
		char[] cleanStringAsChars = new char[stringAsChars.length];
		String output;
		for (int sindex = 0; sindex < stringAsChars.length; sindex++)
		{
			if (stringAsChars[sindex] <= '9' && stringAsChars[sindex] >= '0')
			{
				cleanStringAsChars[cindex] = stringAsChars[sindex];
				cindex++;
			} else if(stringAsChars[sindex] != '-' && stringAsChars[sindex] != '+' && stringAsChars[sindex] != '.' && stringAsChars[sindex] != ' ' && stringAsChars[sindex] != '(' && stringAsChars[sindex] != ')') throw new IllegalArgumentException();
		}
		output = new String(cleanStringAsChars).trim();
		if (output.length() > 10 && output.charAt(0) == '1') output = output.substring(1);
		if (output.length() > 10) throw new IllegalArgumentException();
		return output;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		HashMap<String, Integer> output = new HashMap<String, Integer>();
		char[] stringAsChars = string.toLowerCase().toCharArray();
		for (int iter = 0; iter < stringAsChars.length; iter++)
		{
			if (stringAsChars[iter] != '-' && (stringAsChars[iter] < 'a' || stringAsChars[iter] > 'z') && (stringAsChars[iter] < '0' || stringAsChars[iter] > '9'))
			{
				stringAsChars[iter] = ' ';
			}	
		}
		String splString = new String(stringAsChars);
		String[] postSplit = splString.split(" +");
		int value = 0;
		for (String str : postSplit)
		{
			if (str.length() > 0 && output.containsKey(str))
			{
				value = output.get(str)+1;
				output.replace(str, value);
			}
			else 
			{
				value = 1;
				output.put(str, value);
			}
		}
		
		return output;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// Priming my loop
			int left = 0;
			int right = sortedList.size()-1;
			int mid = (left + right)/2;
			if (sortedList.get(left) == t) return left;
			if (sortedList.get(right) == t) return right;
			
			T current = sortedList.get(mid);
			int compval = 0;
			while (mid != left && mid != right)
			{
				current = sortedList.get(mid);
				compval = current.compareTo(t);
				if (compval == 0) 
				{
					return mid;
				}
				if (compval < 0) 
				{
					left = mid;
					mid = (left+right)/2;
				}
				else
				{
					right = mid;
					mid = (left+right)/2;
				}
			}
			
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String[] splitString = string.toLowerCase().split(" +");
		String[] splitPig = new String[splitString.length];
		char[] working = null;
		char[] nuWorking = null;
		for (int iter = 0; iter < splitString.length; iter ++)
		{
			working = splitString[iter].toCharArray();
			if (working[0] == 'a' || working[0] == 'e' || working[0] == 'i' || working[0] == 'o' || working[0] == 'u')
			{
				nuWorking = new char[working.length+2];
				for (int metaiter = 0; metaiter < working.length; metaiter++)
				{
					nuWorking[metaiter] = working[metaiter];
				}
				nuWorking[nuWorking.length-2] = 'a';
				nuWorking[nuWorking.length-1] = 'y';
			}
			else if (working[0] == 't') {
				if (working[1] == 'h') {
					nuWorking = (splitString[iter].substring(2) + "thay").toCharArray();
				}
				else {
					nuWorking = (splitString[iter].substring(1) + "tay").toCharArray();
				}
			} else if (working[0] == 's')
			{
				if (working [1] == 'h') {
					nuWorking = (splitString[iter].substring(2) + "shay").toCharArray();
				}
				else if(working [1] == 'c' && working[2] == 'h') {
					nuWorking = (splitString[iter].substring(3) + "schay").toCharArray();
				}
			} else if (working[0] == 'q')
			{
				if (working [1] == 'u') 
				{
					nuWorking = (splitString[iter].substring(2) + "quay").toCharArray();
				}
			} else {
				nuWorking = (splitString[iter].substring(1) + ((Character)(working[0])).toString() + "ay").toCharArray();
			}
			splitPig[iter] = new String(nuWorking);
			
		}
		
		String igpayAtinlay = "";
		for (int iter = 0; iter < splitPig.length; iter++)
		{
			igpayAtinlay = igpayAtinlay + splitPig[iter] + " ";
		}
		
		return igpayAtinlay.trim();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		if (input < -10) return false;
		if (input < 10) return true;
		int sum = 0;
		int power = (int) Math.log10(input) + 1;
		int inputUsed = input;
		while (inputUsed > 0)
		{
			sum += (int)Math.pow((inputUsed%10), power);
			inputUsed /= 10;
		}
		if (sum == input) return true;
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Integer> calculatePrimeFactorsOf(long l) {
		ArrayList<Integer> pfactors = new ArrayList<Integer>();
		int primeScale = (int)Math.sqrt(l);
		
		//sieve for prime numbers
		int[] primes = new int[primeScale];
		int testval;
		int metaiter;
		
		primes[0] = 2;
		for (int iter = 1; iter < primeScale; iter++)
		{
			testval = primes[iter-1] + 1;
			for (metaiter = 0; metaiter < iter-1; metaiter++)
			{
				if (testval % primes[metaiter] == 0) 
				{
					testval ++;
					metaiter = 0;
				}
			}
			primes[iter] = testval;
		}
		
		long cur = l;
		for (int iter = 0; iter < primeScale; iter++)
		{
			while (cur % primes[iter] == 0)
			{
				pfactors.add(primes[iter]);
				cur /= primes[iter];
			}
			cur = l;
		}
		
		if (pfactors.isEmpty()) pfactors.add((int)l);
		
		return pfactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			char[] strAsChars = string.toCharArray();
			for (int iter = 0; iter < strAsChars.length; iter++)
			{
				if (strAsChars[iter] + this.key > 'Z' && strAsChars[iter] <= 'Z') strAsChars[iter] += -26 + this.key;
				else if (strAsChars[iter] <= 'z' && strAsChars[iter] + this.key > 'z') strAsChars[iter] += -26 + this.key;
				else if (strAsChars[iter] >= 'A' && strAsChars[iter] <= 'Z') strAsChars[iter] += this.key;
				else if (strAsChars[iter] >= 'a' && strAsChars[iter] <= 'z') strAsChars[iter] += this.key;				
			}
			return new String(strAsChars).intern();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) throws IllegalArgumentException{
		if (i <= 0) throw new IllegalArgumentException();
		
		//time to build a sieve
		int[] primes = new int[i];
		int testval;
		int metaiter;
		
		primes[0] = 2;
		for (int iter = 1; iter < i; iter++)
		{
			testval = primes[iter-1] + 1;
			for (metaiter = 0; metaiter < iter-1; metaiter++)
			{
				if (testval % primes[metaiter] == 0) 
				{
					testval ++;
					metaiter = 0;
				}
			}
			primes[iter] = testval;
		}
		return primes[primes.length-1];
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			char[] stringAsChars = string.toLowerCase().toCharArray();
			char[] outChars = new char[stringAsChars.length*2];
			int oiter = 0;
			for (int iter = 0; iter < stringAsChars.length; iter++)
			{
				if(oiter != 0 && oiter % 6 == 5)
				{
					outChars[oiter] = ' ';
					oiter++;
				}
				if(stringAsChars[iter] >= 'a' && stringAsChars[iter] <= 'z')
				{
					outChars[oiter] = (char)((char)26 - (stringAsChars[iter]-'a')+'a'-(char)1);
					oiter ++;
				}
				if(stringAsChars[iter] >= '0' && stringAsChars[iter] <= '9')
				{
					outChars[oiter] = stringAsChars[iter];
					oiter++;
				}
			}
			return new String(outChars).trim().intern();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			char[] stringAsChars = string.toLowerCase().toCharArray();
			char[] outChars = new char[stringAsChars.length];
			int oiter = 0;
			for (int iter = 0; iter < stringAsChars.length; iter++)
			{
				if(stringAsChars[iter] >= 'a' && stringAsChars[iter] <= 'z')
				{
					outChars[oiter] = (char)((char)26 - (stringAsChars[iter]-'a')+'a'-(char)1);
					oiter ++;
				}
				if(stringAsChars[iter] >= '0' && stringAsChars[iter] <= '9')
				{
					outChars[oiter] = stringAsChars[iter];
					oiter++;
				}
			}
			return new String(outChars).trim().intern();
		}
	}
	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
		public boolean isValidIsbn(String string) {
			if (string.length() != 13) return false;
			
			int sum = 0;
			char[] stringAsChars = string.toCharArray();
			
			int metaiter = 10;
			for (int iter = 0; iter < string.length(); iter++)
			{
				if (iter == 1 || iter == 5 || iter == 11) {
					if (stringAsChars[iter] != '-') return false;
				}
					
				else if (stringAsChars[iter] == 'X')
				{
					sum += 10*metaiter;
					metaiter--;
				}
				else if((int)(stringAsChars[iter] - '0') < 10)
				{
					sum += (int)(stringAsChars[iter] - '0')*metaiter;
					metaiter--;
				}
				else return false;
			}
			if (sum % 11 == 0) return true;
			
			return false;
		}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
		public boolean isPangram(String string) {
			String stringLow = string.toLowerCase();
			HashSet<Character> alpha = new HashSet<Character>();
			for (char iter = 'a'; iter <= 'z'; iter++)
			{
				alpha.add(iter);
			}
			
			char cur = '\0';
			for (int siter = 0; siter < string.length(); siter++)
			{
				cur = stringLow.charAt(siter);
				if (alpha.contains(cur)) alpha.remove(cur);
				if (alpha.isEmpty()) return true;
				cur = '\0';
			}
			
			return false;
		}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
		public Temporal getGigasecondDate(Temporal given) {
			if (given.isSupported(ChronoField.SECOND_OF_MINUTE) == false)
			{
				LocalTime t = LocalTime.of(0, 0, 0, 0);
				LocalDateTime g = LocalDateTime.of((LocalDate) given, t);

				return Duration.ofSeconds(1000000000).addTo(g);			
			}
			return Duration.ofSeconds(1000000000).addTo(given);
		}


	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		HashSet<Integer> multiples = new HashSet<Integer>();
		int sum = 0;
		
		for (int iter = 1; iter < i; iter++)
		{
			for (int metaiter = 0; metaiter < set.length; metaiter++)
			{
				if (iter % set[metaiter] == 0) multiples.add(iter);
			}
		}
		
		for (Integer s : multiples)
		{
			sum += s;
		}
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		if (string.length() < 1) return false;
		
		char[] stringAsCArr = string.toCharArray();
		int sum = 0;
		int cur = 0;
		int metaiter = 1;
		for (int iter = 0; iter < stringAsCArr.length; iter ++)
		{
			if (stringAsCArr[iter] != ' ')
			{
				cur = (int)(stringAsCArr[iter] - '0');
				if (cur < 0 || cur > 9) return false;
				if (metaiter % 2 == 0) cur *= 2;
				if (cur > 9) cur -= 9;
				sum += cur;
				
				metaiter++;
			}
		}
		if (sum % 10 == 0) return true;
		
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string){
		String[] tokens = string.split(" +");
		ArrayList<String> tknAL = new ArrayList<String>();
		int left = 0;
		int right = 0;
		byte op = 0x00;
		
		for (String t : tokens)
		{
			tknAL.add(t);
		}
		//if (tknAL.get(0).toLowerCase().trim() != "what" || tknAL.get(1).toLowerCase().trim() != "is") return Integer.MIN_VALUE; 
		tknAL.remove(0);
		tknAL.remove(0);
		
		left = Integer.decode(tknAL.get(0));
		tknAL.remove(0);
		
		if (tknAL.get(0).toLowerCase().trim().equals("plus"))
		{
			op ^= 0x01;
			tknAL.remove(0);
		} 
		else if (tknAL.get(0).toLowerCase().trim().equals("minus"))
		{
			op ^= 0x02;
			tknAL.remove(0);
		}
		else if (tknAL.get(0).toLowerCase().trim().equals("divided"))
		{
			op ^= 0x04;
			tknAL.remove(0);
			tknAL.remove(0);
		}
		else if (tknAL.get(0).toLowerCase().trim().equals("multiplied"))
		{
			op ^= 0x08;
			tknAL.remove(0);
			tknAL.remove(0);
		}
		

		tknAL.set(0, tknAL.get(0).substring(0, tknAL.get(0).length()-1));
		right = Integer.decode(tknAL.get(0));
		tknAL.remove(0);
		
		if (op == 0x01)
		{
			return left + right;
		}
		if (op == 0x02)
		{
			return left - right;
		}
		if (op == 0x08)
		{
			return left * right;
		}
		if (op == 0x04)
		{
			return left / right;
		}
		
		return 0;
	}



}
