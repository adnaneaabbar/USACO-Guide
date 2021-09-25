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

public class Square {
    static void fillRectangle(Kattio io, List<Integer> rectangle) {
        for (int i = 0; i < 4; i++) {
            rectangle.add(io.nextInt());
        }
    }

    static int computeMinSquareSurface(List<Integer> rectangle1, List<Integer> rectangle2) {
        int surface = 0;
        surface = (int) Math.pow(
                Math.max(Math.max(rectangle1.get(2), rectangle2.get(2)) - Math.min(rectangle1.get(0), rectangle2.get(0)),Math.max(rectangle1.get(3), rectangle2.get(3)) - Math.min(rectangle1.get(1), rectangle2.get(1))), 2);
        return surface;
    }

    public static void main(String[] args) throws Exception {
        Kattio io;
        try {
            io = new Kattio("square");
            List<Integer> rectangle1 = new ArrayList<Integer>();
            List<Integer> rectangle2 = new ArrayList<Integer>();
            fillRectangle(io, rectangle1);
            fillRectangle(io, rectangle2);
            io.print(computeMinSquareSurface(rectangle1, rectangle2));
            io.close();
        } catch (Exception e) {
            System.out.print("Please fill input file ");
        }
    }
}
