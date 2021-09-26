import java.io.*;
import java.util.*;

public class Sheet {

    static long computeCommunAreaB(Rectangle rectangleW, Rectangle rectangleB1, Rectangle rectangleB2) {
        long surface = 0;
        if (!rectangleB1.isOverlapWith(rectangleB2)) {
            return surface;
        }
        Rectangle rectangleInterBB = rectangleB1.getInterWith(rectangleB2);

        if (!rectangleW.isOverlapWith(rectangleInterBB)) {
            return surface;
        }
        surface = rectangleW.getInterWith(rectangleInterBB).rectArea();

        return surface;
    }

    static long computeCommunArea(Rectangle rectangle1, Rectangle rectangle2) {
        long surface = 0;
        if (rectangle1.isOverlapWith(rectangle2)) {
            surface = rectangle1.getInterWith(rectangle2).rectArea();
        }
        return surface;
    }

    static String computeWhiteArea(Rectangle rectangleW, Rectangle rectangleB1, Rectangle rectangleB2) {
        String reponse = "YES";
        long surfaceW = rectangleW.rectArea();
        surfaceW -= computeCommunArea(rectangleW, rectangleB1);
        surfaceW -= computeCommunArea(rectangleW, rectangleB2);
        surfaceW += computeCommunAreaB(rectangleW, rectangleB1, rectangleB2);
        if (surfaceW <= 0) {
            reponse = "NO";
        }
        return reponse;
    }

    public static void main(String[] args) throws Exception {
        Kattio io;
        try {
            io = new Kattio();
            Rectangle rectangleW = new Rectangle(io);
            Rectangle rectangleB1 = new Rectangle(io);
            Rectangle rectangleB2 = new Rectangle(io);
            io.print(computeWhiteArea(rectangleW, rectangleB1, rectangleB2));

            io.close();
        } catch (Exception e) {
            System.out.print("Please fill input file ");
        }
    }
}

class Rectangle {
    long x1, x2, y1, y2;

    public Rectangle(Kattio io) {
        x1 = io.nextInt();
        y1 = io.nextInt();
        x2 = io.nextInt();
        y2 = io.nextInt();
    }

    public Rectangle(long x1, long y1, long x2, long y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public long rectArea() {
        return (y2 - y1) * (x2 - x1);
    }

    public Rectangle getInterWith(Rectangle rectangle) {
        return new Rectangle(Math.max(rectangle.x1, this.x1), Math.max(rectangle.y1, this.y1),
                Math.min(rectangle.x2, this.x2), Math.min(rectangle.y2, this.y2));
    }

    public boolean isOverlapWith(Rectangle rectangle) {
        return !(this.x1 >= rectangle.x2 || this.x2 <= rectangle.x1 || this.y1 >= rectangle.y2
                || this.y2 <= rectangle.y1);
    }

}

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
