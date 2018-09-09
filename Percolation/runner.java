import edu.princeton.cs.algs4.*;
public class runner {

    public static void main(String[] args) {
 int n=20;
        Percolation per=new Percolation(n);
         int count=0;
        while(!per.precolates()){

            per.open(StdRandom.uniform(n*n));
count++;

        }

        System.out.println(count);
    }
}
