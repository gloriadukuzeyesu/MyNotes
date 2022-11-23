public class Animal {

    private boolean vegeterian;
    private String eats;
    private int noOfLegs;

    public Animal() {
    }

    public Animal(boolean veg, String food, int legs) {
        this.vegeterian = veg;
        this.eats = food;
        this.noOfLegs = legs;
    }

    //methods;
    public boolean isVegeterian() {
        return vegeterian;
    }

    public void SetVegeterian(boolean vegeterian) {
        this.vegeterian = vegeterian;
    }

    public String getEats() {
        return eats;
    }

    public void setEats(String eats) {
        this.eats = eats;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }
}