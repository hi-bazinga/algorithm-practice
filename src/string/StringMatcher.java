package string;

public class StringMatcher {

    public static void main(String[] args) {
        String a = "abceddaccae";
        String b = "dca";
        BF(a, b);
    }

    public static int BF(String a, String b) {
        for (int i = 0; i < a.length() - b.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    break;
                }
                if (j == b.length() - 1) {
                    System.out.println("Match! Index: " + i);
                    return j;
                }
            }
        }
        System.out.println("No matching substring!");
        return -1;
    }

    public static void RK(String a, String b) {

    }
}