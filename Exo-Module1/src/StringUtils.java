import java.util.Arrays;

public class StringUtils {
    /**
     * Split a string according to a delimiter
     *
     * @param str The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     *          between two consecutive occurence of the delimiter.
     *          If there is no occurence of the delimiter, it should
     *          return an array of size 1 with the string at element 0
     */
    public static String [] split(String str, char delimiter){
        int array = 1;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == delimiter){
                array++;
            }
        }

        String[] split = new String[array];
        int inc = 0;
        int begin = 0;
        for(int j = 0; j < str.length(); j++){
            if(str.charAt(j) == delimiter){
                split[inc] = str.substring(begin,j);
                begin = j+1;
                inc++;
            }
            if(j == str.length()-1){
                split[inc] = str.substring(begin,j+1);
            }
        }
        return split;
    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     *          the substring in str or -1 if sub does not appear
     *          in str
     */
    public static int indexOf(String str, String sub){
        for (int x = 0; x <= str.length() - sub.length(); x++) {
            if (str.substring(x, x + sub.length()).equals(sub)) {
                return x;
            }
        }
        return -1;
    }

    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     *          character put to lower case.
     */
    public static String toLowerCase(String str){
        char[] str2 = str.toCharArray();
        int change = 'a' - 'A';
        for(int i = 0; i < str2.length;i++){
            if(str2[i] >= 'A' && str2[i] <= 'Z'){
                str2[i] += change;
            }
        }
        return String.valueOf(str2);
    }

    /**
     * Check if a string is a palyndrome
     *
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str){
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }

}
