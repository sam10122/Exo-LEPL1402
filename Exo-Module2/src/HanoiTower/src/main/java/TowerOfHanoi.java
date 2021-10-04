import java.util.Stack;

public class TowerOfHanoi{

    /**
     * Solve the Tower of Hanoi puzzle
     *
     * @param n The number of disks to move
     * @param a The tower from which we want to move the disks
     * @param b An intermediate tower
     * @param c The tower to which we want to move the disks
     */
    public static void towerOfHanoi(int n, Stack<Disk> a, Stack<Disk> b, Stack<Disk> c) {
        if (n == 1) {
            c.push(a.pop());
            return;
        }
        towerOfHanoi(n-1, a, c, b);
        c.push(a.pop());
        towerOfHanoi(n-1, b, a, c);
    }

    public static int numberOfMoves(int stackSize){
        return (int) Math.pow(2, stackSize) - 1;
    }

}
