package com.NETB406;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class Main {

    public static void writeInFile(String outputFilename, PrintingHouse pH) {
        try(FileWriter out = new FileWriter(new File(outputFilename), true);) {
            if (pH != null) {
                out.append(pH.toString() + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
    }

    public static List<String> readInFile(String Filename) {
        List<String> listOfInvoices = new ArrayList<>();
        try (FileReader fr = new FileReader(new File(Filename))) {
            BufferedReader buff_r = new BufferedReader(fr);
            String line;
            while ((line = buff_r.readLine()) != null) {
                listOfInvoices.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfInvoices;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //publications
        Publications publication1 = new Publications(Type.Newspaper, "New York Times", 10, PaperType.Newspaper, SheetSize.A3);
        Publications publication2 = new Publications(Type.Poster, "Pop Art Gallery", 4, PaperType.Glossy, SheetSize.A1);
        Publications publication3 = new Publications(Type.Book, "FairyTales", 30, PaperType.Standard, SheetSize.A5);
        Publications publication4 = new Publications(Type.Newspaper, "Vogue", 15, PaperType.Newspaper, SheetSize.A3);
        Publications publication5 = new Publications(Type.Poster, "Salt Museum", 7, PaperType.Standard, SheetSize.A5);
        Publications publication6 = new Publications(Type.Book, "Riddles", 20, PaperType.Standard, SheetSize.A2);

        //list of publications for the first client
        List<Publications> pubs1 = new ArrayList<>();
        pubs1.add(publication1);
        pubs1.add(publication4);
        pubs1.add(publication6);

        //list of publications for the second client
        List<Publications> pubs2 = new ArrayList<>();
        pubs2.add(publication2);
        pubs2.add(publication5);

        //list of publications for the third client
        List<Publications> pubs3 = new ArrayList<>();
        pubs3.add(publication3);
        pubs3.add(publication2);

        //clients
	    Client client1 = new Client("Jonh", pubs1);
	    Client client2 = new Client("Marcy", pubs2);
	    Client client3 = new Client("Fiora", pubs3);

        //list of clients in the printing house
        List<Client> cl = new ArrayList<>();
        cl.add(client1);
        cl.add(client2);
        cl.add(client3);

        //employees at the printing house
        Employee employee1 = new Employee(EmployeeType.PrintingMachineOperators);
        Employee employee2 = new Employee(EmployeeType.Managers);

        //list of employees at the printing house
        List<Employee> em = new ArrayList<>();
        em.add(employee1);
        em.add(employee2);
        em.add(employee1);
        em.add(employee1);
        em.add(employee2);

        //printing machines the printing house uses
	    PrintingMachine printingMachine1 = new PrintingMachine(70, PrintMachineType.Colored,2, 80);
        PrintingMachine printingMachine2 = new PrintingMachine(50, PrintMachineType.Colored,6, 140);
        PrintingMachine printingMachine3 = new PrintingMachine(30, PrintMachineType.Colored,4, 90);
        PrintingMachine printingMachine4 = new PrintingMachine(20, PrintMachineType.Colored,8, 0);

        //list of the printing machines the printing house uses
        ArrayList<PrintingMachine> printingsmach = new ArrayList<>();
        printingsmach.add(printingMachine1);
        printingsmach.add(printingMachine2);
        printingsmach.add(printingMachine3);
        printingsmach.add(printingMachine4);

        //printing house creation
        System.out.println("What is the percentage the manager's salary will be increases with of the income is > 150?");
        int percent = sc.nextInt();

        System.out.println("How many publications do you need to buy to have a discount?");
        int publicationsBought = sc.nextInt();

        System.out.println("What is the discount percentage the client will get?");
        double clDiscount = sc.nextDouble();

        //an empty list that will be filled with all of the clients publications
        ArrayList<Publications> allPubications = new ArrayList<>();

        PrintingHouse printingHouse = new PrintingHouse("22", cl, em, allPubications, printingsmach, percent);
        printingHouse.setPubilcationsDiscount(publicationsBought);
        printingHouse.setPercentageDiscount(clDiscount);

        //filling the list with the publications
        for(int i = 0; i < printingHouse.getClients().size(); i++){
            for(int j = 0; j < printingHouse.getClients().get(i).getPublications().size(); j++){
                printingHouse.AddPublications(printingHouse.getClients().get(i).getPublications().get(j));
            }
        }

        for(Publications p : printingHouse.getPublicationsSold()){
            Printing printing = new Printing(p.getPages(), printingsmach, p);
            printing.printing();
        }

        writeInFile(printingHouse.getID(), printingHouse);
        List<String> PrintingHousesReadFromFile = new ArrayList<>(readInFile(printingHouse.getID()));
        System.out.println("Information from file: " + PrintingHousesReadFromFile);

    }
}
