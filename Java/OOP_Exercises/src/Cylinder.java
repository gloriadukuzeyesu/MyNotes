import static java.lang.Math.PI;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(){
        super(); // calls superClass nor-arg constructor Circle()
        height = 1.0;
    }
    public Cylinder (double height) {
        super();
        this.height = height;
    }
    public Cylinder(double radius, double height){
        super(radius); // calls the parent constructor with radius as argument Circle(r)
        this.height = height;
    }

    //methods
    public double getHeight(){
        return height;
    }

    @Override
    public double getArea() {
        return 2 * PI * super.getRadius() * height + 2 * PI * super.getRadius() * super.getRadius();
    }

    public double getVolume(){
        return getArea() * height;
    }
    @Override
    public String toString(){
        return "Cylinder: subclass of " + super.toString() + " height=" + height;

    }

}
