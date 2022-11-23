import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while ( current != null ){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static void  test(){
        System.out.println("hello");
    }

    public static boolean isIsomorphic(String s, String t)
    {
        HashMap<Character, Character> hashMap = new HashMap<>();
        if(s.length() != t.length())
            return false;
        // store the chars into map and check if they map
        for ( int i=0; i < s.length(); i++ )
        {
            if( hashMap.containsKey(s.charAt(i)))
            {
                if( hashMap.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else if (hashMap.containsValue(t.charAt(i)))
                    return false;
            else
                hashMap.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }

    public static int[] nextGreaterElement(int[] nums1, int [] nums2)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for ( int n : nums2 )
        {
            while (!stack.isEmpty() && stack.peek() < n )
            {
                hashMap.put(stack.pop(), n);
            }
            stack.push(n);
        }

        for  ( int i=0; i<nums1.length; i++ )
        {
            nums1[i] = hashMap.getOrDefault(nums1[i], -1);
        }

        return nums1;

    }

    public static char findTheDifference(String s, String t) {
            char c = 0;
            for(char cs : s.toCharArray()) c ^= cs;
            for(char ct : t.toCharArray()) c ^= ct;
            return c;
        }

    public static void  merge ( int[] nums1, int m, int[] nums2, int n ){
       int pos = 0;
       for ( int i= m; i<m+n; i++){
           nums1[i] = nums2[pos];
           pos++;
       }
       Arrays.sort(nums1);

    }

    public static int[] twoSum (int []nums, int target ){
        for ( int i =0; i< nums.length; i++ ) {
            for ( int j = i+1; j< nums.length; j++ ) {
                if(nums[j] == target - nums[i]) {
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    public static int[] two_Sum (int []nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i< nums.length; i++){
            int compliment = target- nums[i];
            if (map.containsKey(compliment)) {
                return new int[] {map.get(compliment), i};
            }
            map.put(nums[i], i);
        }
        return null;

    }

    public static boolean is_Valid(String s) {
        Stack<Character> stack = new Stack<>();
        for ( char c : s.toCharArray()) {
            if( c == '(' || c== '{' ||c =='[') {
                stack.push(c);
            } else if( c== ')' &&  !stack.isEmpty() &&  stack.peek() == '(' ) {
                stack.pop();
            } else if ( c== '}' &&  !stack.isEmpty()&&  stack.peek() == '}'){
                stack.pop();
            } else if (c== ']' &&  !stack.isEmpty() &&  stack.peek() == ']' ){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty(); // returns true if the stack is empty

    }

 /*   public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int num1Size = nums1.length;
        int num2Size = nums2.length;
        if(num1Size < num2Size) {
            for ( int i= 0; i< num2Size; i++) {
                if(map.containsKey(nums1[i])){
                    return new int[] {nums2[i]};
                }
                map.put(nums2[i], i);
            }
        } else{
            for ( int i= 0; i< num1Size; i++) {
                if(map.containsKey(nums2[i])){
                    return new int[] {nums2[i]};
                }
                map.put(nums2[i], i);
            }

        }
        return null;
    }*/
    public static int [] intersection (int[] nums1, int[] nums2) {
        // create an arraylist to store the resp
        //convert an arraylist to array
        //create a set to store num1 data
        ArrayList<Integer> arrayList  = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for ( int i = 0; i< nums1.length; i++ ){
            set.add(nums2[i]);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                arrayList.add(i);
                set.remove(i);
            }
        }
        int [] resp = new int[arrayList.size()];
        for ( int k = 0; k< arrayList.size(); k++) {
            resp[k] = arrayList.get(k);
        }
        return resp;
    }

    public static int removeDuplicates(int[] nums) {
        int p = 0;
        //loop over
        // if i != i+1 then a new number

        if (nums.length == 0) {
            return 0;
        }
        for( int i= 1; i< nums.length; i++ ){
            if(nums[i] != nums[i-1]){
                p++;
                nums[p] = nums[i]; // insert the new int to the new position
            }
        }
        return p+1;

    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for ( int i = 0; i< nums.length; i++ ) {
            if( nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }





    public static void main(String[] args) {
        /*ListNode mylist = new ListNode(2);


        reverseList (mylist);
        ListNode answ = reverseList (mylist);
         System.out.println(answ);
         test();

         boolean res = isIsomorphic("aab", "cch");
         System.out.println(res);

         int[] num1 = new int[] {2,4};
         int[] num2 = new int[] {1,2,3,4};
         int [] respo = nextGreaterElement(num1, num2);
         for (int j : respo) {
             System.out.println(j);
         }

         String s = "abcd";
         String t = "abcde";
         char c = findTheDifference(s,t);
         System.out.println(c);

         int []nums1 = new int[]{1,2,3};
         int []nums2 = new int[] {2,5,6};
*//*
         merge(nums1, 3,nums2,3);
*//*
*/
         int []nums = new int[] {2,7,11,15};
         int target = 9;
         int [] sumOfTwoNumber = two_Sum(nums, target);
         for(int i: sumOfTwoNumber){
             System.out.println( "The answer is " + i);
         }

        int [] arr = new int[]{1,1,2};
        int [] arr1 = new int[]{0,0,1,1,1,2,2,3,3,4};

        int l = removeDuplicates(arr1);
        System.out.println(l);

        int [] test1 = new int[] {3,2,2,3 };
        int val1 = 3;
        int m = removeElement(test1,val1);
        System.out.println(m);

        int [] test2 = new int[] {0,1,2,2,3,0,4,2};
        int val2 = 2;
        int n = removeElement(test2,val2);
        System.out.println(n);

        int [][] twoDimensionalArray = new int[][] {{1,1},{2,2},{4,4},{10,20}};
        System.out.println("Printing 2D array");
        for( int i=0; i<4; i++){
            for(int j=0; j<2;j++){
                System.out.println(twoDimensionalArray[i][j] );
            }
            System.out.println();
        }

        int [][]board = new int  [4][4];
        System.out.println("Printing a board");
        for (int row =0; row< board.length; row++ ){
            for ( int column=0; column < board.length; column++) {
                board[row][column] = row * column;
                System.out.println(board[row][column] + "\t");
            }
            System.out.println();
        }

    }



}
