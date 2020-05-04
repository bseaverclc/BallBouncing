// Represents a circle

import java.awt.*;

public class Circle{

   private int centerX, centerY, radius;
   private Color color;
   private int direction, velocity;
   private boolean filled;

   public Circle(int x, int y, int r, Color c){
      centerX = x;
      centerY = y;
      radius = r;
      color = c;
      direction =0;
      velocity = 2;
      filled = false;
   }

   public void draw(Graphics g){
      Color oldColor = g.getColor();
      g.setColor(color);
      // Translates circle's center to rectangle's origin for drawing.
      if (filled)
         g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
      else
         g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
      g.setColor(oldColor);
   }

   public void fill(Graphics g){
      Color oldColor = g.getColor();
      g.setColor(color);
      // Translates circle's center to rectangle's origin for drawing.
      g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
      g.setColor(oldColor);
   }

   public boolean containsPoint(int x, int y){
      int xSquared = (x - centerX) * (x - centerX);
      int ySquared = (y - centerY) * (y - centerY);
      int radiusSquared = radius * radius;
      return xSquared + ySquared - radiusSquared <= 0;
   }

   public void move(int xAmount, int yAmount){
      centerX = centerX + xAmount;
      centerY = centerY + yAmount;
   }

   public int getRadius(){
      return radius;
   }

   public int getX(){
      return centerX;
   }

   public int getY(){
      return centerY;
   }

   public void setVelocity(int v){
      velocity = v;
   }   

   public void setDirection(int d){
      direction = d % 360;
   }

   public void turn(int degrees){
      direction = (direction + degrees) % 360;
   }

   // Moves the circle in the current direction using its
   // current velocity
   public void move(){
      move((int)(velocity * Math.cos(Math.toRadians(direction))),
           (int)(velocity * Math.sin(Math.toRadians(direction))));
   }

   public void setFilled(boolean b){
      filled = b;
   }

}



