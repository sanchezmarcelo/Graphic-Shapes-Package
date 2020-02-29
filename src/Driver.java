import java.awt.Color;
import java.awt.event.MouseEvent;

import csci338.drawings.SimpleDrawing;
/*
 * @Author: Marcelo Sanchez
 * @Version: 2/25/19
 */
public class Driver extends SimpleDrawing{
	/*
	 * Create the 800 x 800 window
	 */
	static SimpleDrawing windowOne = new SimpleDrawing(800, 800);
	
	public static void main(String[] args) {
		/*
		 * Set the foreground & background colors
		 * Set the background black and the 
		 * shape color to white
		 */
		windowOne.setBackgroundColor(Color.black);
		windowOne.setForegroundColor(Color.white);
		
		int recOneLength = 200;
		
		/*
		 * Create various shapes: rectangles, parallelograms, diamonds,
		 * circles, arrows, lines, and squares 
		 */
		
		drawRectangle(windowOne, 20, 40, recOneLength);
		drawRectangle(windowOne, 40, 220, 200);
		drawRectangle(windowOne, 360, 160, recOneLength);
		drawRectangle(windowOne, 420, 500, recOneLength);
		
		drawCircle(windowOne, 12, 325, 345);
		drawCircle(windowOne, 12, 275, 345);
		drawCircle(windowOne, 12, 325, 395);
		drawCircle(windowOne, 12, 275, 395);
		
		drawParallelogram(windowOne, 80, 460);
		drawParallelogram(windowOne, 125, 510);
		drawParallelogram(windowOne, 170, 560);
		
			drawDiamond(windowOne, 300, 340);
			
			drawUpwardsTriangle(windowOne, 300, 200);
			
			drawDownwardsTriangle(windowOne, 300, 540);
			
		connectTwoPoints(windowOne, 80, 140, 80, 220);
		
		connectTwoPointsDotted(windowOne, 80, 200, 300, 200);
		connectTwoPointsDashed(windowOne, 480, 260, 480, 500);
			
			connectTwoPoints(windowOne, 300, 230, 300, 340);
			connectTwoPoints(windowOne, 300, 400, 300, 510);
			
				connectTwoPointsDotted(windowOne, 120, 370, 280, 370);
				
				drawLeftArrow(windowOne, 120, 370);
				
				connectTwoPoints(windowOne, 320, 370, 480, 370);
				
				drawRightArrow(windowOne, 480, 370);
				
				drawRectangleNew(windowOne, 250, 120, 50, 50);
	}
	
	 /*
	  * Function takes in current window, x & y coordinate to begin drawing position,
	  * and length
	  */
	public static void drawRectangle(SimpleDrawing window, int x, int y, int l) {
		int length = l + x;
		//width is currently static
		//fixed with function below called drawRectangleNew()
		int width = 100;
		
		//Draw the length of the rectangle
		for(int i = x; i < length; i++) {
			/*
			 * ShowPoint() displays a singular point at given x & y coordinate
			 */
			window.showPoint(i, y);
			window.showPoint(i, y + width);
		}
		//Draw the width of the rectangle
		for(int i = 0; i < width; i++) {
			window.showPoint(x, i + y);
			window.showPoint(length, i + y);
		}
	}
	
	/*
	 * Function is successor of drawRectangle
	 * Allows for dynamic width & height
	 */
	public static void drawRectangleNew(SimpleDrawing window, int startX, int startY, int length, int width) {
		connectTwoPoints(window, startX, startY, startX + length, startY);
		connectTwoPoints(window, startX + length, startY, startX + length, startY + width);
		connectTwoPoints(window, startX + length, startY + width, startX, startY + width);
		connectTwoPoints(window, startX, startY + width, startX, startY);
	}
	
	/*
	 * Function takes in the radius and coordinates for a circle
	 */
	public static void drawCircle(SimpleDrawing window, int radius, int x, int y) {
		/*
		 * Simple loop to display all points in the 360 degree circle
		 */
	        for(int i = 0; i < 360; i++){
	            int px = (int) (radius*(Math.cos(i)));
	            int py = (int) (radius*(Math.sin(i)));
	            window.showPoint(px + x, py + y);
	            
	        }
	}
	
	/*
	 * Function makes use of previous connectTwoPoints() to
	 * create upwards arrow
	 */
	public static void drawUpArrow(SimpleDrawing window, int startX, int startY) {
		connectTwoPoints(window, startX - 20, startY + 30, startX, startY);
		connectTwoPoints(window, startX + 20, startY + 30, startX, startY);
	}
	
	/*
	 * Function makes use of previous connectTwoPoints() to
	 * create right arrow
	 */
	public static void drawRightArrow(SimpleDrawing window, int startX, int startY) {
		connectTwoPoints(window, startX - 30, startY - 20, startX, startY);
		connectTwoPoints(window, startX, startY, startX -30, startY + 20);
	}
	
	/*
	 * Function makes use of previous connectTwoPoints() to
	 * create down arrow
	 */
	public static void drawDownArrow(SimpleDrawing window, int startX, int startY) {
		connectTwoPoints(window, startX - 20, startY - 30, startX, startY);
		connectTwoPoints(window, startX + 20, startY - 30, startX, startY);
	}
	
	/*
	 * Function makes use of previous connectTwoPoints() to
	 * create left arrow
	 */
	public static void drawLeftArrow(SimpleDrawing window, int startX, int startY) {
		connectTwoPoints(window, startX, startY, startX + 30, startY - 20);
		connectTwoPoints(window, startX, startY, startX + 30, startY + 20);
	}
	
	/*
	 * Function makes use of previous connectTwoPoints() & drawUpArrow()
	 * to create right arrow
	 */
	public static void drawUpwardsTriangle(SimpleDrawing window, int startX, int startY) {
		drawUpArrow(window, startX, startY);
		connectTwoPoints(window, startX - 20, startY + 30, startX + 20, startY + 30);
	}
	/*
	 * Function makes use of previous connectTwoPoints() & drawUpArrow()
	 * to create right arrow
	 */
	public static void drawDownwardsTriangle(SimpleDrawing window, int startX, int startY) {
		drawDownArrow(window, startX, startY);
		connectTwoPoints(window, startX - 20, startY - 30, startX + 20, startY - 30);
	}
	
	/*
	 * Function uses a parametric equation to connect two coordinates together
	 */
	public static void connectTwoPoints(SimpleDrawing window, int x0, int y0, int x1, int y1) {
		for(double i = 0; i < 1; i+=0.01) {
			window.showPoint((int) (x0 + i*(x1 - x0)), (int) (y0 + i * (y1 - y0)));
		}
	}
	/*
	 * Function uses a parametric equation to connect two coordinates together
	 */
	public static void connectTwoPointsDotted(SimpleDrawing window, int x0, int y0, int x1, int y1) {
		//var i is adjusted in order for doted line effect
		for(double i = 0; i < 1; i+=0.06) {
			window.showPoint((int) (x0 + i*(x1 - x0)), (int) (y0 + i * (y1 - y0)));
		}
	}
	
	/*
	 * Function uses a parametric equation to connect two coordinates together
	 */
	public static void connectTwoPointsDashed(SimpleDrawing window, int x0, int y0, int x1, int y1) {
		//var i is adjusted in order for dashed line effect
		for(double i = 0; i < 1; i+=0.02) {
			window.showPoint((int) (x0 + i*(x1 - x0)), (int) (y0 + i * (y1 - y0)));
		}
	}
	
	/*
	 * Function makes use of drawUpArrow() & drawDownArrow to create a diamond shape
	 */
	public static void drawDiamond(SimpleDrawing window, int startX, int startY) {
		drawUpArrow(window, startX, startY);
		drawDownArrow(window, startX, startY + 60);
	}
	/*
	 * Function makes use of connectTwoPoints() to create a parallelogram
	 * Some static variables are used to ensure the sides of the parallelogram
	 * connect
	 */
	public static void drawParallelogram(SimpleDrawing window, int startX, int startY) {
		connectTwoPoints(window, startX, startY, startX -40, startY - 40);
		connectTwoPoints(window, startX + 80, startY, startX + 40,  startY - 40);
		connectTwoPoints(window, startX, startY, startX + 80, startY);
		connectTwoPoints(window, startX - 40, startY - 40, startX + 40, startY - 40);
	}
}
