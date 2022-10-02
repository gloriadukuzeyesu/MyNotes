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
    }
}