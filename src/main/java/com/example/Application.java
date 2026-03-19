package com.example;

public class Application {
    public static void main(String[] args) throws Exception {
        System.out.println("Application running...");

        // Keep app running
        while (true) {
            Thread.sleep(10000);
        }
    }
}
