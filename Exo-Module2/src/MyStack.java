import java.util.LinkedList;

public class MyStack<E> {

    private LinkedList<E> queue;

    /*
     * Constructor
     */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /**
     * Push an element on the stack
     *
     * @param elem the Element to push
     */
    public void push(E elem) {
        queue.add(0, elem);
    }

    /**
     * Remove the element at the top of the stack
     *
     * @return The element at the top of the stack
     */
    public E pop() {
        E elem = queue.remove();
        return elem;
    }

    /**
     * Look at the element at the top of the stack
     *
     * @return The element at the top of the stack
     */
    public E peek() {
        E elem = queue.peek();
        return elem;
    }

    /**
     * Is the stack empty
     *
     * @return True if there is no element in the stack
     * and false otherwise
     */
    public boolean empty() {
        if (queue.isEmpty()) {
            return true;
        }
        return false;
    }
}