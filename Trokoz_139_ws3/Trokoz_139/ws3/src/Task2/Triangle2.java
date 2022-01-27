/**********************************************
 Workshop # 3
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    21-02-2021
 **********************************************/

package Task2;

class Triangle2 extends GeometricObject2 {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    /** A no-arg constructor that creates a default triangle */
    public Triangle2() { }

    public Triangle2(double side1, double side2, double side3) throws TriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        isValidTriangle();
    }

    private void isValidTriangle() throws TriangleException{
        if (!isTriangle(side1, side2, side3)) {
            throw new TriangleException(side1, side2, side3);
        }
    }

    /** The accessor methods for all three data fields */
    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side2;
    }
    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) throws TriangleException {
        this.side1 = side1;
        isValidTriangle();
    }

    public void setSide2(double side2) throws TriangleException{
        this.side2 = side2;
        isValidTriangle();
    }

    public void setSide3(double side3) throws TriangleException {
        this.side3 = side3;
        isValidTriangle();
    }

    @Override
    public String toString() {
        return "Triangle { " + "side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3 + " }";
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2.0;
        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
    }

    /** Check if size sides follow triangle`s rule or not */
    public static boolean isTriangle(double side1, double side2, double side3) {
        return  ((side1 + side2 > side3) &&
                (side1 + side3 > side2) &&
                (side3 + side2 > side1));
    }

    /** Triangle exception */
    public class TriangleException extends Exception {
        private double s1;
        private double s2;
        private double s3;
        public TriangleException(double s1, double s2, double s3) {
            super("Not a real triangle:" + " side1 = " + s1 + " side2 = " + s2 + " side3 = " + s3);
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }
        public double getS1() {
            return s1;
        }
        public double getS2() {
            return s2;
        }
        public double getS3() {
            return s3;
        }
    }
}

