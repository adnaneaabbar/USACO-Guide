import java.io.*;
import java.util.*;

class Kattio extends PrintWriter {

    private BufferedReader r;

    private StringTokenizer st;

    // standard input

    public Kattio() {
        this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {

        super(o);

        r = new BufferedReader(new InputStreamReader(i));

    }

    // USACO-style file input

    public Kattio(String problemName) throws IOException {

        super(new FileWriter(problemName + ".out"));

        r = new BufferedReader(new FileReader(problemName + ".in"));

    }

    // returns null if no more input

    public String next() {

        try {

            while (st == null || !st.hasMoreTokens())

                st = new StringTokenizer(r.readLine());

            return st.nextToken();

        } catch (Exception e) {
        }

        return null;

    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

}

public class Paint {

    public static void main(String[] args) {
        Kattio io;
        try {
            io = new Kattio("paint");
            int a = io.nextInt();
            int b = io.nextInt();
            int c = io.nextInt();
            int d = io.nextInt();
            int length = 0;
            if (a >= d || c >= b) {
                length = (b - a) + (d - c);
            } else {
                length = Math.max(b, d) - Math.min(a, c);
            }
            io.print(length);
            io.close();
        } catch (Exception e) {
            System.out.println("Entre input in test.in");
        }

    }
}