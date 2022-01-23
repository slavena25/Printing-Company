package com.NETB406;

import java.util.List;

public class PrintingHouse{
    private String ID;
    private List<Client> clients;
    private List<Employee> employees;
    private List<Publications> publicationsSold;
    private List<PrintingMachine> printingMachines;
    private List<PrintingMachine> printingMachineOccupied;
    private double percentageManagerincrease;
    public static int pubilcationsDiscount;
    public static double percentageDiscount;

    public PrintingHouse(String ID, List<Client> clients, List<Employee> employees, List<Publications> publicationsSold, List<PrintingMachine> printingMachines, double percentageManagerincrease) {
        this.ID = ID;
        this.clients = clients;
        this.employees = employees;
        this.publicationsSold = publicationsSold;
        this.printingMachines = printingMachines;
        this.printingMachineOccupied = printingMachineOccupied;
        this.percentageManagerincrease = percentageManagerincrease;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Publications> getPublicationsSold() {
        return publicationsSold;
    }

    public void setPublicationsSold(List<Publications> publicationsSold) {
        this.publicationsSold = publicationsSold;
    }

    public double getPercentageManagerincrease() {
        return percentageManagerincrease;
    }

    public void setPercentageManagerincrease(double percentageManagerincrease) {
        this.percentageManagerincrease = percentageManagerincrease;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public static int getPubilcationsDiscount() {
        return pubilcationsDiscount;
    }

    public static void setPubilcationsDiscount(int pubilcationsDiscount) {
        PrintingHouse.pubilcationsDiscount = pubilcationsDiscount;
    }

    public static double getPercentageDiscount() {
        return percentageDiscount;
    }

    public static void setPercentageDiscount(double percentageDiscount) {
        PrintingHouse.percentageDiscount = percentageDiscount;
    }

    public void AddPublications(Publications p){
        publicationsSold.add(p);
    }

    public double PaperExpenses(){
        double income = 0;
        for(Client c : clients){
            income += c.PricePaid();
        }
        return income;
    }

    public double PublicationsIncome(){
        double income = 0;
        for(Client c : clients){
            income += c.EndPrice();
        }
        return income;
    }

    public double Salaries(){
        double expenses = 0;
        boolean incomeReached = PublicationsIncome() > 150.63 ? true : false;
        for(Employee e : employees){
            expenses += e.RealSalary(incomeReached, percentageManagerincrease);
        }
        return expenses;
    }

    public double EndExpenses(){
        return Salaries() + PaperExpenses();
    }

    public double Profit(){
        return PublicationsIncome() - Salaries();
    }

    @Override
    public String toString() {
        return "PrintingHouse{" +
                "publicationsSold = " + publicationsSold + ", " +
                "income = " + PublicationsIncome() + ", " +
                "expenses = " + EndExpenses() + ", " +
                "profit = " + Profit() +
                '}';
    }
}
