package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import me.jjfoley.gfx.GFX;

/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */
public class Aquarium extends GFX {
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	public static int WIDTH = 500;
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(100, Snail.HEIGHT + 1, "top");
	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */
	Bubble[] bubble10 = new Bubble[10];
	HungryFish[] hungryfish = new HungryFish[5];
	Fish[] fish10 = new Fish[10];
	Random rand = new Random();	
	final int HIGH = 450;
	final int LOW = 50;
	int destY= rand.nextInt((HIGH-LOW) + LOW);
	int destX= rand.nextInt((HIGH-LOW) + LOW);
	int startY= rand.nextInt((HIGH-LOW) + LOW);
	int startX= rand.nextInt((HIGH-LOW) + LOW);
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		
	super(WIDTH, HEIGHT);
	int BubbleX = 370;
	int BubbleY = 400;
	
	for (int i = 0; i < this.fish10.length; i++) {
		Color rcolor = Color.getHSBColor( rand.nextFloat(), 0.8f, 0.8f);
		boolean isSmall = true;
		boolean isFacingLeft = rand.nextBoolean();
		int startY= rand.nextInt((HIGH-LOW) + LOW);
		int startX= rand.nextInt((HIGH-LOW) + LOW);
		this.fish10[i] = new Fish(rcolor, startX, startY,
				isSmall,isFacingLeft, destX,destY);
		}
	for (int i=0; i<this.bubble10.length; i++) {
		bubble10[i] = new Bubble(Color.white, 
				BubbleX,BubbleY,rand.nextInt((25-5) + 5));
		BubbleX += rand.nextInt((20-5) + 5);
		BubbleY += rand.nextInt((50-5) + 5);
		}
	for (int i = 0; i < this.hungryfish.length; i++) {
		//Color rcolor = Color.getHSBColor( rand.nextFloat(), 0.8f, 0.8f);
		boolean isSmall = true;
		boolean isFacingLeft = rand.nextBoolean();
		int startY= rand.nextInt((HIGH-LOW) + LOW);
		int startX= rand.nextInt((HIGH-LOW) + LOW);
		this.hungryfish[i] = new HungryFish(Color.white, startX, startY,
				isSmall,isFacingLeft, destX,destY);
		}
	}
	Fish Jaws = new Fish(Color.white,startX, startY, false, true, destX, destY);
	
	HungryFish specialkelp = new HungryFish(Color.green, 
			200, 450, true, true, destX, destY);
	
	Bubble box = new Bubble(Color.cyan, 
			450,450,rand.nextInt((25-5) + 5));
	
	HungryFish kelparea = new HungryFish(Color.green, 
			200, 450, true, true, destX, destY);
	
	public void draw(Graphics2D g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());
		for (Bubble bubble: this.bubble10) {
			bubble.draw(g);
		}
		box.drawBox(g);
		for (Fish fishes: this.fish10) {
			fishes.draw(g);
		}
		for (HungryFish fishes: this.hungryfish) {
			fishes.draw(g);
		}	
		Jaws.draw(g);
		kelparea.drawarea(g);
		specialkelp.drawkelp(g);
		algorithm.draw(g);

		
	}
	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
