package edu.umb.cs680.hw02;

public class Singleton {

    private static Singleton Singleton = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(Singleton == null) {
            Singleton = new Singleton();
        }
        return Singleton;
    }

    public static void main(String[] args) {
        System.out.println("This is Singleton Class");
    }


}
