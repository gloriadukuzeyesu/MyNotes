import java.io.File;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // prompt the user
        boolean validFileName = true;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = null;
        String lineString = " ";
        File inputFile;

        ArrayList<Character> arrayListOfCharacters = new ArrayList<>();

        HashMap<Character, Integer> charHashMapCount = new HashMap<>();

        //TODO create a linkedHashmap to store stored values
        LinkedHashMap<Character, Integer> sortedMapCount = new LinkedHashMap<>();

        // TODO create an arrayList that will store the values
        ArrayList<Integer> IntValues = new ArrayList<>();

        do {
                System.out.println("Enter the file name");
                String inputFileName = scanner.nextLine();
                inputFile = new File(inputFileName);

            if (inputFile.exists()) {
                validFileName = true;

                // read the file
                scanner2 = new Scanner(inputFile);
                while (scanner2.hasNext()) {
                    lineString = scanner2.nextLine();
                    lineString = lineString.toLowerCase();
                    System.out.println(lineString);
                    for ( int i = 0; i <lineString.length(); i++ ) {
                        if ( lineString.charAt(i) >= 'a' && lineString.charAt(i) <= 'z') {
                            arrayListOfCharacters.add(lineString.charAt(i));
                        }
                    }
                    // TODO store the data into a hashmap . key as a character and Value as how many times a character appears
                    for (char character : arrayListOfCharacters) {
                        System.out.println(" list of character " + character);
                            if (charHashMapCount.containsKey(character)) {
                                charHashMapCount.put(character, charHashMapCount.get(character) + 1);
                            } else {
                                charHashMapCount.put(character, 1);
                            }
                    }
                }
                System.out.println("Here is the total " + charHashMapCount);

                // the following code will help me sort my hashmap by its values
                for (Map.Entry<Character, Integer> entry : charHashMapCount.entrySet()) {
                    IntValues.add(entry.getValue());
                }

                Collections.sort(IntValues);

                for ( int num : IntValues ) {
                    for (Map.Entry< Character, Integer> entry : charHashMapCount.entrySet()) {
                        if ( entry.getValue().equals(num)) {
                            sortedMapCount.put(entry.getKey(), num);
                        }
                    }
                }

                System.out.println("The sorted total: " + sortedMapCount);

            } else {
                System.out.println("Invalid fileName. Try again.");
                validFileName = false;
            }

        } while (!validFileName);
        System.out.println("next steps");
        scanner2.close();
        scanner.close();
    }
}