/*
Solution to:
A Secret encapsulates a function that accepts a single integer parameter and returns an integer. 
Secret is a given but you don’t know its implementation. 
In Java or a language of your choice, write an application that determines 
if Secret is an additive function secret(x+y) = secret(x) + secret(y) for all 
combinations of prime numbers less than N where N is also a given.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Secret {

	public static void main(String[] args) {
		System.out.print("working\n");

		Scanner scanner = new Scanner(System.in);
		System.out.print("Eenter a single integer value greater than 0: ");
		int limit = 0;
		String input;

		input = scanner.nextLine();

		limit = Integer.parseInt(input);

		if (limit < 1) {
			System.out.println("Error: "+ input
						+ " is invalid input. A single integer value greater than 0 must be entered.");
			System.exit(0);
		}

		Integer[] primes = getPrimeNumbers(limit);

		System.out.println("\nPrimes under " + limit + ": "+ Arrays.toString(primes));

		if (testSecret(primes)) {
			System.out.println("The function secret() is an additive function for all prime number under "
							+ limit + ".");
		} else {
			System.out.println("The function secret() is not an additive function for all prime number under "
							+ limit + ".");
		}
		scanner.close();

	}

	// function tests the secret() function and returns true if secret(x+y) = secret(x) + secret(y) 
	// for the given prime integer array.
	private static boolean testSecret(Integer[] primes) {
		ArrayList<Integer> passed = new ArrayList<>();

		for (Integer x : primes) {
			for (Integer y : primes) {
				int sumLeft = (x + y);
				int secretLeft = secret(sumLeft);

				int secretX = secret(x);
				int secretY = secret(y);
				int secretRight = (secretX + secretY);

				if (secretLeft != secretRight) {
					return false;
				}
			}
			passed.add(x);
		}
		return true;
	}

	public static int secret(int num) {

		//return num % 3; // not additive function return
		return num; // additive function return
	}

	// generates integer array of primes <= to number
	private static Integer[] getPrimeNumbers(int number) {
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		for (int i = 0; i <= number; i++) {
			if (isPrime(i)) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers.toArray(new Integer[primeNumbers.size()]);
	}

	// returns true if n is a prime number
	private static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
