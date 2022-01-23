package com.NETB406;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Printing {
    private int NumOfPages;
    public List<PrintingMachine> printingMachines;
    public boolean finished = false;
    private Publications publication;

    public Printing(int numOfPages, ArrayList<PrintingMachine> printingMachines,Publications publication) {
        NumOfPages = numOfPages;
        this.printingMachines = printingMachines;
        this.publication = publication;
    }

    public int getNumOfPages() {
        return NumOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        NumOfPages = numOfPages;
    }

    public List<PrintingMachine> getPrintingMachines() {
        return printingMachines;
    }

    public void setPrintingMachines(List<PrintingMachine> printingMachines) {
        this.printingMachines = printingMachines;
    }

    public Publications getPublication() {
        return publication;
    }

    public void setPublication(Publications publication) {
        this.publication = publication;
    }

    public void printing() {
        int i = publication.lastPrintedPage;
        ExecutorService executor = Executors.newFixedThreadPool(printingMachines.size());
        while(i < NumOfPages ) {
            for (PrintingMachine pM : this.printingMachines) {
                if (!finished) {
                    Runnable thread = new Thread(new PrintingThread(this, pM));
                    executor.execute(thread);
                }
            }
            i=publication.lastPrintedPage;
        }
        executor.shutdown();
        System.out.println("Machine change");
    }

}
