import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final WeightedQuickUnionUF perc;
    private final WeightedQuickUnionUF full;
    private final boolean[][] gird;
    private int size;

    private int top;
    private int bottom;

    private int numOfOpen = 0;

    public Percolation(int n){
        if(n <= 0) throw new IllegalArgumentException("N should be larger than zero");
        this.size = n;
        this.gird = new boolean[n][n];
        this.perc = new WeightedQuickUnionUF(n * n + 2);
        this.full = new WeightedQuickUnionUF(n*n +1);
        this.top= 0;
        this.bottom = n*n + 1;
    }
    private int fieldIndex(int row, int col){
        return (row-1) * size + col;
    }

    private void connect(int row, int col){
       if(row == 1){
           perc.union(fieldIndex(row, col), this.top);
           full.union(fieldIndex(row, col), this.top);
       }
       if(row == this.size)
           perc.union(fieldIndex(row, col), this.bottom);
       if(isOpen(row-1, col)){
           perc.union(fieldIndex(row, col), fieldIndex(row-1, col));
           full.union(fieldIndex(row, col), fieldIndex(row-1, col));
       }
       if(isOpen(row+1, col)){
           perc.union(fieldIndex(row, col), fieldIndex(row+1, col));
           full.union(fieldIndex(row, col), fieldIndex(row+1, col));
       }
       if(isOpen(row,col-1)){
           perc.union(fieldIndex(row, col), fieldIndex(row, col-1));
           full.union(fieldIndex(row, col), fieldIndex(row, col-1));
       }
       if(isOpen(row, col+1)){
           perc.union(fieldIndex(row, col), fieldIndex(row, col+1));
           full.union(fieldIndex(row, col), fieldIndex(row, col+1));
       }
    }

    private boolean validate(int row, int col){
        return row <= this.size && col <= this.size && row >= 1 && col >= 1;
    }


    public void open(int row, int col){
        if(validate(row,col) && !this.gird[row-1][col-1]){
            this.gird[row-1][col-1] = true;
            numOfOpen += 1;
            connect(row,col);
        }
    }

    public boolean isOpen(int row, int col){
       if(validate(row,col))
           return gird[row-1][col-1];
       return false;
    }

    public boolean isFull(int row, int col){
        return isOpen(row,col) && full.connected(fieldIndex(row, col), top);
    }

    public int numberOfOpenSites(){
        return this.numOfOpen;
    }

    public boolean percolates(){
        return perc.connected(0, this.bottom);
    }

}
