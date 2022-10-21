# Midterm Exam sample coding problems



## Question 1

Ask the user for a file name.  (Continue asking until a valid (existing) file name is entered.)  Read all text from that file and calculate, store, and print out the number of times each letter occurs.  As an extra challenge, print out the letters (and corresponding counts) in order of the most occurring to the least.

```java
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
                    for ( int i = 0; i <lineString.length(); i++ ) {

                        if ( lineString.charAt(i) >= 'a' && lineString.charAt(i) <= 'z') {
                            arrayListOfCharacters.add(lineString.charAt(i));
                        }

                    }
                    // TODO store the data into a hashmap . key as a character and Value as how many times a 												character appears
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
              
                Collections.sort(IntValues); // sort values 
              
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
        scanner2.close();
        scanner.close();
    }
}
```



## Question 2

Choose a random number from 1 to 100.  Ask the user to guess that number.  After each guess, tell the user if their guess was too low or too high (or that they win).  Additional challenges: a) only allow the user to make 10 guesses before they lose; b) Let the user know if they have already guessed a number.

```java
public static void main ( String [] args ) {
    int secretNumber;
    int attempt= 0;
    secretNumber = (int) (Math.random() * 100);
    System.out.println("Secret number " + secretNumber);
    Scanner keyBoard = new Scanner(System.in);
    int userInput = 0;
  do {
    System.out.println("Enter a guess number between 1-100: ");
    if ( keyBoard.hasNextInt()) {
      userInput = keyBoard.nextInt();
      if (userInput == secretNumber) {
        System.out.println("Your guess is right! Congratulation!!");
        System.exit(0);
      } else if (userInput < secretNumber) {
        System.out.println("Your guess is smaller than the Secret number ");
      } else if (userInput > secretNumber) {
        System.out.println("Your guess is greater than the Secret number ");
      }
      attempt++;
      if (attempt == 10) {
        System.out.println(" You've reached the maximum attempts. Try again later");
        System.out.println("The secret number was " + secretNumber);
        System.exit(0);
      }
    }
    else {
      System.out.println("Enter a valid number");
      System.exit(0);
    }
  }
  while (userInput != secretNumber);
}

```



## Question 3

Assume January 1 is a Monday. Ask the user to enter a day of the year (1-365) and display what day of the week it is.  Hint: Use the mod (%) function: If the user enters 1, you would display Monday. If the user enters 2, Tuesday ... enters 7, display Sunday - what about 8?  Monday again.

```java
 public static void main(String[] args) {
        // declare variables to store days
        int daysOfTheWeek = 7;
        Scanner keyboard = new Scanner(System.in);
        int userInput;
        boolean validNumber = true;

            System.out.println(" Enter day of the year between 1-365: ");
            if (keyboard.hasNextInt()) {
                userInput = keyboard.nextInt();
                validNumber = true;

                if (userInput % daysOfTheWeek == 1) {
                    System.out.println(" The entered day is Monday ");
                } else if (userInput % daysOfTheWeek == 2) {
                    System.out.println(" The day is Tuesday ");
                } else if (userInput % daysOfTheWeek == 3) {
                    System.out.println(" The day is Wednesday ");
                } else if (userInput % daysOfTheWeek == 4) {
                    System.out.println(" The day is Thursday ");
                } else if (userInput % daysOfTheWeek == 5) {
                    System.out.println(" The day is Friday ");
                } else if (userInput % daysOfTheWeek == 6) {
                    System.out.println(" The day is Saturday ");
                } else if (userInput % daysOfTheWeek == 0) {
                    System.out.println(" The day is Sunday");
                }
            } else {
                System.out.println("Invalid number. Try again");

            }
               keyboard.close();

    }
```

### Short way to solve Q3

```java
 Scanner sc = new Scanner(System.in);
        int day = -1;
        while ( day < 1 || day > 365 ) {
            System.out.println("Enter a day of the year between 1-365: ");
            day = sc.nextInt();
        }
        String[] daysArray = { "Sunday", "Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println( "The day is " + daysArray[day % 7]);
```

## Question 4 

Write a function that takes in an array of numbers and returns the 3 largest numbers in that array. (Consider how you would do it using just basic programming techniques, and then how you could do it (much more easily) using more advanced data structures (and associated methods).



```java
    public static void threeLargestNumbers(int[] numbers, int arraySize) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        /*there should be at least three elements */
        if(arraySize < 3 ) {
            System.out.println("Invalid input, the array size is less than 3");
            return;
        }

        for ( int i=0; i< arraySize ; i++ ) {
            /* if current element is greater than first, assign first to second, second to third,
            and current to        first, order matters */
            if ( numbers[i] > first ) {
                third = second;
                second = first;
                first = numbers[i];
            }
            /*If above step is not true then current element might be a candidate of second highest element,
            so check if current>second, if yes then assign second value to third and assign current to second.*/
            else if (numbers[i] > second) {
                third = second;
                second = numbers[i];
            }
            /*If above step is not true then current element might be a candidate of third highest element, so
            check if current>third, if yes then assign current to third*/
            else if ( numbers[i] > third) {
                third = numbers[i];
            }
        }
        System.out.println("Three largest elements are " + first + " " + second + " " + third);
    }

```

```java
    public static void printLargest( int[] arr, int arr_size){
        Arrays.sort(arr);
        if ( arr_size < 3 ) {
            System.out.println("Invalid input, The array size is less than 3");
            return;
        }
        arr_size = arr.length;
        int x, y, z;
        x = arr [arr_size -1];
        y = arr [arr_size -2];
        z = arr [arr_size -3];

        System.out.println("The Largest three elements are " + x + " " + y + " " + z);
    }

```

```java
  public  int [] choose3largestNumbers ( int [] arr ){
        Arrays.sort(arr);
        int [] res = new int[3];
        for (int i=0; i<3; i++ ) {
            res[i] = arr[arr.length-1-i];
        }
        return res;
    }
```



## Question 5

What is the output of the following code (and why)?

```java
int  x = 130;
byte b = (byte)x;
System.out.println( b ) // returns -126, byte is always signed in java therefore
  // the 2's complement of 10000010 (130) is 01111110 which is 126 decimal and sign is always preserved. Hence -126
```



## Question 6

What is invalid about this code (and why):

```java
class HelloWorld {
   int x = 10;
   public static void main(String[] args) {
       System.out.println( x );
   }
}
```

Answer: main is a static method and it can not call a non-static variable x 



## Question 7

 One-shot server: Write an http server that accepts a single message from a client in the form of a string, prints that string to the console, then shuts itself down. The string will be passed using a get request from the client, right after "/".

```java
   public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept();
        Scanner keyBoard = new Scanner(System.in);
        String Firstline = keyBoard.nextLine();
        String messageFromClient = Firstline.split(" ")[1];
        messageFromClient = messageFromClient.substring(1);
        System.out.println("messageFromClient "+ messageFromClient);
        clientSocket.close();
        serverSocket.close();
    }
```

