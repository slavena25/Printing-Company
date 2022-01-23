package com.NETB406;

public class PrintingMachine {
     private int MaxNumbSheets;
     private PrintMachineType printType;
     private int SheetsPerMinute;
     private int LoadedSheets;
     private Thread thread;
     private static int currentMachineWorking = 0;
     private int MachineId;

    public PrintingMachine(int maxNumbSheets, PrintMachineType printType, int sheetsPerMinute, int loadedSheets) {
        MaxNumbSheets = maxNumbSheets;
        this.printType = printType;
        SheetsPerMinute = sheetsPerMinute;
        LoadedSheets = loadedSheets;

        currentMachineWorking++;
        this.MachineId = currentMachineWorking;

        //thread = new Thread("PrintingMachineID" + this.MachineId);
        //thread.start();
    }

    public String getMachineId() {
        return this.thread.getName();
    }

    public int getMaxNumbSheets() {
        return MaxNumbSheets;
    }

    public void setMaxNumbSheets(int maxNumbSheets) {
        MaxNumbSheets = maxNumbSheets;
    }

    public PrintMachineType getPrintType() {
        return printType;
    }

    public void setPrintType(PrintMachineType printType) {
        this.printType = printType;
    }

    public int getSheetsPerMinute() {
        return SheetsPerMinute;
    }

    public void setSheetsPerMinute(int sheetsPerMinute) {
        SheetsPerMinute = sheetsPerMinute;
    }

    public int getLoadedSheets() {
        return LoadedSheets;
    }

    public void setLoadedSheets(int loadedSheets) {
        LoadedSheets = loadedSheets;
    }


    public void print(Publications p) throws NotEnoughPaperException {
        if(LoadedSheets > 0){
            p.incrementLastPage();
            System.out.println(this.getMachineId() + " Page: " + p.lastPrintedPage + " " + p.getTitle());
            LoadedSheets--;
        }
        else{
            throw new NotEnoughPaperException();
        }

    }
}
