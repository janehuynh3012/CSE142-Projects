// This program draws different versions of a particular subfigure on the screen.
// This version is structured so that main calls 2 rows and 4 grids to draw the subfigures.

import java.awt.*;

public class CafeWall {
   public final static int MORTAR_SIZE = 2; // change this to scale the separation for the mortar

   public static void main(String args[]) {
     DrawingPanel panel = new DrawingPanel(650, 400);
     Graphics g = panel.getGraphics();
     panel.setBackground(Color.GRAY);
     drawRow(g, 0, 0, 4, 20); // upper-left row
     drawRow(g, 50, 70, 5, 30); // mid-left row
     drawGrid(g, 10, 150, 8, 0, 4, 25); // lower-left grid
     drawGrid(g, 250, 200, 6, 10, 3, 25); // lower-middle grid
     drawGrid(g, 425, 180, 10, 10, 5, 20); // lower-right grid
     drawGrid(g, 400, 20, 4, 35, 2, 35); // lower-right grid
   }

   /**
      draws a grid with upper-left of (x, y)
         @param rows is the number of rows the grid contains
         @param offset is offset between 2 consecutive rows for ziczag effect
         @param pairs is number of pairs of black and white boxes
         @param size is size of each box
   **/
   public static void drawGrid(Graphics g, int x, int y, int rows, int offset, int pairs, int size) {
      for(int r = 0; r < rows; r++) {
         int rowStartY = y + r * (size + MORTAR_SIZE);
         int rowStartX = x + (r % 2) * offset;
         drawRow(g, rowStartX, rowStartY,pairs, size); 
      }
   }

   /**
      draws a row with upper-left of (x, y)
         @param pairs is the number of pairs the row contains
         @param size is size of each box
   **/ 
   public static void drawRow(Graphics g, int x, int y, int pairs, int size) {
      int rowWidth = pairs * size * 2;
      Color currentColor = g.getColor(); 
      
      // draws the white rectangle
      g.setColor(Color.WHITE); 
      g.fillRect(x, y, rowWidth, size);
  
      // draws the black rectangle
      for(int i = 0; i < pairs; i++) {
         int blackRectX = x + i * 2 * size;
         g.setColor(Color.BLACK); 
         g.fillRect(blackRectX, y, size, size);
         g.setColor(Color.BLUE);
         g.drawLine(blackRectX, y, blackRectX + size, y + size);
         g.drawLine(blackRectX + size, y, blackRectX, y + size);
      }
      g.setColor(currentColor); 
   }
}
