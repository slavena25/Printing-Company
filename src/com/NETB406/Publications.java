package com.NETB406;

import java.util.List;

public class Publications {
    private Type type;
    private String title;
    private int pages;
    private PaperType papertype;
    private SheetSize sheetsize;
    public int lastPrintedPage;

    public Publications(Type type, String title, int pages, PaperType papertype, SheetSize sheetsize) {
        this.type = type;
        this.title = title;
        this.pages = pages;
        this.papertype = papertype;
        this.sheetsize = sheetsize;
        lastPrintedPage = 0;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public SheetSize getSheetsize() {
        return sheetsize;
    }

    public void setSheetsize(SheetSize sheetsize) {
        this.sheetsize = sheetsize;
    }

    public double PricePerSheet(SheetSize size, PaperType papertype){
        double SheetPrice = 0;
        switch(size){
            case A1:
                SheetPrice += 2.10;
                break;
            case A2:
                SheetPrice += 2;
                break;
            case A3:
                SheetPrice += 1.85;
                break;
            case A4:
                SheetPrice += 1.65;
                break;
            case A5:
                SheetPrice += 1.50;
                break;
        }

        switch (papertype){
            case Glossy:
                SheetPrice += 1.20;
                break;
            case Standard:
                SheetPrice += 0.95;
                break;
            case Newspaper:
                SheetPrice += 0.45;
                break;
        }

        return SheetPrice;
    }

    public double PublicationPrices(){
        return pages * PricePerSheet(sheetsize, papertype);
    }

    @Override
    public String toString() {
        return "Publications{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", sheetsize=" + sheetsize +
                '}';
    }

    public synchronized void incrementLastPage(){
        this.lastPrintedPage++;
    }
}
