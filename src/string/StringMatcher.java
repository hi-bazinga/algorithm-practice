package string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class StringMatcher {

    public static void main(String[] args) {
        String a = "abceddaccae";
        String b = "dac";
        //BF(a, b);
        RK(a, b);
    }

    public static void BF(String a, String b) {
        int pos = -1;
        for (int i = 0; i < a.length() - b.length() && pos == -1; i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    break;
                }
                if (j == b.length() - 1) {
                    pos = i;
                }
            }
        }
        System.out.println(pos == -1 ? "No matching substring!" : "Match! index: " + pos);
    }

    /**
     * Suppose we only have lower-case letter, eg. abcedfsfhksjhvkew
     */
    public static void RK(String a, String b) {
        int pos = -1;

        // calulate hash for b
        int bHash = 0;
        for (int i = 0; i < b.length(); i ++) {
            bHash += hashChar(b.charAt(i), i, b.length());
        }
        System.out.println("B hash: " + bHash);

        // build hash map for a
        int sumHash = 0;
        int lastFirstHash = 0;

        for (int i = 0; i < a.length() - b.length(); i ++) {
            int firstHash = hashChar(a.charAt(i), 0, b.length());
            if (i == 0) {
                for (int j = 1; j < b.length(); j ++) {
                    sumHash += hashChar(a.charAt(i + j), j, b.length());
                }
                sumHash += firstHash;
            } else {
                // reuse previous hash result
                sumHash = (sumHash - lastFirstHash) * 26 + (a.charAt(i + b.length() - 1) - 'a' + 1);
            }
            //System.out.println("hash: " + sumHash);
            lastFirstHash = firstHash;
            if (sumHash == bHash) {
                pos = i;
                break;
            }
        }
        System.out.println(pos == -1 ? "No matching substring!" : "Match! index: " + pos);
    }

    private static int hashChar(Character chr, int index, int patternLength) {
        return (chr - 'a' + 1) * (int) Math.pow(26, patternLength - index - 1);
    }
}