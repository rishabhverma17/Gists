package com.java.practice;

/*** Example of Deep Copy and Shallow Copy ***/
public class Copy {
    public void caller(){
        shallowCopy();
        System.out.println();
        deepCopy();
    }
    private void shallowCopy(){
        System.out.println("\n----- In Class Copy, In Method shallowCopy -----");

        int[] myBaseArray = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println("\nPrinting Base Array");
        for(int val : myBaseArray)
        {
            System.out.print(val +", ");
        }
        int[] myShallowArray;

        // Shallow Copy
        myShallowArray = myBaseArray;

        // Now print
        System.out.println("\nPrinting copied Array");
        for(int val : myShallowArray)
        {
            System.out.print(val +", ");
        }

        // Making changes in base array
        myBaseArray[0] = 1000;
        myBaseArray[1] = 2000;

        System.out.println("\nPrinting copied Array after change in base array");
        for(int val : myShallowArray)
        {
            System.out.print(val +", ");
        }
    }

    public void printArray(int arr[]){
        for(int val : arr)
        {
            System.out.print(val +", ");
        }
    }

    private void deepCopy(){
        System.out.println("\n----- In Class Copy, In Method deepCopy -----");
        int[] myBaseArray = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Printing Base Array");
        printArray(myBaseArray);

        int[] myDeepArray = new int[myBaseArray.length];
        int i = 0;
        for(int val : myBaseArray){
            myDeepArray[i] = val;
            i++;
        }
        System.out.println("\nPrinting copied Array");
        printArray(myDeepArray);

        myBaseArray[0] = 99;
        myBaseArray[1] = 2488;

        System.out.println("\nPrinting copied Array after changing the base array");
        printArray(myDeepArray);
    }
}
