import java.util.Arrays;

public class IntroductionExercises {

    public static int variable = 0;

    public static int[] squares;


    public static void attribute(int value){
        variable = value;
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static boolean equalsIntegers(int a, int b){
        return a == b;
    }

    public static int middleValue(int a, int b, int c){
        if(a == b || a == c || b == c){
            return -1;
        }
        if(b > a && a > c || c > a && a > b){
            return a;
        }
        if(a > b && b > c || c > b && b > a){
            return b;
        }
        return c;
    }

    public static int max(int a, int b){
        return a > b ? a : b;
    }

    public static String greetings(String str){
        switch(str){
            case "Morning":
                return "Good morning, sir!";

            case "Evening":
                return "Good evening, sir!";

            default:
                return "Hello, sir!";
        }
    }

    public static int[] lastFirstMiddle(int[] a){
        int[] mat = new int[3];
        mat[0] = a[a.length-1];
        mat[1] = a[0];
        mat[2] = a[a.length/2];
        return mat;
    }

    public static int sum(int[] array){
        int somme = 0;
        for(int i = 0; i < array.length; i++){
            somme += array[i];
        }
        return somme;
    }

    public static int maxArray(int[] array){
        int max = array[0];
        int i = 1;
        while(i < array.length){
            if(max < array[i]){
                max = array[i];
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        squares = new int[args.length];
        for(int i = 0; i < args.length; i++){
            try{
                squares[i] = Integer.parseInt(args[i]) * Integer.parseInt(args[i]);
            } catch (Exception e){
                squares[i] = 0;
            }
        }
        System.out.println(Arrays.toString(squares));
    }

}

