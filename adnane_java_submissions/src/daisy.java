import java.io.*;
import java.util.StringTokenizer;

public class daisy {
    static class Solver {
        void solve(InputReader in, PrintWriter out) throws Exception {
            // Here goes your code
            int n = in.nextInt();
            int[] petals = new int[n];
            for (int i = 0; i < n; i++) {
                petals[i] = in.nextInt();
            }
            int ans = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int flowers = j - i + 1;
                    int sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum += petals[k];
                    }

                    if (sum % flowers != 0) continue;

                    int avg = sum / flowers;
                    for (int k = i; k <= j; k++) {
                        if (petals[k] == avg) {
                            ans++;
                            break; // we want the number of photos that have avg flowers not the nbr of avg flowers total
                        }
                    }
                }
            }
            out.print(ans);
        }
    }

    public static void main(String... args) throws Exception {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
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