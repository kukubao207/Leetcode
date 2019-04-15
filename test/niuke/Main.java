package niuke;

import java.util.Scanner;

public class Main implements Runnable{
    int x, y, z;
    long a[] = new long[55];
    long b[] = new long[55];
    public enum EEnum{
        PREFECT,
        WORLD,
    }
    public void run(){
        System.out.println("123");
    }
    public void run(Runnable r){
        System.out.println("12345");
    }
    public static void main(String[] args){
        new Thread(new Main()).start();
    }

}
