import edu.princeton.cs.algs4.StdOut;

public class SubSet {

    public static void main(String[] args) {
        RandomizedQueue<String> r=new RandomizedQueue<>();

        if(args.length>0) {
            for (int i = 0; i < args.length - 1; i++) {
                r.enqueue(args[i]);
            }

            for (int i = 0; i < Integer.getInteger(args[3]); i++) {
                StdOut.print(r.dequeue());
            }


        }
    }
}
