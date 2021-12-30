package com.docx2text;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProcessor {
    private File image;
    private BufferedImage img;

    public ImageProcessor(File i) throws IOException {
        image = i;
        img = ImageIO.read(image);
    }

    public void setImage(File i) throws IOException {
        image = i;
        img = ImageIO.read(image);
    }

    public File getImage() {
        return image;
    }

    public void saveImage(BufferedImage i, File processedOutputDir, String name) throws IOException {
        ImageIO.write(i, "png", new File(processedOutputDir + "\\" + name + ".png"));
    }

    public BufferedImage processImage() throws IOException {
        BufferedImage buffImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int pixel = img.getRGB(i, j);

                //get alpha
                int a = (pixel>>24) & 0xff;

                //get red
                int r = (pixel>>16) & 0xff;

                //get green
                int g = (pixel>>8) & 0xff;

                //get blue
                int b = pixel & 0xff;     
                
                if (r < 255 && g < 255 && b < 255) {
                    int mc = (a << 24) | 0x00ffffff;
                    int newcolor = pixel & mc;
                    buffImage.setRGB(i, j, newcolor); 
                }
            }
        }
        return buffImage;
    }
}