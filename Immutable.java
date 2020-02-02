package com.java.practice;

/*
    Immutable means : Once the object has been created, The object
    state cannot be modified.

    This Class Can be instantiated but cannot be extended.
*/

// Class available to all for instansiation(Communicaiton)
// So marked as public

/*** Step 1: Make the class as final class. ***/
// So Extensions are not allowed (Cannot Override).
final public class Immutable {

    /*** Step 2: Declare all properties as Private. ***/
    // So that only object is visible and not the properties.
    // Making it final so its value can be set only once.
    private final int a;

    /*** Step 3: Innitialize value using contructors. ***/
    Immutable(int a) {
        this.a = a;
    }

    /*** Step 4: Do not provide setters. ***/
    // public void setA(int a){
    // this.a = a;
    // }

    /*** Step 5: Access information of immutable objects through Getters only. ***/
    public int getA() {
        return this.a;
    }

}