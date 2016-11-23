  package com.ergasiagrafika.adventure.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.ergasiagrafika.adventure.framework.GameObject;
import com.ergasiagrafika.adventure.framework.ObjectId;
import com.ergasiagrafika.adventure.framework.Texture;
import com.ergasiagrafika.adventure.window.Animation;
import com.ergasiagrafika.adventure.window.Game;
import com.ergasiagrafika.adventure.window.Handler;

public class Mummy extends GameObject {

	private float width = 70, height = 82;
	
	private Handler handler;
	
	Texture tex = Game.getInstance();
	
	private Animation MummyWalkRight, MummyWalkLeft;
	
	public Mummy(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		
		MummyWalkRight = new Animation(6, tex.mummy[2], tex.mummy[3]);
		MummyWalkLeft = new Animation(6, tex.mummy[0], tex.mummy[1]);
	}

	public void tick(LinkedList<GameObject> object) {
		
		velX = 1;
		if(facing == 1)
			x += velX;
		else if(facing == -1)
			x -= velX;
		
		Collision(object);
		
		MummyWalkRight.runAnimation();
		MummyWalkLeft.runAnimation();
	}

	private void Collision(LinkedList<GameObject> object) {
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Block) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					
					y = tempObject.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
				} else {
					
					falling = true;
				}
				
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					
					x = tempObject.getX() - width;
					facing = -1;
				}
				
				if(getBoundsLeft().intersects(tempObject.getBounds())) {
					
					x = tempObject.getX() + 35;
					facing = 1;
				}
			} else if(tempObject.getId() == ObjectId.Bullet) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					
					handler.removeObject(Mummy.this);
					handler.removeObject(tempObject);
					System.out.println("Killed!!");
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.green);
		if(velX != 0) {
			
			if(facing == 1)
				MummyWalkRight.drawAnimation(g, (int)x, (int)y, 70, 82);
			else
				MummyWalkLeft.drawAnimation(g, (int)x, (int)y, 70, 82);
		} else {
			
			if(facing == 1)
				g.drawImage(tex.mummy[2], (int)x, (int)y, 70, 82, null);
			else if(facing == -1)
				g.drawImage(tex.mummy[0], (int)x, (int)y, 70, 82, null);
		}
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int)x + ((int)width / 2) - (((int)width / 2) / 2), (int)y + ((int)height / 2), (int)width / 2, (int)height / 2);
	}
	
	public Rectangle getBoundsTop() {
		
		return new Rectangle((int)x + ((int)width / 2) - (((int)width / 2) / 2), (int)y, (int)width / 2, (int)height / 2);
	}
	
	public Rectangle getBoundsRight() {
		
		return new Rectangle((int) ((int)x + width - 5), (int)y + 5, (int)5, (int)height - 10);
	}
	
	public Rectangle getBoundsLeft() {
	
		return new Rectangle((int)x, (int)y + 5, (int)5, (int)height - 10);
	}
}
