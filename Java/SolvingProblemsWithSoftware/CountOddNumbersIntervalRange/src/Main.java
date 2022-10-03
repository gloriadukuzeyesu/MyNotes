import java.util.ArrayList;







public class Main {
    public int CountOdds ( int low, int high) {
        int numbs = high - low + 1; //total numbers in range

        if ( low%2 != 0 && high%2 != 0)
            return numbs/ 2 + 1;

        else
            return numbs/2;
    }
}