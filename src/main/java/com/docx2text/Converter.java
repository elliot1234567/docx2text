package com.docx2text;

import java.io.File;

public class Converter {
    private String text;
    private File currentPaper;
    private File collegeRuled;
    private File wideRuled;

    public Converter(String t, File cr){
        text = t;
        collegeRuled = cr;
        wideRuled = null;
    }

    public Converter(File wr, String t) {
        text = t;
        collegeRuled = null;
        wideRuled = wr;
    }

    public Converter(String t, File cr, File wr) {
        text = t;
        collegeRuled = cr;
        wideRuled = wr;
    }

    public String getText() {
        return text;
    }

    public void setText(String t) {
        text = t;
    }

    public File getPaper() {
        return currentPaper;
    }

    public void setPaperType(char c) {
        switch(c) {
            case 'w':
                currentPaper = wideRuled;
                break;
            case 'c':
                currentPaper = collegeRuled;
                break;
            default:
                System.err.print("ERROR: UNABLE TO OPEN FILE");
                break;
        }
    }
}