package com.docx2text;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.commons.io.FilenameUtils;

public class GUI extends JFrame { 
    
    public class OpenFile extends AbstractAction {
        JFileChooser fileChooser;
        File selectedFile;
        String extension;
        public OpenFile(String name) {
            super(name);
            fileChooser = new JFileChooser();
            extension = "";
        }

        public OpenFile(String name, String ext) {
            super(name);
            fileChooser = new JFileChooser();
            extension = ext;
        }

        public File getFile() {
            return selectedFile;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            }
        }
    }

    public class OpenDirectory extends AbstractAction {
        JFileChooser fileChooser;
        File selectedDirectory;
        public OpenDirectory(String name) {
            super(name);
            fileChooser = new JFileChooser();
        }

        public File getDirectory() {
            return selectedDirectory;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedDirectory = fileChooser.getSelectedFile();
                System.out.println("Selected directory: " + selectedDirectory.getAbsolutePath());
            }
        }
    }

    JButton templateButton;
    JButton docxButton;
    JButton outputDirectoryButton;
    JButton processedOutputDirectoryButton;
    JButton createFontButton;

    Action openTemplate = new OpenFile("Template", "pdf");
    Action openDocx = new OpenFile("Docx", "docx");
    Action setOutput = new OpenDirectory("Output Directory");
    Action setProcessedOutput = new OpenDirectory("Processed Output Directory");
    Action createFont = new AbstractAction() {
        File outputDir = ((OpenDirectory) setOutput).getDirectory();
        File processedOutputDir = ((OpenDirectory) setProcessedOutput).getDirectory();
        File templateFile = ((OpenFile) openTemplate).getFile();
        Template template;
        ImageProcessor imgProcessor;

        @Override
        public void actionPerformed(ActionEvent e) {
            template = new Template(templateFile, outputDir);
            try {
                template.processTemplate();
            } catch (IOException e1) {
                System.out.println("ERROR: UNABLE TO OPEN FILE");
            }

            for (File file : outputDir.listFiles()) {
                try {
                    imgProcessor = new ImageProcessor(file);
                    imgProcessor.saveImage(imgProcessor.processImage(), processedOutputDir, FilenameUtils.removeExtension(file.toString()) + ".png");
                } catch (IOException exception) {
                    System.err.println("ERROR: UNABLE TO OPEN IMAGE");
                    exception.printStackTrace();
                    break;
                }
            }

        }
    };

    public GUI() {
        super("DOCX2TEXT");
        this.setBounds(0, 0, 500, 500);
        this.initFrame();
    }

    public void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        Container contentPane = this.getContentPane();

        templateButton = new JButton(openTemplate);
        docxButton = new JButton(openDocx);
        outputDirectoryButton = new JButton(setOutput);
        processedOutputDirectoryButton = new JButton(setProcessedOutput);
        createFontButton = new JButton(createFont);
        createFontButton.setText("Create Font");



        contentPane.add(templateButton);
        contentPane.add(docxButton);
        contentPane.add(outputDirectoryButton);
        contentPane.add(processedOutputDirectoryButton);
        contentPane.add(createFontButton);
    }
}