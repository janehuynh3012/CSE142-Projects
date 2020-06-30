// Anh Kim Huynh
// 4/21/20
// CSE142
// TA: Harshal V Desai
// Assignment #3: Doodle

// This program produces as output a subfigure of two UFOs facing sunshine
// on a drawing panel with pixel 100, 100.

import java.awt.*;

public class Doodle {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(100, 100);
      Color c = new Color(204, 255, 255);
      panel.setBackground(c);
      Graphics g = panel.getGraphics();
         
      // draws the sunshine 
      g.setColor(Color.ORANGE);
      g.fillArc(0, 5, 25, 25, 220, 220);
      
      // draws the sun beams
      g.setColor(Color.ORANGE);
      g.drawLine(30, 10, 45, 12);
      g.drawLine(29, 20, 42, 25);
      g.drawLine(24, 30, 36, 39);
      g.drawLine(15, 35, 25, 46);
      
      // draws the pink UFO at the lower-left
      Color pink = new Color(255, 128, 128);
      g.setColor(pink);
      g.fillOval(20, 70, 30, 25);
      g.setColor(Color.PINK);
      g.fillOval(10, 70, 50, 20);
      g.setColor(pink);
      g.fillOval(20, 65, 30, 15);
      
      // draws the green UFO at the upper-right
      Color green = new Color(153, 204, 0);
      g.setColor(green);
      g.fillOval(55, 25, 30, 25);
      g.setColor(Color.GREEN);
      g.fillOval(45, 25, 50, 20);
      g.setColor(green);
      g.fillOval(55, 20, 30, 15);
   }
}