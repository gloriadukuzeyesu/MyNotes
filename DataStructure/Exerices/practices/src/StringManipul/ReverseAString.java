package StringManipul;

public class ReverseAString {

    public static String   reverseWords ( String s){
        // "Alice likes Bob" => "Bob likes Alice
        String[] words = s.split(" ");
        String reversed= " ";

        for( String word : words){
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            reversed += sb.toString() + " ";
        }
//        reversing(reversed);

        return reversed.trim();

    }

    public static void reversing(String s){
        String[] words = s.split(" ");

        for( int i=1; i<words.length;i++){
            String temp = words[i];
            words[i] = words[i-1];
            words[i-1] = temp;
        }

    }

    public static String reverseAWord(String s) {
        char[] characters = s.toCharArray();
        int pointerOne = 0;
        int pointerTwo = characters.length - 1;
        while ( pointerOne < pointerTwo && pointerOne < characters.length) {
            char temp = characters[pointerOne];
            characters[pointerOne] = characters[pointerTwo];
            characters[pointerTwo] = temp;
            pointerOne ++;
            pointerTwo --;
        }
        return String.valueOf(characters).trim();
    }

    public static void main( String [] args ) {
        /*String myName = "Gloria Dukuzeyesu";
        String reversed = reverseWords(myName);
        System.out.println(reversed);*/
   /*
        “Cat”, return “taC”
“The Daily Byte”, return "etyB yliaD ehT”
“civic”, return “civic”*/

        String animal = "Cat";
       var resp = reverseAWord(animal);
        System.out.println(resp);
    }

}
