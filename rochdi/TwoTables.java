
import java.io.*;
import java.util.*;

public class TwoTables {

    public static void main(String[] args) throws Exception {
        Kattio io;
        try {
            io = new Kattio();
            int t = io.nextInt();
            while (t > 0) {
                Rectangle room = new Rectangle(io.nextInt(), io.nextInt());
                Rectangle tableB = new Rectangle(io);
                Rectangle tableG = new Rectangle(io.nextInt(), io.nextInt());

                long d = Math.max(room.W, room.H);

                if (room.W >= tableG.W + tableB.W) {
                    d = Math.min(Math.max(0, tableG.W - tableB.x1), Math.max(0, tableB.x2 - (room.W - tableG.W)));
                }

                if (room.H >= tableG.H + tableB.H) {
                    d = Math.min(d,
                            Math.min(Math.max(0, tableG.H - tableB.y1), Math.max(0, tableB.y2 - (room.H - tableG.H))));
                }

                if (d == Math.max(room.W, room.H)) {
                    d = -1;
                }

                io.println(d);
                t--;
            }
            io.close();
        } catch (Exception e) {
            System.out.print("Please fill input file ");
        }
    }
}

class Rectangle {
    long x1, y1, x2, y2, H, W;

    public Rectangle(long width, long height) {
        this.y2 = height;
        this.x2 = width;
        this.y1 = 0;
        this.x1 = 0;
        H = (this.y2 - this.y1);
        W = (this.x2 - this.x1);
    }

    public Rectangle(Kattio io) {
        x1 = io.nextInt();
        y1 = io.nextInt();
        x2 = io.nextInt();
        y2 = io.nextInt();
        H = (this.y2 - this.y1);
        W = (this.x2 - this.x1);
    }

    public Rectangle(long x1, long y1, long x2, long y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        H = (this.y2 - this.y1);
        W = (this.x2 - this.x1);
    }

    public long rectArea() {
        return this.H * this.W;
    }

    public Rectangle getInterWith(Rectangle rectangle) {
        return new Rectangle(Math.max(rectangle.x1, this.x1), Math.max(rectangle.y1, this.y1),
                Math.min(rectangle.x2, this.x2), Math.min(rectangle.y2, this.y2));
    }

    public boolean isOverlapWith(Rectangle rectangle) {
        return !(this.x1 >= rectangle.x2 || this.x2 <= rectangle.x1 || this.y1 >= rectangle.y2
                || this.y2 <= rectangle.y1);
    }

    public String toString() {
        return "x1 :" + this.x1 + " y1 :" + this.y1 + " x2 :" + this.x2 + " y2 :" + this.y2;
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