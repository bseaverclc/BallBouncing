// Example 6.4: A filled circle moves back and forth
// across the panel, appearing to bounce off its edges

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPanel extends JPanel{

   private Circle circle;
   private javax.swing.Timer timer;
	
   public ColorPanel(Color backColor, int width, int height){
      setBackground(backColor);
      setPreferredSize(new Dimension(width, height));
      // Circle with center point (25, 100) and radius 25
      circle = new Circle(25, height / 2, 25, Color.red);
      circle.setFilled(true);
      // Aim due west to hit left boundary first
      circle.setDirection(180);
      // Move 5 pixels per unit of time
      circle.setVelocity(5);
      // Move every 5 milliseconds 
      timer = new javax.swing.Timer(5, new MoveListener());
      timer.start();
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      circle.fill(g);      
   }

   private class MoveListener implements ActionListener{

      public void actionPerformed(ActionEvent e){
         int x = circle.getX();
         int radius = circle.getRadius();
         int width = getWidth();
         // Check for boundaries and reverse direction
         // if necessary
         if (x - radius <= 0 || x + radius >= width)
            circle.turn(180);
         circle.move();
         repaint();
      }
   }
}