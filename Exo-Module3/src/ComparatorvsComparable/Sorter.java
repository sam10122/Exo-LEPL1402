package ComparatorvsComparable;

import java.util.Collections;
import java.util.List;
import java.awt.Color;

import java.util.Comparator;
import java.util.List;

public class Sorter {


    /*
     * Should sort the list and order the Flower by color, in this specific order : red, blue, green
     */
    public static void sortFlowerByColor(List<Flower> list){
        Comparator<Flower> flower = new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return o1.getPetalColor().getRGB() - o2.getPetalColor().getRGB();
            }
        };
        list.sort(flower);
    }
    /*
     * Should sort the Plant by name only
     */
    public static void sortPlantByName(List<Plant> list){
        Comparator<Plant> plant = new Comparator<Plant>() {
            @Override
            public int compare(Plant o1, Plant o2) {
                int i = 0;
                if(o1.getName().charAt(i) == o2.getName().charAt(i)){
                    i++;
                }
                return o1.getName().charAt(i) - o2.getName().charAt(i);
            }
        };
        list.sort(plant);
    }

    /*
     * Should sort the list and order the Tree by height
     */
    public static void sortTreeByHeight(List<Tree> list){
       Comparator<Tree> tree = new Comparator<Tree>() {
           @Override
           public int compare(Tree o1, Tree o2) {
               return o1.getHeight() - o2.getHeight();
           }
       };
        list.sort(tree);
    }
}
