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
    Template template;
    ImageProcessor imgProcessor;
    File templateFile;
    File outputDirectory;
    File processedOutputDirectory;

    public class OpenFile extends AbstractAction {
        JFileChooser fileChooser;
        File selectedFile;
        public OpenFile(String name) {
            super(name);
            fileChooser = new JFileChooser();
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
    JButton process;

    OpenFile openTemplate = new OpenFile("Template");
    OpenFile openDocx = new OpenFile("Docx");
    OpenDirectory setOutput = new OpenDirectory("Output Directory");
    OpenDirectory setProcessedOutput = new OpenDirectory("Processed Output Directory");

    Action processTemplate = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            templateFile = openTemplate.getFile();
            outputDirectory = setOutput.getDirectory();
            processedOutputDirectory = setProcessedOutput.getDirectory();

            template = new Template(templateFile, outputDirectory);
            try {
                template.processTemplate();
            } catch (IOException e1) {
                System.err.println("ERROR: UNABLE TO PROCESS FILE");
                e1.printStackTrace();
            }

            for (File file : outputDirectory.listFiles()) {
                try {
                    imgProcessor = new ImageProcessor(file);
                    imgProcessor.saveImage(imgProcessor.processImage(), processedOutputDirectory, FilenameUtils.getBaseName(file.toString()));
                } catch (IOException e1) {
                    System.err.println("ERROR: UNABLE TO PROCESS IMAGE");
                    e1.printStackTrace();
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
        process = new JButton(processTemplate);
        process.setText("Process");

        contentPane.add(templateButton);
        contentPane.add(docxButton);
        contentPane.add(outputDirectoryButton);
        contentPane.add(processedOutputDirectoryButton);
        contentPane.add(process);
    }
}