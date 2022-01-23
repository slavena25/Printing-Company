package com.NETB406;

public class PrintingThread implements Runnable {
    private Printing printing;
    private PrintingMachine printingMachine;

    public PrintingThread(Printing print, PrintingMachine pM) {
        this.printing = print;
        this.printingMachine = pM;
    }


    @Override //NumOfPages == pages that can be printed for a minute
    public void run() {
        for(int i = 0; i < this.printingMachine.getSheetsPerMinute(); i++) {
            if(!printing.finished){
                if(printing.getPublication().lastPrintedPage == printing.getNumOfPages()){
                    printing.finished = true;
                    return;
                }
                else
                {
                    try {
                        this.printingMachine.print(printing.getPublication());
                    } catch (NotEnoughPaperException e) {
                        e.printStackTrace();
                    }
                }
            }
            else{
                return;
            }
        }
    }

}
