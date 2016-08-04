package com.ergasiagrafika.adventure.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.ergasiagrafika.adventure.framework.GameObject;
import com.ergasiagrafika.adventure.framework.ObjectId;
import com.ergasiagrafika.adventure.framework.Texture;
import com.ergasiagrafika.adventure.window.Animation;
import com.ergasiagrafika.adventure.window.Game;

public class Coins extends GameObject {

	private float width = 32, height = 32;
	
	Texture tex = Game.getInstance();
	private Animation coinAnimation;
	private double takeTime = 100;
	
	public static int coins = 0;
	
	public Coins(float x, float y, ObjectId id) {
		super(x, y, id);
		
		coinAnimation = new Animation(6, tex.coin[0], tex.coin[1], tex.coin[2], tex.coin[3], tex.coin[4], tex.coin[5], tex.coin[6], tex.coin[7]);
	}

	public void tick(LinkedList<GameObject> object) {
		
		if(getTakeCoins()) {
			
			if(takeTime != 0)
				takeTime -= 1;
			
			if(takeTime <= 0) {
				
				setTakeCoins(false);
				takeTime = 100;
			}
		}
		
		coinAnimation.runAnimation();
	}

	public void render(Graphics g) {
		
		coinAnimation.drawAnimation(g, (int)x, (int)y);
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public Rectangle getBoundsRight() {
		
		return new Rectangle((int) ((int)x + width - 5), (int)y + 5, (int)5, (int)height - 10);
	}
	
	public Rectangle getBoundsLeft() {
		
		return new Rectangle((int)x, (int)y + 5, (int)5, (int)height - 10);
	}
}
