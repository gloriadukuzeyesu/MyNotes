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

    public static void main( String [] args ) {
        String myName = "Gloria Dukuzeyesu";
        String reversed = reverseWords(myName);
        System.out.println(reversed);
    }

}
