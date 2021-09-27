
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

class Bucket {
    int c, m;

    public Bucket(Kattio io) {
        c = io.nextInt();
        m = io.nextInt();
    }

    public void fillBucketFrom(Bucket bucket) {
        int mLeftToFill = this.c - this.m;
        m += Math.min(mLeftToFill, bucket.m);
        bucket.m -= Math.min(mLeftToFill, bucket.m);
    }

    public String toString() {
        return c + " " + m;
    }
}

public class MixMilk {
    public static void main(String[] args) throws Exception {
        Kattio io;
        try {
            io = new Kattio("mixmilk");
            Bucket bucket1 = new Bucket(io);
            Bucket bucket2 = new Bucket(io);
            Bucket bucket3 = new Bucket(io);
            for (int i = 0; i < 11; i++) {
                bucket2.fillBucketFrom(bucket1);
                bucket3.fillBucketFrom(bucket2);
                bucket1.fillBucketFrom(bucket3);
            }
            bucket2.fillBucketFrom(bucket1);
            io.println(bucket1.m);
            io.println(bucket2.m);
            io.println(bucket3.m);
            io.close();
        } catch (Exception e) {
            System.out.print("Please fill input file ");
        }
    }
}
