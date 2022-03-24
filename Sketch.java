import processing.core.PApplet;

public class Sketch extends PApplet {
	
  /**
  * A program Sketch.java that uses loops to produce the following graphics: 
  * Quadrant 1 is a 10 x 10 grid that scales to with the size of window. 
  * Quadrant 2 is 5 x grid of evenly spaced circles that scales to the size of the window. 
  * Quadrant 3 is a horizontal grayscale gradient. 
  * Quadrant 4 is a 8 petal flower that uses a loop to draw the petals
  * evenly spaced around the center of the flower.
  * @author: D. Gu
  */
  
  public void settings() {
    // Size of the call
    size(350, 350);
  }
  
  public void setup() {
    background(210, 255, 173);
  }

  public void draw() {
    /**
    * Create 2 lines across the middle of the grid to form 4 quadrants
    */
    strokeWeight(1);
    stroke(0, 0, 0);
    line((float)(width / 2), 0, (float)(width / 2), height);
    line(0, (float)(height / 2), width, (float)(height / 2));
	  
    /** 
    * Create a 10 by 10 grid that scales with the size of
    * the window in the upper left quadrant
    */
    
    // Draw 10 vertical Lines
    for (float fltLineX = 0; fltLineX <= ((float)width / 2); fltLineX+= ((float)width / 20)){
       line(fltLineX, 0, fltLineX, ((float)height / 2));
    }
    
    // Draw 10 horizontal lines
    for (float fltLineY = 0; fltLineY <= ((float)height / 2); fltLineY+= ((float)height / 20)){
       line(0, fltLineY, ((float)width / 2), fltLineY);
    }
    
    /**
    * Create a 5x5 grid of evenly spaced circles in the 
    * upper right quadrant that scales with the window size
    */
    
    // Create variables for distance from side
    float fltDistanceX = width / 12;
    float fltDistanceY = height / 12;
    
    // Use nested loop to draw circles
    for (float fltCircleX = width - fltDistanceX; fltCircleX >= (float)(width / 2) + fltDistanceX; fltCircleX -=
(float)(width / 12)){
      for (float fltCircleY = 0 + fltDistanceY; fltCircleY <= (float)(height / 2) - fltDistanceY; fltCircleY += (float)(height / 12)){
        fill(123,324,322);
        ellipse(fltCircleX, fltCircleY, (float)(width / 20), (float)(height / 20));
      }
    }
    
    /** 
    * Turn the bottom left quadrant into a horizontal grayscale gradient
    */
    for (int intGray = 51; intGray <= (width / 2 + 50); intGray++){
      stroke(intGray, intGray, intGray);
      line(intGray - 51, (height / 2 + 1), intGray - 51, height);
    }
    
    /** 
    * Draw an 8 petal flower in the bottom right quadrant, with the 
    * petals evenly spaced around the center of the flower
    */
    fill(123, 232, 102);
    translate((float)(3 * width / 4), (float)(3 * height / 4));
    for (int intPetal = 0; intPetal < 8; intPetal++){
      
      // Draw 8 petals 
      strokeWeight((width + height) / 40);
      stroke(204, 102, 0);
      rotate(TWO_PI/8);
      
      // If statement to make sure the petals don't extend out of the quadrant
      if (height>width){
        line(0,0,(float)(width / 5), 0);
      }
      else {
        line(0,0,(float)(height / 5), 0);
      }
    }
    
    // Draw central circle after petals to avoid overlap
    strokeWeight(1);
    ellipse(0, 0, (float)(width / 10), (float) (height / 10));
  }
  
}