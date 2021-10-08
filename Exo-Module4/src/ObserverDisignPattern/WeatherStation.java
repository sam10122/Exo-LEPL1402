import java.util.NoSuchElementException;

public class WeatherStation extends Observable {
    @Override
    public Observer[] getSubscribers() {
        if(subscribers == null){
            return null;
        }
        Observer[] o = new Observer[subscribers.size()];
        int i = 0;
        for(Observer j : subscribers){
            o[i] = j;
            i++;
        }
        return o;
    }

    @Override
    public void broadcast(Pair<String, Integer> pair) {
        Observer[] observers = getSubscribers();
        for(int i = 0 ; i < observers.length; i++){
           if(observers[i].getZone() == pair.getZone()){
               observers[i].update((Object) pair.getAlert());
           }
        }
    }

    @Override
    public void addObserver(Observer sub) {
        if(!this.subscribers.contains(sub)){
            this.subscribers.add(sub);
        }
    }

    @Override
    public boolean removeObserver(Observer sub) {
        if(this.subscribers.contains(sub)){
            this.subscribers.remove(sub);
        }
        return false;
    }

    @Override
    public void setAlert(String alert, int zone) {
       Pair<String,Integer> broad = new Pair<>(alert,zone);
       broadcast(broad);
    }
}
