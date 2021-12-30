package com.docx2text;

import java.io.File;
import java.util.HashMap;

public class Dictionary {
    HashMap<String, File> dictionary;

    public Dictionary() {
        dictionary = new HashMap<String, File>();
    }

    public void populate(String characterlist, File file) {
        dictionary.put(characterlist, file);
    }

    public File getValue(String key) {
        return dictionary.get(key);
    }
}