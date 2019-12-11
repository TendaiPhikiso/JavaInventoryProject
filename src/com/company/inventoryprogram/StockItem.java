package com.company.inventoryprogram;
import java.util.*;



class StockItem  {

    private String componentType;
    private String stockCode;
    private Integer numberOfItemsInStock;
    private Integer unitPriceInPence;
    private String additionalInformation;


    StockItem(String componentType, String stockCode, Integer numberOfItemsInStock, Integer unitPriceInPence, String additionalInformation) {

        this.componentType = componentType;
        this.stockCode = stockCode;
        this.numberOfItemsInStock = numberOfItemsInStock;
        this.unitPriceInPence = unitPriceInPence;
        this.additionalInformation = additionalInformation;
    }

    String getComponentType() {
        return componentType;
    }

    String getStockCode() {
        return stockCode;
    }

    Integer getNumberOfItemsInStock() {
        return numberOfItemsInStock;
    }

    Integer getUnitPriceInPence() {
        return unitPriceInPence;
    }

    String getAdditionalInformation() {
        return additionalInformation;
    }


     static class compareByPriceInPence implements Comparator<StockItem> {

       public int compare(StockItem a , StockItem b) {
           return a.unitPriceInPence - b.unitPriceInPence;
        }
    }

     static class compareByLargestNumInStock implements Comparator<StockItem> {

        public int compare(StockItem a , StockItem b) {
            return a.numberOfItemsInStock - b.numberOfItemsInStock;
        }
    }

}
