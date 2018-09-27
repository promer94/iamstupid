import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;

    public PercolationStats(int n, int trials) {
        if (n <= 0) {
            throw new IllegalArgumentException("The grid size must be bigger than zero");
        }
        if (trials <= 0) {
            throw new IllegalArgumentException("The number of experiments must be bigger than zero");
        }
        double[] thresholds = new double[trials];
        for (int i = 0; i < trials; i += 1) {
            Percolation prec = new Percolation(n);
            while (!prec.percolates()) {
                int column = 1 + StdRandom.uniform(n);
                int row = 1 + StdRandom.uniform(n);
                prec.open(row, column);
            }

            thresholds[i] = prec.numberOfOpenSites() / (double) (n * n);

        }
        mean = StdStats.mean(thresholds);
        stddev = StdStats.stddev(thresholds);
        double confidenceFraction = (1.96 * stddev()) / Math.sqrt(trials);
        confidenceLo = mean - confidenceFraction;
        confidenceHi = mean + confidenceFraction;
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    public double confidenceLo() {
        return confidenceLo;
    }

    public double confidenceHi() {
        return confidenceHi;
    }

    public static void main(String[] args) {
        int n = 200, t = 100;
        if (args.length == 2) {
            n = Integer.parseInt(args[0]);
            t = Integer.parseInt(args[1]);
        }
        PercolationStats stats = new PercolationStats(n, t);
        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
    }
}
