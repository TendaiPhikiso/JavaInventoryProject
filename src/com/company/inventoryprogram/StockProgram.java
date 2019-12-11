package com.company.inventoryprogram;



public class StockProgram
{
    public static void main(String[] args) {
        Inventory inv = new Inventory(); //an object of the inventory class
        inv.readData();

        //Question 1 (Print a list of the inventory, sorted in order of increasing price.)
        System.out.println("**********************");
        System.out.println("* QUESTION NUMBER : 1 *");
        System.out.println("**********************");
        inv.sortingPrice();

        //Question 2 (What is the component with the largest number of components in stock?)
        System.out.println("***********************");
        System.out.println("* QUESTION NUMBER : 2 *");
        System.out.println("***********************");
        inv.largestNumOfComponents();

        //Question 3 (How many NPN transistors does Chartlins have in stock?)
        System.out.println("***********************");
        System.out.println("* QUESTION NUMBER : 3 *");
        System.out.println("***********************");
        inv.npnTransistors();

        //Question 4 (What is the total resistance of all of the resistors in stock?)
        System.out.println("***********************");
        System.out.println("* QUESTION NUMBER : 4 *");
        System.out.println("***********************");
        inv.totalResistance();

        //Question 5 ( How many stock items have unit prices above 10p? )
        System.out.println("***********************");
        System.out.println("* QUESTION NUMBER : 5 *");
        System.out.println("***********************");
        inv.sortByPrice();

    }
}

