package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Bubble {
	// Every fish has a x which is an int.
		int x;
		int y;
		Color color;
		boolean isLittle;
		boolean facingLeft;
		// every fish has a destination: (x,y)
		int destX;
		int destY;
		//int destXHigh = destX + 10;
		//int destXLow = destX - 10;
		//int destYHigh = destX + 10;
		//int destYLow = destX - 10;
		
		public Bubble(Color c, 
				int startX, int startY) {
			this.color = c;
			this.x = startX;
			this.y = startY;	
		}
		public void swimup() {
			this.y -= 2;
			
			if (this.y == 0 ) {
				this.y = 700;
					
			}
		}
		public void draw(Graphics2D g) {
			this.swimup();
			// fish face left and are small
			// smallFacingRight, facingLeft, and facingRight
			
			g.setColor(color);
			Shape eye = new Ellipse2D.Double(x - 15, y - 10, 20, 20);
			// draw bubble outline.
			g.setColor(Color.white);
			// draw bubble:
			g.fill(eye);

		}

}
