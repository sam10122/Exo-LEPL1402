import java.util.NoSuchElementException;

public class ElementFactory extends Factory{
    private static final ElementFactory singleton = new ElementFactory();
    private ElementFactory(){}

    public LevelComponent getElement(char c) {
        switch (c){
            case('D'):
                return new Door();

            case('-'):
                return new Floor();

            case('#'):
                return new Wall();

            case('K'):
                return new Key();

            default:
                throw new IllegalArgumentException();
        }
    }

    // YOUR CODE HERE

    public static ElementFactory getInstance() {
        return singleton;
    }

}

