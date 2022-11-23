public class Cat extends Animal {

    //fields
    private String color;

    public Cat( boolean veg, String food, int legs) {
        super(veg,food,legs);
        this.color = "White";
    }

    public Cat( boolean veg, String food, int legs, String color) {
        super(veg,food,legs);
        this.color = color;
    }
    public String getColor () {
        return color;
    }
    public void SetColor (String color ) {
        this.color = color;
    }
}
