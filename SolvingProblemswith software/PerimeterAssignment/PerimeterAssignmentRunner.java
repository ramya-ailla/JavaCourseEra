package Week1;

import edu.duke.*;
import java.io.File;
import java.util.ArrayList;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        ArrayList<Point> points = (ArrayList<Point>) s.getPoints();
        return points.size();
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double totalLength=getPerimeter(s);
        int no_of_sides = getNumPoints(s);
        return totalLength/no_of_sides;
        }

    public double getLargestSide(Shape s) {
        // Put code here
        double longestSide =0;
        Point prevPoint = s.getLastPoint();
        for(Point p:s.getPoints()){
            double sideLength = prevPoint.distance(p);
            if(sideLength>longestSide){
                longestSide=sideLength;
            }
            prevPoint=p;
        }
        return longestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = -9999;
        for(Point p: s.getPoints()){
            if(p.getX()>largestX){
                largestX=p.getX();
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter=-1;
        DirectoryResource dr = new DirectoryResource();
        for(File f :dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double p = getPerimeter(s);
            if(p>largestPerimeter){
                largestPerimeter=p;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;
        double largestPerimeter =0;
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape s = new Shape(file);
            double p = getPerimeter(s);
            if(p>largestPerimeter){
                largestPerimeter=p;
                temp = f;
               }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("no_of_points = " + getNumPoints(s));
        System.out.println("Average_Side_Length = " + getAverageLength(s));
        System.out.println("Largest_Side_length = " + getLargestSide(s));
        System.out.println("LargestX(abscissa) among all points is "+ getLargestX(s));
        System.out.println("Assignment 2");
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();

    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("Largest Perimeter = " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File name of Largest Perimeter is "+getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
       }
}
