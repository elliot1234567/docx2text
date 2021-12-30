package com.docx2text;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.rendering.PDFRenderer;

public class Template {
    private File outputPath;
    private File PDF;

    public Template(File template, File output) {
        outputPath = output;
        PDF = template;
    }

    public boolean processTemplate() throws IOException {
        Constants.caseMapInit();                                                                // initialize caseMap in Constants.java
        Dictionary dictionary;                                                                  // create a new Dictionary object
        PDDocument workingPDF;                                                                  // declare workingPDF as PDDocument object
        workingPDF = PDDocument.load(PDF);                                                      // load PDF into workingPDF object
        dictionary = new Dictionary();                                                          // initialize dictionary
        int letter = 0;                                                                         // variable to iterate through letter array in Constants.java
        for (int i = 0; i < workingPDF.getNumberOfPages(); i++) {                               // loop through the number of pages in PDF
            PDPage page = workingPDF.getPage(i);                                                // copy of current page of workingPDF
            if (i == 0) {                                                                       // if the current page is index 0
                for (int j = 0; j < 6; j++) {                                                   // loop through letters on page (A-F)
                    for (int k = 0; k < 6; k++) {                                               // loop through letter iterations on page
                        if (k < 3) {                                                            // if the current letter is uppercase
                            PDDocument newDoc = new PDDocument();                               // create a new PDF
                            page.setCropBox(new PDRectangle(new BoundingBox(                    // crop the page
                                Constants.MIN_X_PG_1[k],                                        
                                Constants.MIN_Y_PG_1[j],                                             
                                Constants.MAX_X_PG_1[k],                                        
                                Constants.MAX_Y_PG_1[j]                                              
                            )));                                                                // close
                            newDoc.addPage(page);                                               // add page to newDoc
                            String filePath =
                                outputPath +                                               
                                "/" +
                                Constants.characterlist[letter] +
                                "_" +
                                Constants.caseMap.get(k) +
                                ".png";
                            File file = new File(filePath);
                            PDFRenderer renderer = new PDFRenderer(newDoc);
                            BufferedImage image = renderer.renderImage(0);
                            ImageIO.write(image, "PNG", file);
                            newDoc.close();                                                     // close newDoc
                            dictionary.populate(Constants.characterlist[letter], file);
                        } else {                                                                // if the current letter is not uppercase
                            PDDocument newDoc = new PDDocument();                               // create a new PDF
                            page.setCropBox(new PDRectangle(new BoundingBox(                    // crop the page
                                Constants.MIN_X_PG_1[k],                                        
                                Constants.MIN_Y_PG_1[j],                                             
                                Constants.MAX_X_PG_1[k],                                        
                                Constants.MAX_Y_PG_1[j]                                              
                            )));                                                                // close
                            newDoc.addPage(page);                                               // add page to newDoc
                            String filePath =
                                outputPath +
                                "/" +
                                Constants.characterlist[letter] +
                                "_" +
                                Constants.caseMap.get(k) +
                                ".png";
                            File file = new File(filePath);
                            PDFRenderer renderer = new PDFRenderer(newDoc);
                            BufferedImage image = renderer.renderImage(0);
                            ImageIO.write(image, "PNG", file);
                            newDoc.close();                                                     // close newDoc
                            dictionary.populate(Constants.characterlist[letter], file);
                        }
                    }
                    letter++;                                                                   // increment letter
                }
            } else if (i == 9) {
                for (int j = 0; j < 6; j++) {                                                   // loop through letters on page
                    for (int k = 0; k < 6; k++) {                                               // loop through letter iterations on page
                        if (k < 3) {                                                            // if the current letter is uppercase
                            PDDocument newDoc = new PDDocument();                               // create a new PDF
                            page.setCropBox(new PDRectangle(new BoundingBox(                    // crop the page
                                Constants.MIN_X_PG_10[k],                                        
                                Constants.MIN_Y_PG_10[j],                                             
                                Constants.MAX_X_PG_10[k],                                        
                                Constants.MAX_Y_PG_10[j]                                              
                            )));                                                                // close
                            newDoc.addPage(page);                                               // add page to newDoc
                            String filePath =
                                outputPath +                                               
                                "/" +
                                Constants.characterlist[letter] +
                                "_" +
                                Constants.caseMap.get(k) +
                                ".png";
                            File file = new File(filePath);
                            PDFRenderer renderer = new PDFRenderer(newDoc);
                            BufferedImage image = renderer.renderImage(0);
                            ImageIO.write(image, "PNG", file);
                            newDoc.close();                                                     // close newDoc
                            dictionary.populate(Constants.characterlist[letter], file);
                        } else {                                                                // if the current letter is not uppercase
                            PDDocument newDoc = new PDDocument();                               // create a new PDF
                            page.setCropBox(new PDRectangle(new BoundingBox(                    // crop the page
                                Constants.MIN_X_PG_10[k],                                        
                                Constants.MIN_Y_PG_10[j],                                             
                                Constants.MAX_X_PG_10[k],                                        
                                Constants.MAX_Y_PG_10[j]                                              
                            )));                                                                // close
                            newDoc.addPage(page);                                               // add page to newDoc
                            String filePath =
                                outputPath +
                                "/" +
                                Constants.characterlist[letter] +
                                "_" +
                                Constants.caseMap.get(k) +
                                ".png";
                            File file = new File(filePath);
                            PDFRenderer renderer = new PDFRenderer(newDoc);
                            BufferedImage image = renderer.renderImage(0);
                            ImageIO.write(image, "PNG", file);
                            newDoc.close();                                                     // close newDoc
                            dictionary.populate(Constants.characterlist[letter], file);
                        }
                    }
                    letter++;                                                                   // increment letter
                }
            } else {
                for (int j = 0; j < 7; j++) {                                                   // loop through letters on page
                    for (int k = 0; k < 6; k++) {                                               // loop through letter iterations on page
                        if (k < 3) {                                                            // if the current letter is uppercase
                            PDDocument newDoc = new PDDocument();                               // create a new PDF
                            page.setCropBox(new PDRectangle(new BoundingBox(                    // crop the page
                                Constants.MIN_X_PG_MID[k],                                        
                                Constants.MIN_Y_PG_MID[j],                                             
                                Constants.MAX_X_PG_MID[k],                                        
                                Constants.MAX_Y_PG_MID[j]                                              
                            )));                                                                // close
                            newDoc.addPage(page);                                               // add page to newDoc
                            String filePath =
                                outputPath +                                               
                                "/" +
                                Constants.characterlist[letter] +
                                "_" +
                                Constants.caseMap.get(k) +
                                ".png";
                            File file = new File(filePath);
                            PDFRenderer renderer = new PDFRenderer(newDoc);
                            BufferedImage image = renderer.renderImage(0);
                            ImageIO.write(image, "PNG", file);
                            newDoc.close();                                                     // close newDoc
                            dictionary.populate(Constants.characterlist[letter], file);
                        } else {                                                                // if the current letter is not uppercase
                            PDDocument newDoc = new PDDocument();                               // create a new PDF
                            page.setCropBox(new PDRectangle(new BoundingBox(                    // crop the page
                                Constants.MIN_X_PG_MID[k],                                        
                                Constants.MIN_Y_PG_MID[j],                                             
                                Constants.MAX_X_PG_MID[k],                                        
                                Constants.MAX_Y_PG_MID[j]                                              
                            )));                                                                // close
                            newDoc.addPage(page);                                               // add page to newDoc
                            String filePath =
                                outputPath +
                                "/" +
                                Constants.characterlist[letter] +
                                "_" +
                                Constants.caseMap.get(k) +
                                ".png";
                            File file = new File(filePath);
                            PDFRenderer renderer = new PDFRenderer(newDoc);
                            BufferedImage image = renderer.renderImage(0);
                            ImageIO.write(image, "PNG", file);
                            newDoc.close();                                                     // close newDoc
                            dictionary.populate(Constants.characterlist[letter], file);
                        }
                    }
                    letter++;                                                                   // increment letter
                }
            }
        }
        return true;
    }
}