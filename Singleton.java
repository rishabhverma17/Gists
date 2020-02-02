package com.java.practice;

public class Singleton {

    /*** Create a private Static variable of type Singleton */
    private static Singleton singleton_instance = null;

    String str;

    /*** Mark the constructor as private */
    private Singleton(){
        str = "Hi from Singleton class.";
    }

    public static Singleton getSingleton_instance() {
        if(singleton_instance == null){
            singleton_instance = new Singleton();
        }
        return singleton_instance;
    }
}
