import java.util.Iterator;
import edu.princeton.cs.algs4.*;


public class Deque<Item> implements Iterable<Item> {
    private int size;
    Node first, last;

    public Deque() {
        size = 0;
        first = last = null;
    }


    private class Node<Item> {
        /*Pointer to next node or link*/
        Node next;
        Node prev;
        /*Data to hold of type Item*/
        Item data;

        public Node(Item give) {
            data = give;
            next = null;
            prev=null;
        }

    }


    public boolean isEmpty() {

        return size == 0 ? true : false;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        Node node;
        if (first==null) {
            node = new Node<>(item);
            first = node;
            size++;
            return;
        }
        node = new Node<>(item);
        Node temp=first;
        first=node;
        first.next=temp;
        size++;
    }

    public void addLast(Item item) {
        Node node;
        if(last==null){
         node =new Node<>(item);

        }
    }

    public Item removeFirst() {
    }

    public Item removeLast() {
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}


