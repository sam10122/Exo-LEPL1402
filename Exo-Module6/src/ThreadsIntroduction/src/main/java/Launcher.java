public class Launcher {

    /*
     * Instantiate and start each thread from "t" with its OWN Counter object,
     * then wait for all threads to finish and return the set of Counter objects
     * the threads ran on. Each thread must be named according to its index in the
     * "t" array.
     */
    public static Counter[] init(Thread[] t){
        Counter[] count = new Counter[t.length];
        for(int i = 0; i < t.length; i++){
            Counter c = new Counter();
            t[i] = new Thread(c,""+i);
            t[i].start();
            try{
                t[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            count[i] = c;
        }
        return count;
    }
}
