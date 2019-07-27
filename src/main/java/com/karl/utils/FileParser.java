package com.karl.utils;

import com.karl.model.Sequence;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class FileParser {

    public Sequence parseFile(File source) throws IOException {
        List<String> allLines = Files.readAllLines(source.toPath(), StandardCharsets.UTF_8);
        String name = allLines.get(0).substring(1).trim();
        allLines.remove(0);
        StringBuffer stringBuffer = new StringBuffer();
        allLines.forEach(stringBuffer::append);
        return new Sequence(name, stringBuffer.toString());
    }

}
