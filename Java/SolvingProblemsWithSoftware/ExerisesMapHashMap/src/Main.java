import java.util.HashMap;

public class Main {

    public static void main(String[] args)
    {
        HashMap < String, Integer>employeeIDs  = new HashMap<String, Integer>();
        employeeIDs.put("Gloria", 12345);
        employeeIDs.put("Angel", 6789);
        employeeIDs.put("Amie", 7827472);

        System.out.println(employeeIDs);
        System.out.println( employeeIDs.get("Gloria")); // returns 12345

        System.out.println(employeeIDs.containsKey("Amie")); // returns true bcz this key exists
        System.out.println(employeeIDs.containsKey("Marmal")); // returns false because there is no Marmal in the Hashmap


        System.out.println(employeeIDs.containsValue(12345)); // true
        System.out.println(employeeIDs.containsValue(12)); // false

        employeeIDs.put("Gloria", 234743820);
        System.out.println(employeeIDs); // updated hasmap Gloria's value has been update

        employeeIDs.replace("Gloria", 7777);
        System.out.println(employeeIDs);
        employeeIDs.replace("John", 123333);
        System.out.println(employeeIDs); // nothing changes because we don't have the Key Johh. we can use put if we want to add him in the hashmap

        employeeIDs.putIfAbsent("Sabah", 233);
        System.out.println(employeeIDs);

        employeeIDs.remove("Gloria");
        System.out.println(employeeIDs);


        int x = 130;
        byte b = (byte) x; // while casting an int to Bytes, Java save the last 8 bits of int to byte and throw others left 24 bits
        int k = Byte.toUnsignedInt(b); // use this method when you want  print the unsinged
        System.out.println( "b is " +  b );
        System.out.println( "b is " +  k );

        int xy = 241;
        byte mk = (byte) xy;
        System.out.println("mk is "+ mk);


        int y = 255;
        byte c = (byte) y;
        System.out.println("c is " + c );


        int i = 0xff00;
        byte d = (byte)i;

        System.out.println("d is " + d );


        int  num = 100;
        byte numToBye = (byte) num;
        System.out.println("num to byte "+ numToBye);
























    }
}