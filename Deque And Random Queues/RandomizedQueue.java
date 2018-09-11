import java.util.Iterator;
import edu.princeton.cs.algs4.*;

public class RandomizedQueue<Item> implements Iterable<Item>{
   private int size;
private    int tail;
Item[] queue;

public RandomizedQueue() {
    tail=0;
size=0;
queue=(Item[]) new Object[1];
    }

    public boolean isEmpty(){
    return  size==0;
    }

    public int size(){
    return size;
    }

    private void resize(int capacity){
    if(capacity>queue.length){
        Item[] temp=(Item[]) new Object[capacity];
        for(int i=0;i<queue.length;i++){
            temp[i]=queue[i];
        }
        queue=temp;
    }

    }

    public void enqueue(Item item){
if(item==null){
    throw new NullPointerException();
}
if(tail>=queue.length){
    resize(tail+1);
}
queue[tail++]=item;
size++;
    }
    public Item dequeue(){
    if(size==0){
        return  null;
    }

    int rand=StdRandom.uniform(tail);
 Item temp=queue[rand];
queue[rand]=queue[tail-1];
 queue[tail-1]=null;
 tail--;
 size--;
 return temp;
    }

    public Item sample(){
    if(size==0){
        return null;
    }
        return queue[StdRandom.uniform(tail)];

    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
