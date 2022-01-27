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

public abstract class GeometricObject2 {
    private String color = "white";
    private boolean filled;

    /** A no-arg constructor */
    protected GeometricObject2() {
    }

    /** A protected overloaded constructor */
    protected GeometricObject2(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /** The accessor and mutator methods for color */
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    /** The accessor and mutator methods for filled */
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /** Abstract method findArea */
    public abstract double getArea();

    /** Abstract method getPerimeter */
    public abstract double getPerimeter();
}

