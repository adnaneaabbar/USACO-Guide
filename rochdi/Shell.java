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

public class Shell {
    static int getScore(List<Integer> ListOfShells, int a, int b, int g) {
        int temp = ListOfShells.get(a - 1);
        ListOfShells.set(a - 1, ListOfShells.get(b - 1));
        ListOfShells.set(b - 1, temp);
        if (ListOfShells.get(g - 1) == 1) {
            return 1;
        }
        return 0;
    }

    static void updateScore(List<Integer> ListOfScores, int s, int i) {
        int temp = ListOfScores.get(i);
        ListOfScores.set(i, temp + s);
    }

    public static void main(String[] args) throws Exception {
        Kattio io;
        try {
            io = new Kattio("shell");
            List<Integer> ListShells1 = Arrays.asList(1, 0, 0);
            List<Integer> ListShells2 = Arrays.asList(0, 1, 0);
            List<Integer> ListShells3 = Arrays.asList(0, 0, 1);
            List<Integer> ListScores = Arrays.asList(0, 0, 0);
            int t = io.nextInt();
            while (t > 0) {
                int a = io.nextInt();
                int b = io.nextInt();
                int g = io.nextInt();
                updateScore(ListScores, getScore(ListShells1, a, b, g), 0);
                updateScore(ListScores, getScore(ListShells2, a, b, g), 1);
                updateScore(ListScores, getScore(ListShells3, a, b, g), 2);
                t--;
            }
            Collections.sort(ListScores);
            io.print(ListScores.get(ListScores.size() - 1));
            io.close();
        } catch (Exception e) {
            System.out.println("Fill input File");
        }
    }
}
