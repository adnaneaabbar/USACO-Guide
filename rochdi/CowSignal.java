package solutionCp;

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

public class CowSignal {
    public static void main(String[] args) throws Exception {
        Kattio io;
        try {
            io = new Kattio("cowsignal");
            int m = io.nextInt();
            int n = io.nextInt();
            int k = io.nextInt();
            for (int i = 0; i < m; i++) {
                String row = io.next().replaceAll("X", "X".repeat(k)).replaceAll("\\.", "\\.".repeat(k));
                for (int w = 0; w < k; w++) {
                    io.println(row);
                }
            }
            io.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.print("Please fill input file ");
        }
    }
}
