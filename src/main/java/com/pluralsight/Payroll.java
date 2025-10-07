package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {
        String fileName = "";
        String outputtedFileName = "";

        try {
            Scanner payrollScanner = new Scanner(System.in);
            System.out.println("Please enter the name of the file you would like to input:");
            fileName = payrollScanner.nextLine();
            System.out.println("Please enter the name of the file you would like to create:");
            outputtedFileName = payrollScanner.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            FileWriter payrollFileWriter = new FileWriter(outputtedFileName);
            String line;
            String text;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                text = String.format("Employee ID: %d, Name: %s, Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

//                System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f%n",
//                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                payrollFileWriter.write(text);


            }
            reader.close();
            payrollFileWriter.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + fileName);
        }
    }
}