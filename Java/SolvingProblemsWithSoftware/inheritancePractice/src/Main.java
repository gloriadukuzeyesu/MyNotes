public class Main {
    public static void main( String [] args) {
        Cat cat = new Cat(false, "milk", 4, "black");
        System.out.println("Cat is vegeterian" + cat.isVegeterian());
        System.out.println("Cat eats " + cat.getEats());
        System.out.println("Cat has " + cat.getNoOfLegs() + " legs");
        System.out.println("Cat color is " + cat.getColor());


        Cat c = new Cat(false, "milk", 4, "brown");
        Animal ani = c;
        System.out.println(c.getColor()); // upcasting happens when we create an instance of subclass and assign
        //it to superClass variable.

        Cat myCat = new Cat(false, "chococate Milk", 4, "blue");
        Animal animal = myCat;
        Cat myCat1 = (Cat) animal; // downcasting

        System.out.println( animal.getEats());
        System.out.println(((Cat) animal).getColor()  );

    }
}
