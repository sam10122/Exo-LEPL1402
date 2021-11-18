
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class LockQueue {

    public final static int SIZE = 100;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public int head = 0;
    public int tail = 0;
    public final Integer [] cells = new Integer[SIZE];
    public int count = 0;



    public Integer dequeue() {
        Integer value = null;
        lock.lock();
        try {
            while (empty()) {
                notEmpty.await();
            }
            value = cells[head % SIZE];
            cells[head % SIZE] = null;
            head++;
            count--;
            notFull.signal();
        } catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
        return value;
    }


    public void enqueue(Integer i) {
        lock.lock();
        try{
            while(full()){
                notFull.await();
            }
            cells[tail%SIZE] = i;
            tail++;
            count++;
            notEmpty.signal();
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public boolean full(){
        return this.count == SIZE;
    }

    public boolean empty(){
        return this.head == this.tail;
    }

    public int size() { return this.tail - this.head; }

}
