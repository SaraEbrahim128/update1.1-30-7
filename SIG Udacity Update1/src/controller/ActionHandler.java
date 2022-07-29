package controller;

import SIG.JFrameView.SIGJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.InvoiceHeaderSIG;
import model.InvoiceLineSIG;

public class ActionHandler implements ActionListener, ListSelectionListener {

    private SIGJFrame FrameSIG;
    // we will create constractor to know the frame for sending the file data refrence of the frame 
    // private  InvHeaderTableSIG;
    private InvoiceHeaderSIG headerSIG;

    public ActionHandler(SIGJFrame FrameSIG) {
        this.FrameSIG = FrameSIG;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String actionCommand;
            actionCommand = e.getActionCommand();

            switch (actionCommand) {
                case "Load File":

                    // we will create func for each button to customize which button clicked ....
                    LoadFile();

                    break;

                case "Save File":
                    SaveFile();

                    break;

                case "Create New Invoice":
                    CreateNewInvoice();

                    break;

                case "Delete Invoice":
                    DeleteInvoice();

                    break;

                case "Save":
                    Save();

                    break;

                case "Cancel":
                    Cancel();

                    break;

            }
        } catch (IOException ex) {
            Logger.getLogger(ActionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // @Override
    //for ghandeling selection from first table to another
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("here is your Selected the Row ");

        System.out.println("Selected: ");

    }

    @SuppressWarnings("empty-statement")
    private void LoadFile() throws IOException {
        JFileChooser fcSIG = new JFileChooser();
        int resultSIG = fcSIG.showOpenDialog(FrameSIG);
        if (JFileChooser.APPROVE_OPTION == resultSIG) {
            File headerFile; // to catch the implemented file
            headerFile = fcSIG.getSelectedFile();
            //to read the selected file
            String headerStrPath = headerFile.getAbsolutePath();
            Path headerPath;
            headerPath = Paths.get(headerStrPath);
            List<String> headerLinesSIG = Files.lines((Path) headerPath).collect(Collectors.toList());
            ArrayList<InvoiceHeaderSIG> InvHeaderListSIG = new ArrayList<>();

//            for (int i = 0; i < headerLinesSIG.size(); i++) {
//                String headerLine = headerLinesSIG.get(i);
//                System.out.println("Header Line : "+headerLine);
//            }
            for (String headerLine : headerLinesSIG) {
                System.out.println("Header : " + headerLine);
                String[] PartsSIG = headerLine.split(",");

//                for (int i = 0; i < PartsSIG.length; i++) {
//                    System.out.println("array " + i + " " + PartsSIG[i]);
//                    System.out.println("Hello");
//                    int invoiceNumber = Integer.parseInt(PartsSIG[0]);
//                    String invoiceDate = PartsSIG[1];
//                    String invoiceName = PartsSIG[2];
//                    System.out.println("invoiceNumber : " + invoiceNumber + "invoiceDate : " + invoiceDate + "invoiceName : " + invoiceName);
//                    InvoiceHeaderSIG invHeaderSIG;
//                    invHeaderSIG = new InvoiceHeaderSIG(invoiceNumber, invoiceDate, invoiceName);
//                    System.out.println("==========> OMAR : " + invHeaderSIG);
//                    InvHeaderListSIG.add(invHeaderSIG);
//                    System.out.println("You selected Header Successfully ");
//                    System.out.println("---------------------------------->>--------");
//                }
                System.out.println("Hello");
                int invoiceNumber = Integer.parseInt(PartsSIG[0]);
                String invoiceDate = PartsSIG[1];
                String invoiceName = PartsSIG[2];
                System.out.println("invoiceNumber : " + invoiceNumber + "invoiceDate : " + invoiceDate + "invoiceName : " + invoiceName);
                InvoiceHeaderSIG invHeaderSIG;
                invHeaderSIG = new InvoiceHeaderSIG(invoiceNumber, invoiceDate, invoiceName);
                System.out.println("==========> OMAR : " + invHeaderSIG);
                InvHeaderListSIG.add(invHeaderSIG);
                System.out.println("You selected Header Successfully ");

                // for opening the dialog for lines
                FrameSIG.setInvoicesArrSIG(InvHeaderListSIG);
                ArrayList<InvoiceHeaderSIG> InvHeaderListSIG2 = FrameSIG.getInvoicesArrSIG();
                System.out.println("==========>" + InvHeaderListSIG2);
                
                int result;
                result = fcSIG.showOpenDialog(FrameSIG);
                if (JFileChooser.APPROVE_OPTION == result) {
                    System.out.println("Hello2");
                    String lineStrPath = fcSIG.getSelectedFile().getAbsolutePath();
                    Path linePath;
                    linePath = Paths.get(lineStrPath);
                    System.out.println("LinePtah : " + lineStrPath);
                    List<String> lineLines = Files.readAllLines(linePath);
                    ArrayList<InvoiceLineSIG> invoiceLines = new ArrayList<>();
                    for (String lineLine : lineLines) {
                        System.out.println("Line Extra : " +lineLine );
                    }
                    for (String lineLine : lineLines) {
                        System.out.println("Invoice lines Details");
                        String[] PartsSIG1 = lineLine.split(",");
                        int InvoiveNumber = Integer.parseInt(PartsSIG1[0]); // descripe item number
                        String itemName = PartsSIG1[1];  // descripe item name
                        int itemPrice = Integer.parseInt(PartsSIG1[2]);  // descripe item price     
                        int count = Integer.parseInt(PartsSIG1[3]);
                        System.out.println("invoice number is :" + InvoiveNumber + " item Name is : " + itemName + "item Price Is :" + itemPrice + " Count is : " + count);

                        InvoiceHeaderSIG inv = FrameSIG.getInvObject(InvoiveNumber);
                        InvoiceLineSIG line = new InvoiceLineSIG(itemName, itemPrice, count, inv);
                        inv.getGetinvoiceLines().add(line);

                    }

                }

            }

        }
    }

    private InvoiceHeaderSIG getInvoiceHeaderSIGBYId(int InvoiveNumber, ArrayList<InvoiceHeaderSIG> InvHeaderListSIG) {
        return null;
    }

    private void CreateNewInvoice() {
    }

    private void DeleteInvoice() {
    }

    private void Save() {
    }

    private void Cancel() {
    }

    private void SaveFile() {
    }
}

// we need to create method for searching in invoice header to collect the lines
//  private InvoiceHeaderSIG getInvoiceHeaderSIGBYId(ArrayList<InvoiceHeaderSIG> InvHeaderListSIG, int InvoiveNumber) {
//   for (InvoiceHeaderSIG invoiceSIG : InvHeaderListSIG) {
//       if ((invoiceSIG.getinvoiceNumber() == InvoiveNumber)) {
//         ArrayList<InvoiceLineSIG> invoiceLineSIGs = new ArrayList<>();
//        InvoiceHeaderSIG headerSIG = new InvoiceHeaderSIG();
//        headerSIG.setinvoiceNumber(1);
//      InvoiceLineSIG invoiceLineSIG = new InvoiceLineSIG(headerSIG);
//    invoiceLineSIGs.add(invoiceLineSIG);
//   invoiceSIG.setGetinvoiceLines(invoiceLineSIGs);
//    return invoiceSIG;
//    }
//  }

