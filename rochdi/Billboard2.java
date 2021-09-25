
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

public class Billboard2 {
    static void fillRectangle(Kattio io, List<Integer> rectangle) {
        for (int i = 0; i < 4; i++) {
            rectangle.add(io.nextInt());
        }
    }

    static int computeMinTarpSurface(List<Integer> rectangle, List<Integer> obstacle) {
        int surface = (rectangle.get(3) - rectangle.get(1)) * (rectangle.get(2) - rectangle.get(0));
        if (((rectangle.get(0) >= obstacle.get(0) && rectangle.get(2) <= obstacle.get(2)
                && (rectangle.get(1) > obstacle.get(1) || rectangle.get(3) < obstacle.get(3))
                || (rectangle.get(1) >= obstacle.get(1) && rectangle.get(3) <= obstacle.get(3)
                        && (rectangle.get(0) > obstacle.get(0) || rectangle.get(2) < obstacle.get(2)))))) {
            surface -= (Math.min(rectangle.get(2), obstacle.get(2)) - Math.max(rectangle.get(0), obstacle.get(0)))
                    * (Math.min(rectangle.get(3), obstacle.get(3)) - Math.max(rectangle.get(1), obstacle.get(1)));
            return surface;
        }

        return surface;
    }

    public static void main(String[] args) throws Exception {
        Kattio io;
        try {
            io = new Kattio("billboard");
            List<Integer> rectangle1 = new ArrayList<Integer>();
            List<Integer> rectangle2 = new ArrayList<Integer>();
            fillRectangle(io, rectangle1);
            fillRectangle(io, rectangle2);
            io.print(computeMinTarpSurface(rectangle1, rectangle2));
            io.close();
        } catch (Exception e) {
            System.out.print("Please fill input file ");
        }
    }
}
