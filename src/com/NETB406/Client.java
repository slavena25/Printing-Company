package com.NETB406;

import java.util.List;

public class Client {
    private String name;
    private List<Publications> publications;
    private PrintingHouse ph;

    public Client(String name, List<Publications> publications) {
        this.name = name;
        this.publications = publications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Publications> getPublications() {
        return publications;
    }

    public void setPublications(List<Publications> publications) {
        this.publications = publications;
    }

    public void addPublication(Publications p){
        this.publications.add(p);
    }

    public double PricePaid(){
        double price = 0;
        for(Publications p : publications){
            price += p.PublicationPrices();
        }

        return price;
    }

    public double EndPrice(){
        double endprice = PricePaid();
        boolean IsDiscount = publications.size() >= PrintingHouse.pubilcationsDiscount ? true : false;
        if(IsDiscount){
            return endprice - (endprice * (PrintingHouse.percentageDiscount * 0.01));
        }
        else{
            return endprice;
        }

    }

    public void OrderPublication(Publications p){
        ph.printPublication(p);

    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", publications=" + publications +
                ", ph=" + ph +
                '}';
    }
}
