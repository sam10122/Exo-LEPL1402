public class BoundedBuffer {
    private Integer[] data;
    private int putPointer, takePointer, size;

    public BoundedBuffer(int capacity){
        this.data = new Integer[capacity];
        this.putPointer = 0;
        this.takePointer = 0;
        this.size = 0;
    }

    /*
     * Mechanics of putting x on the buffer.
     * x is added at the end of the buffer.
     */
    private void doPut(Integer x){
        data[putPointer] = x;
        putPointer ++;
        size ++;
        if(putPointer == data.length){
            putPointer = 0;
        }
        notify();
    }

    /*
     * Mechanics of getting the first element of the buffer
     */
    private Integer doTake(){
        Integer x = data[takePointer];
        data[takePointer] = null;
        takePointer ++;
        size --;
        if(takePointer == data.length){
            takePointer = 0;
        }
        notify();
        return x;
    }

    private boolean isFull(){
        return this.data.length == this.size;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    /*
     * put x on the buffer if the buffer is not full
     * if the buffer is full, the thread waits until a place is free
     */
    public synchronized void put(Integer x) throws InterruptedException{
        while(isFull()){
            wait();
        }
        doPut(x);
    }

    /*
     * Get the first element of the buffer
     * if the buffer is empty, the thread waits until an element arrives
     */
    public synchronized Integer take() throws InterruptedException{
       while(isEmpty()){
           wait();
       }
       return doTake();
    }

    /*
     * put x on the buffer if the buffer is not full
     * if the buffer is full, the thread waits ms milliseconds until a place is free
     * if the delay is exceeded, don't put x on the buffer
     * return true if x was added on the buffer, or false
     * return false if an exception occurs
     */
    public synchronized boolean offer(Integer x, long ms){
        if(!isFull()){
            doPut(x);
            return true;
        }
        else{
            try {
                wait(ms);
            } catch (InterruptedException e) {
                return false;
            }
            if(!isFull()){
                doPut(x);
                return true;
            }
            else{
                return false;
            }
        }
    }

    /*
     * get the first element of the buffer
     * if the buffer is empty, the thread waits ms milliseconds until an element arrives
     * if the delay is exceeded or an exception occurs return null
     */
    public synchronized Integer poll(long ms){
        if(!isEmpty()){
            return doTake();
        }
        else{
            try{
                wait(ms);
            }catch(InterruptedException e){
                return null;
            }
            if(!isEmpty()){
                return doTake();
            }
            else{
                return null;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int[] value = {0};
        Thread t = new Thread(() ->{
            value[0] = 47;
        });
        t.start();

        System.out.println(value[0]);
    }

}
