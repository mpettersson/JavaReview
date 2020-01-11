package com.mpettersson.questions.concurrent;

import java.util.function.Function;
import java.util.function.Predicate;

public class FizzBuzz {

    public static void main(String[] args) {


        int n = 100;

        System.out.println("FizzBuzz:");
        Thread[] threads = {
                new FizzBuzzThread(true, true, n, "FizzBuzz"),
                new FizzBuzzThread(true, false, n, "Fizz"),
                new FizzBuzzThread(false, true, n, "Buzz"),
                new NumberThread(false, false, n),
        };

        for(Thread thread : threads){
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join(5000);
            }
        }catch (Exception e) {
            System.out.println("Exception: " + e.toString());
        }
        System.out.println();

        System.out.println("FizzBuzz using Java 8:");
        Thread[] java8Threads = {
                new FizzBuzzJava8Thread(i -> i % 3 == 0 && i % 5 == 0, i -> "FizzBuzz", n),
                new FizzBuzzJava8Thread(i -> i % 3 == 0 && i % 5 != 0, i -> "Fizz", n),
                new FizzBuzzJava8Thread(i -> i % 3 != 0 && i % 5 == 0, i -> "Buzz", n),
                new FizzBuzzJava8Thread(i -> i % 3 != 0 && i % 5 != 0, i -> Integer.toString(i), n),
        };

        for(Thread thread : java8Threads){
            thread.start();
        }


    }
}

class FizzBuzzThread extends Thread {
    private static Object lock = new Object();
    protected static int current = 1;
    private int max;
    private boolean div3, div5;
    private String toPrint;

    public FizzBuzzThread(boolean div3, boolean div5, int max, String toPrint) {
        this.div3 =  div3;
        this.div5 = div5;
        this.max = max;
        this.toPrint = toPrint;
    }

    public void print(){
        System.out.println(toPrint);
    }

    @Override
    public void run() {
        while(true){
            synchronized (lock){
                if(current > max){
                    return;
                }
                if((current % 3 == 0) == div3 && (current % 5 == 0) == div5) {
                    print();
                    current++;
                }
            }
        }
    }
}


class NumberThread extends FizzBuzzThread{
    public NumberThread(boolean div3, boolean div5, int max){
        super(div3, div5, max, null);
    }
    public void print(){
        System.out.println(current);
    }
}


class FizzBuzzJava8Thread extends Thread{
    private static Object lock = new Object();
    protected static int current = 1;
    private int max;
    private Predicate<Integer> validate;
    private Function<Integer, String> printer;
    int x = 1;

    public FizzBuzzJava8Thread(Predicate<Integer> validate, Function<Integer, String> printer, int max){
        this.validate = validate;
        this.printer = printer;
        this.max = max;
    }

    @Override
    public void run() {
        while(true){
            synchronized (lock){
                if(current>max){
                    return;
                }
                if(validate.test(current)){
                    System.out.println(printer.apply(current));
                    current++;
                }
            }
        }
    }
}
