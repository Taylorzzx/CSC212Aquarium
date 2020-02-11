package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Bubble {
	// Every fish has a x which is an int.
		int x;
		int y;
		Color color;
		// every fish has a destination: (x,y)
		int destX;
		int destY;
		int howBig;
		
		public Bubble(Color c, int startX, int startY, int howBig) {
			this.color = c;
			this.x = startX;
			this.y = startY;
			this.howBig = howBig;
		}
		
		public void swimup() {
			this.y -= 1;
			
			if (this.y == 0 ) {
				this.y = 700;	
			}
		}
		public void draw(Graphics2D g) {	
			this.swimup();
			g.setColor(color);
			Shape bubble = new Ellipse2D.Double(x - 15, y - 10, this.howBig+10, this.howBig+10);
			g.setColor(this.color);
			g.fill(bubble);

		}
		public void drawBox(Graphics2D g) {
			Shape Box1 = new Rectangle2D.Double(350, 460, 150, 100);
			g.fill(Box1);
			g.setColor(Color.magenta);
			g.draw(Box1);
			
			Shape Box2 = new Rectangle2D.Double(350, 457, 150, 15);
			g.fill(Box2);
			g.setColor(Color.cyan);
			g.draw(Box2);
			
			
		}
}
