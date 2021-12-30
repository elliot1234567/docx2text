package com.docx2text;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class GUI extends JFrame { 
    Template template;
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

    Action openTemplate = new OpenFile("Template");
    Action openDocx = new OpenFile("Docx");
    Action setOutput = new OpenDirectory("Output Directory");
    Action setProcessedOutput = new OpenDirectory("Processed Output Directory");

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

        contentPane.add(templateButton);
        contentPane.add(docxButton);
        contentPane.add(outputDirectoryButton);
        contentPane.add(processedOutputDirectoryButton);
    }
}