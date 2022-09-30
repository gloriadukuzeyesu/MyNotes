import java.sql.SQLOutput;

public class Main {

        static  int x = 10;
        int y = 20;

        void print_nonstatic (){
            System.out.println("x: " + x);
            System.out.println("x: " + y);
        }

        static void print_static () {
            System.out.println(x);
//            System.out.println(y);
        }


        public static void main(String[] args) {
            String S1 = "Hello";
            String S2 = "Hello";
            String S3 = new String("Hello");

            System.out.println(S1 == S2); // returns true
            System.out.println(S1.equals(S2)); // returns true

            System.out.println("comparing S1 and S3: "+ S1.equals(S3)); // returns true


//            print_nonstatic ();
            print_static();




//        class StaticMethods{
//            static int x = 10;
//            int y= 20;
//
//        }


        }
}
