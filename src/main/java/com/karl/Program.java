package com.karl;

import com.karl.service.Service;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

public class Program {

    public static void main(String[] args) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        if (args.length != 2) {
            throw new IllegalArgumentException("The program must have the folder's path as a parameter and the destination file");
        }
        Service service = new Service();
        service.generateCsv(args[0], args[1]);
    }



}
