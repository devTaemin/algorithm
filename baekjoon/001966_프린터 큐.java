import java.io.*;
import java.util.*;

class Doc {
    int index;
    int level;

    public Doc(int index, int level) {
        this.index = index;
        this.level = level;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        StringTokenizer st = null;
        Queue<Doc> queue = null;
        ArrayList<Integer> top = null;

        // 테스트케이스 수
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            queue = new ArrayDeque<Doc>();
            top = new ArrayList<Integer>();

            // 문서의 수, 인덱스
            st = new StringTokenizer(br.readLine());
            int numOfDoc = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            // 문서 상태
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < numOfDoc; j++) {
                int doc = Integer.parseInt(st.nextToken());
                queue.add(new Doc(j, doc));
                top.add(doc);
            }

            // 작업
            Collections.sort(top, Collections.reverseOrder());
            int count = 0;
            while (!queue.isEmpty()) {
                Doc doc = queue.poll();
                int index = doc.index;
                int level = doc.level;

                if (level < top.get(0)) {
                    queue.add(doc);
                } else {
                    count++;
                    top.remove(0);

                    if (index == target) break;
                }
            }

            builder.append(count + "\n");
        }

        String answer = builder.toString();
        System.out.println(answer);
    }
}
