package StringManipul;

import java.security.PublicKey;

public class StringManipulation {

    public static int stringToInt(String s) {
        boolean isNegative = false;
        int result = 0;
        int i;

        if(s.charAt(0)== '-'){
            i=1;
            isNegative = true;
        }else{
            i=0;
        }

        for( ; i<s.length();i++) {
            final int digit = s.charAt(i) -'0';
            result = result * 10 + digit;
        }
        if(isNegative){
            result = result * -1;
        }
        return result;
    }

    public static int stringToInt_secondMethod(String s){
        int result = 0;
        for( int i= s.charAt(0) == '-' ? 1 : 0; i<s.length(); i++){
           final int digit = s.charAt(i) -'0';
            result = result *10 + digit;
        }
        return s.charAt(0) == '-' ? -result : result;
    }

    public static String intToString(int x) {
        // handle negative numbers
        boolean isNegative = false;

        if(x<0){
            isNegative = true;
        }
        StringBuilder s = new StringBuilder();

        do {
            s.append( (char) ( Math.abs( x % 10) + '0') );
            x/=10;
        }
        while (x!=0);
        if(isNegative){
            s.append('-');
        }
        s.reverse();
        return s.toString();
    }

    public static int ssDecodeColId(String col ){
        int result = 0;
        for( int i =0; i< col.length(); i++ ){
            char c = col.charAt(i);
            result = result * 26 + c -'A' + 1;
        }
        return result;
    }

    public static int replaceAndRemove(int size, char[] s){
        // forward iteration removes the b and counts all the a
        int writeIndex= 0, aCount=0;
        for(int i=0; i<size; i++ ){
            if(s[i] == 'b'){
                s[writeIndex] = s[i];
                writeIndex++;
            }
            if(s[i] == 'a'){
                aCount++;
            }
        }

        // replace all a with two d
        int currentIndex = writeIndex - 1;
        writeIndex = writeIndex + aCount - 1;
        int finalSize = writeIndex + 1;

        while ( currentIndex >= 0 ){
            if(s[currentIndex] == 'a'){
                s[writeIndex--] = 'd';
                s[writeIndex--] = 'd';
            }
            else{
                s[writeIndex--] = s[currentIndex];
            }
            currentIndex --;
        }
        return finalSize;
    }

    public static  boolean isPalidrome( String s ) {
        // two pointers
        int i =0; // start from front
        int j = s.length() - 1;  // start from back

        while ( i < j){ // if they hit each other then the sentence is a palidrome
            while( !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }

            while( !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase( s.charAt(j--))) {
                return false;
            }

        }

        return true;
    }

    public static void main( String [] args ) {

        String numb = "-123";
        int x = stringToInt(numb);
        int y = stringToInt_secondMethod(numb);
        System.out.println(y);

        int num1 = -145;
        String num1String = intToString(num1);
        System.out.println(num1String);

        String col = "BZ";
        int result = ssDecodeColId(col);
        System.out.println(result);

        char [] s = {'a', 'c' ,'d', 'b','c', 'a'};
        int size = s.length;
           int finalSize = replaceAndRemove(size, s);
        System.out.println("finalSize " + finalSize);

        String longWord = "A man,a plan, a canal, Panama";

        System.out.println(isPalidrome(longWord));
    }

}
