import javax.sound.midi.Soundbank;

public class Thing {
    private int a;

    public Thing (int x) {
        a = x;
    }
    public int getA () {
        return a;
    }
    public void Combine (Thing y) {
        a = a + y.getA();
    }


    public static void main(String[] args) {
        Thing f = new Thing(6);
        Thing g = new Thing(8);

        f.Combine(g);

        System.out.println(f.getA()); //14
        System.out.println(g.getA()); // 8

    }
}