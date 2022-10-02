//import edu.duke.*;




public class HelloWorld {
    public void runHello () {
        File file = new File ();
        FileResource res = new FileResource("hello_unicode.txt");
        for (String line : res.lines()) {
            System.out.println(line);
        }
    }
    
    public int f (int x, int y){
        if (x < y) {
                System.out.println("x <y");
                return y + x;
        
          
            }
            else {
              System.out.println ( " x >= y");
              if (x > 8) {
                  return y + 7; 
              }
              
              return x -2;
            }

    }
    public int g () {
        int a = f (3,4);
        int b = f (a,5);
        return b;
    
    }
}
