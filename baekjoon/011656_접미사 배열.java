import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    String word;
    int index;

    public Node(String word, int index) {
        this.word = word;
        this.index = index;
    }

    @Override
    public int compareTo(Node other) {
        return this.word.compareTo(other.word);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // (1) 각 요소로 자른 배열을 만들자
        char[] input = br.readLine().toCharArray();
        int len = input.length;

        ArrayList<Node> list = new ArrayList<Node>();
        for (int i = 0; i < len; i++) {
            char[] slice = Arrays.copyOfRange(input, i, len);
            list.add(new Node(new String(slice), i));
        }

        Collections.sort(list);
        for (Node node : list) {
            System.out.println(node.word);
        }
    }
}
