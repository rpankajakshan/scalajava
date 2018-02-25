package uk.co.zentium.langjava;

import java.util.HashMap;
import java.util.Map;

public class Memoization {

    private static Map<Integer, Boolean> cache = new HashMap<>();

    private boolean checkPrimeInner(int x) {
        boolean isPrime = true;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    boolean checkPrime(int x) {
        long now = System.nanoTime();
        if (cache.containsKey(x)) {
            System.out.println("from cache took " + (System.nanoTime() - now));
        } else {
            cache.put(x, checkPrimeInner(x));
            System.out.println("not from cache took " + (System.nanoTime() - now));
        }
        return cache.get(x);
    }

    public static void main(String[] args) {
        Memoization memoization = new Memoization();
        System.out.println(memoization.checkPrime(101));
        System.out.println(memoization.checkPrime(101));
        System.out.println(memoization.checkPrime(500));
        System.out.println(memoization.checkPrime(500));
    }
}