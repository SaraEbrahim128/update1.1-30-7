/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


public class InvoiceLineSIG {
    private String itemName;
    private int itemPrice;
    private int count;
    private InvoiceHeaderSIG headerSIG; 
    private int LineTotal ;
 
    // this is ref to header

    public InvoiceLineSIG(String itemName, int itemPrice, int count, InvoiceHeaderSIG headerSIG) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.headerSIG = headerSIG;
    }

    public InvoiceLineSIG(InvoiceHeaderSIG headerSIG) {
    }

    public InvoiceLineSIG(String itemName, int itemPrice, int count) {
    }

    public InvoiceHeaderSIG getHeaderSIG() {
        return headerSIG;
    }

    public void setHeaderSIG(InvoiceHeaderSIG headerSIG) {
        this.headerSIG = headerSIG;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getLineTotal() {
        return count * itemPrice ;
    }

        @Override
    public String toString() {
        return "InvoiceLines{" + "itemName=" + itemName + ", itemPrice=" + itemPrice + ", count=" + count + ", lineTotal=" + getLineTotal() + '}';
    }


}
        



    
    
