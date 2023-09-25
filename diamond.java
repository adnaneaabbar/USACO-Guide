import java.util.*;
import java.io.*;

public class diamond {
    static class Solver {
        void solve(InputReader in, PrintWriter out) throws Exception {
            // Here goes your code
            int n = in.nextInt();
            int k = in.nextInt();
            ArrayList<Integer> diamonds = new ArrayList<Integer>();
            ArrayList<Integer> counts = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                diamonds.add(in.nextInt());
            }
            Collections.sort(diamonds);
            for (int i = 0; i < n; i++) {
                counts.add(count(diamonds, diamonds.get(i), i, k));
            }

            out.print(Collections.max(counts));
        }
    }

    public static int count(ArrayList<Integer> d, int start, int idx, int k) {
        int ans = 1;
        for (int i = idx + 1; i < d.size(); i++) {
            if (d.get(i) - start <= k) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String... args) throws Exception {
        InputReader in = new InputReader("diamond" + ".in");
        PrintWriter out = new PrintWriter("diamond" + ".out");
        new Solver().solve(in, out);
        out.close();
        in.close();
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream is) throws Exception {
            reader = new BufferedReader(new InputStreamReader(is));
        }

        InputReader(String inFilePath) throws Exception {
            this(new FileInputStream(inFilePath));
        }

        InputReader() throws Exception {
            this(System.in);
        }

        String next() throws Exception {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        String nextLine() throws Exception {
            return reader.readLine();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }

        void close() throws Exception {
            reader.close();
        }
    }
}