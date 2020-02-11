package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class HungryFish {
	
	int x;
	int y;
	Color color;
	boolean isLittle;
	boolean facingLeft;
	// every fish has a random destination: (x,y)
	int destX;
	int destY;
	Random rand = new Random();
	
	public HungryFish(Color c, 
			int startX, int startY, 
			boolean isLittle, boolean facingLeft, int destY, int destX) {
		this.color = c;
		this.x = startX;
		this.y = startY;
		this.isLittle = isLittle;
		this.facingLeft = facingLeft;	
		this.destX = destX;
		this.destY = destY;
		
	}
	public void swim() {
		int HIGH = 450;
		int LOW = 50;	
		if (this.x < this.destX) {
			this.facingLeft = false;
			this.x += 2;
		}
		if (this.x > this.destX) {
			this.facingLeft = true;
			this.x -= 2;	
		}	
		if (this.y < this.destY) {
			this.y += 2;		
		}	
		if (this.y > this.destY) {
			this.y -= 2;		
		}		
		if (this.destY-5 < this.y && 
				this.y < this.destY + 5 && 
				this.destX-5 < this.x && 
				this.x < this.destX +5) {
			this.destY = rand.nextInt(HIGH-LOW) + LOW;
			this.destX = rand.nextInt(HIGH-LOW) + LOW;	
		}
		if (this.x > 250 && this.y > 300) {
			color = Color.red;
			for (int i = 0; i < 6; i++) {
				this.x -=1;
				this.y -=2;
			}
		}
		if (this.x > 250 && this.y > 300) {
			color = Color.red;
			for (int i = 0; i < 6; i++) {
				this.x -=1;
				this.y -=2;
			}
		}
	}
	public void draw(Graphics2D g) {
		this.swim();
		// fish face left and are small
		// smallFacingRight, facingLeft, and facingRight
		if (isLittle == true && facingLeft == true) {
			DrawFish.smallFacingLeft(g, 
					this.color, this.x, this.y);
		}
		if (isLittle == true && facingLeft == false) {
			DrawFish.smallFacingRight(g, 
					this.color, this.x, this.y);
		}
		if (isLittle == false && facingLeft == true) {
			DrawFish.facingLeft(g, 
					this.color, this.x, this.y);
		}
		if (isLittle == false && facingLeft == false) {
			DrawFish.facingRight(g, 
					this.color, this.x, this.y);
		}
		
	}
	
	public void kelpmove() {
		this.y -= 2;
		if (this.y < 300) {
			int HIGH = 200;
			int LOW = 50;
			this.y = 1000;
			this.x = rand.nextInt(HIGH-LOW) + LOW;
		}		
	}


	public void drawkelp(Graphics2D g) {
		this.kelpmove();
		g.setColor(color);
		Shape kelp = new Ellipse2D.Double(120, 480, 10, 10);
		g.setColor(Color.green);
		g.fill(kelp);

	}
	
	public void drawarea(Graphics2D g) {
		Shape Box1 = new Rectangle2D.Double(0, 480, 200, 50);
		g.fill(Box1);
		g.setColor(Color.green);
		g.draw(Box1);
		
		Shape Box2 = new Rectangle2D.Double(0, 487, 200, 15);
		g.fill(Box2);
		g.setColor(Color.green);
		g.draw(Box2);
		
		
	}

}

