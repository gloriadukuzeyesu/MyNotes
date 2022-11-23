public class TestCircle {

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.setColor("orange");
        c1.setRadius(5);
        System.out.println("The circle1 has the radius of: " + c1.getRadius() + " an area of " + c1.getArea() + " its color is: "+ c1.getColor());


        Circle c2 = new Circle(2);
        c2.setColor("brown");
        c2.setRadius(7);
        System.out.println("The circle2 has a radius of: " + c2.getRadius() + " an area of " + c2.getArea() + " its color is: "+ c2.getColor());


        Circle c3 = new Circle(4,"blue");
        c3.setColor("grey");
        c3.setRadius(2);
        System.out.println("The circle2 has a radius of: " + c3.getRadius() + " an area of " + c3.getArea() + " its color is: "+ c3.getColor());
        System.out.println(c3.toString());
        System.out.println(c3);
        System.out.println("Operator + " + " Invokeds toString() too " + c3);


    }
}