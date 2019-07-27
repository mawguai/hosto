package com.karl.service;

import com.karl.model.Sequence;
import com.karl.utils.FileParser;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Service {

    private FileParser fileParser = new FileParser();

    public void generateCsv(String srcPath, String destPath) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        File directory = new File(srcPath);
        String[] extensions = {"fas", "fasta"};
        Collection<File> files = FileUtils.listFiles(directory, extensions, true);

        Writer writer = Files.newBufferedWriter(Paths.get(destPath));

        StatefulBeanToCsv<Sequence> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        List<Sequence> sequences = new ArrayList<>();

        files.forEach(file -> {
            try {
                Sequence sequence = fileParser.parseFile(file);
                sequences.add(sequence);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        beanToCsv.write(sequences);
    }

}
