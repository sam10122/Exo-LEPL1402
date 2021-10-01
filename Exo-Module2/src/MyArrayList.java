import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<Item> {
    Object[] list;
    int size;

    public MyArrayList(int initsize){
        if(initsize < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        list = new Object[initsize];
    }

    public void add(Item item){
        if(size >= list.length){
            reSize();
        }
        list[size] = item;
        size++;
    }

    public void reSize(){
        Object[] newL = new Object[size*2];
        for(int i = 0; i < list.length; i++){
            newL[i] = list[i];
        }
        list = newL;
    }

    public Item remove(int index){
        Item item = (Item)list[index];
        helpRemove(index);
        size--;
        return item;
    }

    public void helpRemove(int index){
        for(int i = index; i < list.length-1; i++){
            list[i] = list[i+1];
        }
    }

    public Iterator<Item> iterator(){
        return new ArrayListIterator();
    }

    public class ArrayListIterator implements Iterator<Item>{
        int initSize = size;
        int index = 0;

        public boolean check(){
            if(initSize != size){
                throw new ConcurrentModificationException();
            }
            return true;
        }

        @Override
        public boolean hasNext() {
            return check() && index < size;
        }

        @Override
        public Item next() {
            check();
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return (Item) list[index++];
        }
    }
}
