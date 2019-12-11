package com.company.inventoryprogram;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

class Inventory {

    private ArrayList<StockItem> units;

    Inventory() {

        units = new ArrayList<>();
    }


    void readData() {


        try {

            File fileName = new File("inventory.txt");
            FileReader fReader = new FileReader(fileName);  //Creation of File Reader object
            BufferedReader bReader = new BufferedReader(fReader); //Creation of BufferedReader object
            String line;

            StockItem unit; //creates component with all the fields inside which are separated with comas.


            while ((line = bReader.readLine()) != null) //Reading the content line by line
            {

                ArrayList<String> lineList = new ArrayList<>(Arrays.asList(line.split(",")));

                if (lineList.size() < 5) {
                    lineList.add(4, "lastValue");
                }

                String componentItemsSub = lineList.get(2);
                String componentItemsTrim = componentItemsSub.substring(1);

                String componentPriceSub = lineList.get(3);
                String componentPriceTrim = componentPriceSub.substring(1);

                String componentName = (lineList.get(0));
                String componentCode = (lineList.get(1));
                Integer componentItems = Integer.parseInt(componentItemsTrim); //Removes the space
                Integer componentPrice = Integer.parseInt(componentPriceTrim);
                String componentInformation = (lineList.get(4));

                unit = new StockItem(componentName, componentCode, componentItems, componentPrice, componentInformation);
                units.add(unit);
            }

            fReader.close(); //Close File Reader
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
    }

    //QUESTION 1

    void sortingPrice() {

        units.sort(new StockItem.compareByPriceInPence()); //Used collection sort method  to sort  price in pence by ascending order

        for (StockItem unit : units) {
            //System.out.println(unit.getComponentType()  + "  " + unit.getStockCode() + " |" + unit.getNumberOfItemsInStock() + "|" + unit.getAdditionalInformation() +" " + " | Price In Pence |: "  + unit.getUnitPriceInPence());  //prints the method of the object
            System.out.println(unit.getComponentType() + ","  +  unit.getStockCode() + ","  +  unit.getNumberOfItemsInStock()  +" , " + unit.getUnitPriceInPence() +"," + unit.getAdditionalInformation());  //prints the method of the object


        }
    }

    //QUESTION 2
    void largestNumOfComponents() {

        units.sort(Collections.reverseOrder(new StockItem.compareByLargestNumInStock())); //Used Collection.reverseOrder method  to sort number of components in descending  order

        System.out.println("The component with the largest number of components in stock is : " + units.get(0).getComponentType() + "" + units.get(0).getStockCode() +"| with : " + units.get(0).getNumberOfItemsInStock() +" Components");
    }

    //QUESTION 3
    void npnTransistors() {

        int total = 0;
        for (StockItem unit : units) {

            if (unit.getAdditionalInformation().substring(1).equals("NPN")) {

                total = total + unit.getNumberOfItemsInStock();
            }
        }
        System.out.println("Chartlins has | " + total +" | NPN transistors in stock ");
    }

    //QUESTION 4
    void totalResistance() {

        double grandTotal = 0;
        for (StockItem unit : units) {

            if (unit.getComponentType().equals("resistor")) {

                double additionalInformationDouble = Double.parseDouble(unit.getAdditionalInformation().substring(1));
                double tot = unit.getNumberOfItemsInStock() * additionalInformationDouble;

                grandTotal = grandTotal + tot;
            }

        }
        BigDecimal bigDecimal = new BigDecimal(grandTotal); //Takes out scientific notation and puts back into big decimal

        DecimalFormat decimalFormat = new DecimalFormat("0.00"); //Rounds the number into 2 decimal points
        System.out.println("Total resistors of all resistors in stock is |:  " + decimalFormat.format(bigDecimal) +" |rounded up to two decimal places"); //Adds the pattern
    }

    //QUESTION 5
    void sortByPrice() {

        int countNumber = 0;
        for (StockItem unit : units) {

            if (unit.getUnitPriceInPence() > 10) {
                countNumber = countNumber + 1;
            }
        }
        System.out.println( " | "+ countNumber + " | " + " Stock items have unit price above 10p ");
    }
}


