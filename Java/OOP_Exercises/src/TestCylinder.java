public class TestCylinder {
    public static void main ( String [] args ) {
        Cylinder cylinder1 = new Cylinder();
        System.out.println("Cylinder1: "
                + "radius = " + cylinder1.getRadius()
                + " color = " + cylinder1.getColor()
                + " height = " + cylinder1.getHeight()
                + " Volume = " + cylinder1.getVolume()
                + " base area = " + cylinder1.getArea()
        );

        Cylinder cylinder2 = new Cylinder(10.0);
        System.out.println("Cylinder2: "
                + "radius = " + cylinder2.getRadius()
                + " color = " + cylinder2.getColor()
                + " height = " + cylinder2.getHeight()
                + " Volume = " + cylinder2.getVolume()
                + " base area = " + cylinder2.getArea()
        );
        Cylinder cylinder3 = new Cylinder(10.0,5.0);
        System.out.println("Cylinder3: "
                + "radius = " + cylinder3.getRadius()
                + " color = " + cylinder3.getColor()
                + " height = " + cylinder3.getHeight()
                + " Volume = " + cylinder3.getVolume()
                + " base area = " + cylinder3.getArea()
        );
        System.out.println( " toString() " + cylinder3.toString());



    }

}
