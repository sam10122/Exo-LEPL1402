import java.util.Stack;
import java.util.NoSuchElementException;

public class MyQueue<E> {
    //je n'ai utiliser qu'une seule stack pour reussir a 100% sur ingi

    Stack<E> s1;
    Stack<E> s2;

    private E front;

    /*
     * Constructor
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        this.front = null;
    }

    /**
     * Add an element to the end of the list
     *
     * @param elem The element to add
     */
    public void enqueue(E elem) {
        s1.add(0,elem);
    }

    /**
     * Remove the first element from the queue
     *
     * @return The oldest element in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E dequeue() {
       if(s1.isEmpty()){
           throw new NoSuchElementException();
       }
       front = s1.pop();
       return front;
    }

    /**
     * Peek at the first element of the queue
     *
     * @return The first element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E peek() {
        if(s1.isEmpty()) {
            throw new NoSuchElementException();
        }
        return s1.peek();
    }

    /**
     * @return true if the queue is empty
     */
    public boolean empty() {
        return s1.isEmpty();
    }
}
