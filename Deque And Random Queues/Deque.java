import java.util.Iterator;

import edu.princeton.cs.algs4.*;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node first, last;

     Deque() {
        size = 0;
        first = last = null;
    }

    public Node f() {
        return first;
    }

    public Node l() {
        return last;
    }

    private class Node<Item> {
        /*Pointer to next node or link*/
        Node next;
        /*Pointer to previous node or link*/
        Node prev;
        /*Data to hold of type Item*/
        Item data;

        private Node(Item give) {
            data = give;
            next = null;
            prev = null;
        }

    }


    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        Node node;
        if (first == null & last==null) {
            node = new Node<>(item);
            first=last=node;
            size++;
            return;
        }

        node = new Node<>(item);
        Node temp = first;
        first = node;
        temp.prev=first;
        first.next=temp;
        size++;
    }

    public void addLast(Item item) {
        Node node;
        if (last==null & first==null) {
            node = new Node<>(item);
            last =first=node;
            size++;
            return;
        }
        node = new Node<>(item);
        Node temp = last;
        last = node;
        temp.next=last;
        last.prev=temp;
        size++;
    }

    public Item removeFirst() {

        if (first == null) {
            return null;
        }
        if(first==last){
            Node temp = first;
            first= temp.next;
            first=last=null;
        size--;
            return (Item) temp.data;
        }

        Node temp = first;
        first= temp.next;
        temp.prev=null;
        size--;
        return (Item) temp.data;

    }

    public Item removeLast() {
        if (last == null) {
            return null;
        }

        if(last==first){
            Node temp = last;
            last=first=null;
            size--;
            return (Item) temp.data;
        }
        Node temp = last;
        last=temp.prev;
        temp.next=null;
        size--;
        return (Item) temp.data;

    }

    @Override
    public Iterator<Item> iterator() {

        return null;
    }
}


