import java.io.*;
import java.util.*;

public class Main {
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int numOfTest = Integer.parseInt(br.readLine());

        for (int t = 0; t < numOfTest; t++) {
            char[] words = br.readLine().toCharArray();

            count = 0;
            int result = isPalindrome(words);

            builder.append(result).append(" ").append(count).append("\n");
        }

        System.out.print(builder.toString());
    }

    public static int isPalindrome(char[] words) {
        return recursion(words, 0, words.length - 1);
    }

    public static int recursion(char[] words, int l, int r) {
        count++;

        if (l >= r) return 1;
        else {
            if (words[l] != words[r]) return 0;
            else return recursion(words, l + 1, r - 1);
        }
    }
}
