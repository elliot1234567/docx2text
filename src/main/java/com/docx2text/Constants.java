package com.docx2text;

import java.io.File;
import java.util.HashMap;

public class Constants {

    // page 1 bounding box constants
    public static final int[] MIN_X_PG_1 = {149, 220, 291, 362, 435, 506};
    public static final int[] MAX_X_PG_1 = {218, 290, 361, 432, 500, 575};
    public static final int[] MIN_Y_PG_1 = {544, 457, 370, 283, 196, 109};
    public static final int[] MAX_Y_PG_1 = {631, 542, 453, 365, 277, 187};

    // page 10 bounding box constants
    public static final int[] MIN_X_PG_10 = {149, 220, 291, 362, 435, 506};
    public static final int[] MAX_X_PG_10 = {218, 290, 361, 432, 500, 575};
    public static final int[] MIN_Y_PG_10 = {631, 544, 457, 370, 283, 196};
    public static final int[] MAX_Y_PG_10 = {718, 631, 542, 453, 365, 277};


    // middle pages bounding box constants
    public static final int[] MIN_X_PG_MID = {149, 220, 291, 362, 435, 506};
    public static final int[] MAX_X_PG_MID = {218, 290, 361, 432, 500, 575};
    public static final int[] MIN_Y_PG_MID = {631, 544, 457, 370, 283, 196, 109};
    public static final int[] MAX_Y_PG_MID = {718, 631, 542, 453, 365, 277, 187};


    public static HashMap<Integer, String> caseMap = new HashMap<Integer, String>();

    public static void caseMapInit() {
        caseMap.put(0, "UN");
        caseMap.put(1, "UM");
        caseMap.put(2, "US");
        caseMap.put(3, "LN");
        caseMap.put(4, "LM");
        caseMap.put(5, "LS");
    }

    // paper constants
    public static final int habitableStart = 0; // distance from left edge to left red line
    public static final int habitableEnd = 0; // distance from left edge to right red line

    public static final File wide = new File(
        "C:\\Users\\Gandagorn\\Desktop\\Work\\Code\\Practice\\Java\\docx2text\\Materials\\wideruled.png");
    public static final double wideScalingFactor = 0;
    public static final int wideLineCount = 0; // number of lines
    public static final int wideLineHeight = 0; // height of each line
    
    public static final File college = new File(
        "C:\\Users\\Gandagorn\\Desktop\\Work\\Code\\Practice\\Java\\docx2text\\Materials\\collegeruled.png");
    public static final double collegeScalingFactor = 0;
    public static final int collegeLineCount = 0;
    public static final int collegeLineHeight = 0;


    public static String[] characterlist = {
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
        "M",
        "N",
        "O",
        "P",
        "Q",
        "R",
        "S",
        "T",
        "U",
        "V",
        "W",
        "X",
        "Y",
        "Z",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "0",
        "exclamationpoint",
        "at",
        "hashtag",
        "dollar",
        "percentage",
        "carrot",
        "and",
        "star",
        "openparenthesis",
        "closeparenthesis",
        "backquote",
        "tilde",
        "subtraction",
        "underscore",
        "equals",
        "addition",
        "openbracket",
        "closebracket",
        "opencurlybrace",
        "closecurlybrace",
        "backslash",
        "pipe",
        "semicolon",
        "colon",
        "doublequotes",
        "singlequotes",
        "comma",
        "period",
        "lessthan",
        "greaterthan",
        "questionmark",
        "forwardslash",
    };
}