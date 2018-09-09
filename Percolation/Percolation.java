import edu.princeton.cs.algs4.*;

public class Percolation {

    /* Used for NxN grid*/

    private int N;

    /*Top and bottom var are used to detect the connectivity of top and bottom most row.size var is the size of grid i.e NxN*/

    private int top, bottom, size;

    /*This array keeps track of  opened sites*/

    boolean[] opened;

    WeightedQuickUnionUF qu;

    public Percolation(int N) {
        /* Cant make grid of 0 rows and  0cols*/
        try {
            if (N <= 0)
                throw new IllegalArgumentException("N should be more than 0");
        } catch (IllegalArgumentException ILE) {

            System.out.println(ILE.getMessage());
            return;
        }

        this.N = N;

        size = N * N;
        opened = new boolean[size];


        /* We have to take top and bottom vars as  ints larger than grid size.
We can take top=size as WeightedQuickUnionUF makes data structure from 0 to N-1  */

        top = size;

        bottom = size + 1;

        /* Make a Union  ds*/

        qu = new WeightedQuickUnionUF(size + 2);  // +2 for top and bottom vars

        joinTB(top, bottom);

    }

    public boolean isFull(int site){

        return qu.connected(top,site);

    }
    public boolean isOpen(int site) {
        return opened[site];

    }

    public void open(int site) {
//        System.out.println(site);
        if (isOpen(site)) {
            return;

        }
                              /*
                                  0.     1(top_ele).      2.

                    (left_ele)3     4(site).           5(right_ele)

                                 6.      7(bottom_ele).   8.

                                 */

        int top_ele = site - this.N;
        int right_ele = site + 1;
        int left_ele = site - 1;
        int bottom_ele = site + this.N;

        /*Center most site 4*/

        if (top_ele >= 0 & right_ele < size & left_ele >= 0 & bottom_ele < size) {
            qu.union(site, top_ele);
            qu.union(site, bottom_ele);
            qu.union(site, left_ele);
            qu.union(site, right_ele);
             opened[site]=true;
            return;

        }

        /* Middle site in last row 7*/

        if (top_ele >= 0 & right_ele < size & left_ele >= 0 & bottom_ele > size) {
            qu.union(site, top_ele);
            qu.union(site, left_ele);
             qu.union(site, right_ele);
            opened[site]=true;
            return;

        }


        /*Last site in last row 8*/
        if (top_ele >= 0 & right_ele > size & left_ele >= 0 & bottom_ele > size) {
            qu.union(site, top_ele);
            qu.union(site, left_ele);
            opened[site]=true;
            return;

        }

        /*Last site in first row 2*/
        if (top_ele < 0 & right_ele < size & left_ele >= 0 & bottom_ele < size) {
            qu.union(site, bottom_ele);
            qu.union(site, left_ele);
            qu.union(site, right_ele);
            opened[site]=true;
            return;

        }

        /*First site in first row  0*/
        if (top_ele < 0 & right_ele < size & left_ele < 0 & bottom_ele < size) {
            qu.union(site, bottom_ele);
            qu.union(site, right_ele);
            opened[site]=true;
            return;


        }

        /*Middle site in first row*/
//        if(top_ele < 0 & right_ele < N & left_ele >=0 & bottom_ele < N) {
//
//
//        }

    }

    public boolean precolates() {

        return qu.connected(top, bottom);
    }

    /*Join top and bottom site with first row sites and last row sites resp.*/

    private void joinTB(int t, int b) {

        for (int i = 0; i < N; i++) {
            qu.union(t, i);
            qu.union(b, size - 1 - i);
        }
    }


}