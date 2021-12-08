package com.company;
/**
 * Write a description of class Program here.
 *
 * @author (Amir)
 * @version (03/12/2021)
 */

public class Main
{
    private static StockApp app;
    public static void main(String[] args)
    {
        //System.out.println("hello world");
        app = new StockApp();
        app.run();
    }
}
