package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {
	// Every fish has a x which is an int.
	int x;
	int y;
	Color color;
	boolean isLittle;
	boolean facingLeft;
	// every fish has a destination: (x,y)
	int destX;
	int destY;
	Random rand = new Random();
	final int HIGH = 450;
	final int LOW = 50;
	
	public Fish(Color c, 
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
			DrawFish.smallFacingRight(g, 
					this.color, this.x, this.y);
		}
		
	}
}
