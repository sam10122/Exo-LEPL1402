import java.util.Arrays;

public class Level extends AbstractLevel {
    LevelComponent[][] obj;

    public Level(String input) {
        size = input.split("\n").length;
        ElementFactory factory = ElementFactory.getInstance();
        obj = new LevelComponent[size][size];
        String[] split = input.split("\n");
        for(int i = 0; i < obj.length; i++){
            String[] content = split[i].split("");
            for(int j = 0; j < obj[i].length; j++){
                obj[i][j] = factory.getElement(content[j].charAt(0));
                size++;
            }
        }
    }

    @Override
    LevelComponent[][] getComponents() {
        return this.obj;

    }

    @Override
    int getSize() {
        return size*size;
    }


    @Override
    public String toString() {
        LevelComponent[][] content = getComponents();
        String component = "";
        for(int i = 0; i < content.length; i++){
            for(int j = 0; j < content[i].length; j++){
                component += content[i][j].draw();
            }
            component += "\n";
        }
        return component;
    }
    /* Example of level building with this String : String s = "#-K\n-D-\n#-K\n"
     * Gives : LevelComponent[][] componentsObjects = {
     *                                        {new Wall(), new Floor(), new Key()},
     *                                        {new Floor(), new Door(), new Floor()},
     *                                        {new Wall(), new Floor(), new Key()}}
     */


    // YOUR CODE HERE
}