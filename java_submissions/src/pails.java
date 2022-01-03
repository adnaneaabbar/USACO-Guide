import java.util.*;
import java.io.*;

public class pails {
    static class Solver {
        void solve(InputReader in, PrintWriter out) throws Exception {
            // Here goes your code
            int x = in.nextInt();
            int y = in.nextInt();
            int m = in.nextInt();
            int ans = 0;

            for(int xx = 0; xx * x <= m; xx++){
                for(int yy = 0; xx * x + yy * y <= m; yy++){
                    if(xx * x + yy * y > ans) {
                        ans = xx * x + yy * y;
                    }
                }
            }

            out.print(ans);
        }
    }

    public static void main(String... args) throws Exception {
        InputReader in = new InputReader("pails" + ".in");
        PrintWriter out = new PrintWriter("pails" + ".out");
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