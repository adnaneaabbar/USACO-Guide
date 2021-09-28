
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

public class Shuffle {
    public static List<Integer> permute(List<Integer> shuffleID, List<Integer> shufflePosition) {
        List<Integer> newSuffleID = new ArrayList<Integer>();
        for (int i = 0; i < shufflePosition.size(); i++) {
            newSuffleID.add(shuffleID.get(shufflePosition.get(i)));
        }
        return newSuffleID;
    }

    public static void main(String[] args) throws Exception {
        Kattio io;
        try {
            io = new Kattio("shuffle");
            int N = io.nextInt();
            List<Integer> shufflePosition = new ArrayList<Integer>();
            List<Integer> shuffleID = new ArrayList<Integer>();
            for (int i = 0; i < N; i++) {
                shufflePosition.add(io.nextInt() - 1);
            }
            for (int i = 0; i < N; i++) {
                shuffleID.add(io.nextInt());
            }
            int t = 0;
            while (t < 3) {
                shuffleID = permute(shuffleID, shufflePosition);
                t++;
            }
            for (int i = 0; i < shuffleID.size(); i++) {
                io.println(shuffleID.get(i));
            }
            io.close();
        } catch (Exception e) {
            System.out.print("Please fill input file ");
        }
    }
}
