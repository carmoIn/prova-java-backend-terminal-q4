package com.company.DAO;

import com.company.model.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static List<Customer> customersSession = new ArrayList<>();

    public List<Customer> list() {
        return customersSession;
    }

    public Customer create(Customer customer) {
        if (customer != null) {
            customersSession.add(customer);
            this.writeLog(customer);
            return customer;
        }
        return null;
    }

    public void writeLog(Customer customer) {
        File logFile = new File("log.txt");
        if(!logFile.isFile()){
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(logFile);
            PrintWriter printWriter  = new PrintWriter(fileWriter);
            printWriter.println(customer);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
