
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

public class LostCow {
    public static void main(String[] args) throws Exception {
        Kattio io;
        try {
            io = new Kattio("lostcow");
            int x = io.nextInt();
            int y = io.nextInt();
            // int k = 0;
            // int d = 0;
            // int prev = x;
            // Using boucle
            // while (((y >= x && y > (x + Math.pow((-2), k))) || (y < x && y < (x +
            // Math.pow((-2), k))))
            // && (x + Math.pow((-2), k) >= 0)) {
            // d += Math.abs((x + Math.pow((-2), k)) - prev);

            // prev = x + (int) Math.pow((-2), k);
            // k++;
            // }
            // d += Math.abs((x + Math.pow((-2), k)) - prev);
            // if (x > y) {
            // d -= y - x - Math.pow((-2), k);
            // } else {
            // d -= x - y + Math.pow((-2), k);
            // }
            int d = Math.abs(x - y);
            int n = (int) Math.ceil(Math.log(d) / Math.log(2)); // C vrai dans tout les cas

            if (x > y) {
                // n doit etre impair
                if (n % 2 == 0) {
                    n += 1;
                }
            }
            if (x <= y) {
                // n doit etre pair
                n += n % 2;
            }
            // serie geometriq
            io.print(((int) (3 * (Math.pow(2, n) - 1) + 1 - (Math.abs(y - x - Math.pow(-2, n))))));
            // io.print(d);
            io.close();
        } catch (Exception e) {
            System.out.print("Please fill input file ");
        }
    }
}
