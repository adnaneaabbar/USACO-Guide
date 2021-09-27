
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

class Segement {
    int miles, speed;

    public Segement(int miles, int speed) {
        this.miles = miles;
        this.speed = speed;
    }
}

public class Speeding {
    public static int computeMaxOverSpeedLimit(List<Segement> ListSpeedLimit, List<Segement> ListSpeed) {
        int speed = 0;
        while (!(ListSpeedLimit.isEmpty() && ListSpeed.isEmpty())) {
            if (ListSpeedLimit.get(0).miles > ListSpeed.get(0).miles) {
                if (speed < ListSpeed.get(0).speed - ListSpeedLimit.get(0).speed) {
                    speed = ListSpeed.get(0).speed - ListSpeedLimit.get(0).speed;
                }
                ListSpeedLimit.get(0).miles -= ListSpeed.get(0).miles;
                ListSpeed.remove(0);
            }
            if (ListSpeedLimit.get(0).miles < ListSpeed.get(0).miles) {
                if (speed < ListSpeed.get(0).speed - ListSpeedLimit.get(0).speed) {
                    speed = ListSpeed.get(0).speed - ListSpeedLimit.get(0).speed;
                }
                ListSpeed.get(0).miles -= ListSpeedLimit.get(0).miles;
                ListSpeedLimit.remove(0);
            }
            if (ListSpeedLimit.get(0).miles == ListSpeed.get(0).miles) {
                if (speed < ListSpeed.get(0).speed - ListSpeedLimit.get(0).speed) {
                    speed = ListSpeed.get(0).speed - ListSpeedLimit.get(0).speed;
                }
                ListSpeedLimit.remove(0);
                ListSpeed.remove(0);
            }
        }

        return speed;

    }

    public static void main(String[] args) throws Exception {
        Kattio io;
        try {
            io = new Kattio("speeding");
            int n = io.nextInt();
            int m = io.nextInt();
            List<Segement> ListSpeedLimit = new ArrayList<Segement>();
            List<Segement> ListSpeed = new ArrayList<Segement>();
            for (int i = 0; i < n; i++) {
                ListSpeedLimit.add(new Segement(io.nextInt(), io.nextInt()));
            }
            for (int i = 0; i < m; i++) {
                ListSpeed.add(new Segement(io.nextInt(), io.nextInt()));
            }
            io.print(computeMaxOverSpeedLimit(ListSpeedLimit, ListSpeed));
            io.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.print("Please fill input file ");
        }
    }
}
