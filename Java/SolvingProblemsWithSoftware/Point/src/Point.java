public class Point {

    private int x;
    private  int y;

    public  Point (int startx, int starty) {
        x = startx;
        y = starty;
    }

    public int getX () {return x;}
    public  int getY () {return  y;}
    public  double distance (Point otherPT) {
        int dx = x - otherPT.getX();
        int dy = y - otherPT.getY();
        return Math.sqrt(dx * dx + dy * dy);
        //.sqrt returns the positive square root of the given number
    }

    public static void main(String[] args) {

        Point p1 = new Point(3,4);
        Point p2 = new Point(6,8);

        System.out.println(p1.distance(p2));
        // after the method call is done. we destroy its frame and start our program


        // My notes. Conversion between Types
        double d = 3.14;
        int k = (int) d; // cast. tell the computer that you are absolute sure of what you are doing
        System.out.println(k);
        int m= 3;
        double l= m;
        System.out.println("the value of l is : " + l);

        // Other requires a method call
        String myString = "3";
        int x = Integer.parseInt(myString); // casting strings is a little complicated
        System.out.println("the value of x is: " + x);

    }
}