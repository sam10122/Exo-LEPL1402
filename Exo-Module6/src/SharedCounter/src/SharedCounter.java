public class SharedCounter {

    private int counter = 0;

    public void inc(){
        synchronized (this){
            counter ++;
            notify();
        }

    }

    public void dec(){
        synchronized (this){
            while(counter <= 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            counter --;
        }

    }

    public int get(){
        return counter;
    }

    public static void main(String[] args) {
        SharedCounter c = new SharedCounter();
        c.inc();
        c.inc();
        System.out.println(c.get());
    }

}