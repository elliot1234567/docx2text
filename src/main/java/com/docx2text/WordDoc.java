package com.docx2text;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordDoc {
    private FileInputStream file;
    private XWPFDocument document;
    private XWPFWordExtractor extractor;
    
    public WordDoc(FileInputStream f) throws IOException {
        file = f;
        document = new XWPFDocument(file);
        extractor = new XWPFWordExtractor(document);
    }

    public void print() {
        System.out.println(extractor.getText());
    }
}