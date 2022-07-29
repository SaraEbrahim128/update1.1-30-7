/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author MUSLIM
 */
public class InvoiceHeaderSIG {

    private int invoiceNumber;
    private String CustomerName;
    private String invoiceDate;
    private double Total;

  private  ArrayList<InvoiceLineSIG> invoiceLines;
    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    private ArrayList<InvoiceLineSIG> getinvoiceLines;

    public InvoiceHeaderSIG(int invoiceNumber, String CustomerName , String invoiceDate) {
        this.invoiceNumber = invoiceNumber;
        this.CustomerName = CustomerName;
        this.invoiceDate = invoiceDate;
    }

    public InvoiceHeaderSIG() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<InvoiceLineSIG> getGetinvoiceLines() {
        if(getinvoiceLines == null){
            getinvoiceLines = new ArrayList<>();
        }
        return getinvoiceLines;
    }

    public void setGetinvoiceLines(ArrayList<InvoiceLineSIG> getinvoiceLines) {
        this.getinvoiceLines = getinvoiceLines;
    }

    public InvoiceHeaderSIG(int invoiceNumber, String CustomerName, String invoiceDate, double invTotal) {
        System.out.println("Number : " + invoiceNumber + "Name : " + CustomerName + "Number : " + invoiceDate  +" Inv Total" + Total);
        this.invoiceNumber = invoiceNumber;
           this.CustomerName = CustomerName;
            this.invoiceDate = invoiceDate;
          this.Total = invTotal;
    }


    public String getDate() {
        return invoiceDate;
    }

    public void setDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getinvoiceNumber() {
        return invoiceNumber;
    }

    public void setinvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public double getInvoiceTotal() {

        double totalSIG = 0;
        for (InvoiceLineSIG invoiceLines : getinvoiceLines()) {

            totalSIG += invoiceLines.getLineTotal();

        }

        return totalSIG;
    }

    @Override
    public String toString() {
        return "InvoiceHeaderSIG{" + "id=" + invoiceNumber + ", CustomerName=" + CustomerName + ", date=" + invoiceDate +  '}';

    }

    public ArrayList<InvoiceLineSIG> getinvoiceLines() {
        if (null == invoiceLines) {

            invoiceLines = new ArrayList<>();

        }

        return getinvoiceLines;
    }

    public Object getlineSIG() {
        return null;
    }

    Object getInvoiceLineSIG() {
        return null;
    }

    Object getDateFormat() {
        return null;
    }

    Object getDate(ArrayList<InvoiceHeaderSIG> InvDataSIG) {
        return null;
    }

    Object getheaderSIG() {
        return null;
    }

    Object getinvoiceDate() {
        return null;
    }

    Object getdf() {
        return null;
    }

    public Object getInvoiceLines() {
        return null;
    }

    public void setinvoiceLines(ArrayList<InvoiceLineSIG> invoiceLineSIGs) {
    }

    public Object getinvoiceLineSIGs() {
        return null;
    }

    private static class invoiceLines {

        public invoiceLines() {
        }

    }

 
}
