import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class ImageProcessing {
    ImageResource makeGray(ImageResource inImage) {

        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

        for (Pixel pixel: outImage.pixels()) {

            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }

        return outImage;
    }
    ImageResource invert(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
            for(Pixel pixel: outImage.pixels()){
                Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
                pixel.setRed(255- inPixel.getRed());
                pixel.setGreen(255-inPixel.getGreen());
                pixel.setBlue(255-inPixel.getBlue());
            }
        return outImage;
    }
    public void selectAndConvertToGrayScale () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            gray.setFileName("gray-"+inImage.getFileName());
            gray.save();
            gray.draw();
        }
    }
    public void selectAndInvert(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = invert(inImage);
            gray.setFileName("invert-"+inImage.getFileName());
            gray.save();
            gray.draw();
        }
    }
    public static void main(String [] args){
        ImageProcessing o = new ImageProcessing();
        //o.selectAndConvertToGrayScale();
        o.selectAndInvert();
    }

}
