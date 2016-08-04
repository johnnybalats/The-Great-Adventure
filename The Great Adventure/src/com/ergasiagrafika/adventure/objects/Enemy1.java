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

public class Enemy1  extends GameObject {

	private float width = 70, height = 82;
	//private final float MAX_SPEED = 10;
	//private float gravity = 0.5f;
	private Handler handler;
	
	Texture tex = Game.getInstance();
	
	private Animation enemy1WalkRight, enemy1WalkLeft;
	
	public Enemy1(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		
		enemy1WalkRight = new Animation(6, tex.enemy1[2], tex.enemy1[3]);
		enemy1WalkLeft = new Animation(6, tex.enemy1[0], tex.enemy1[1]);
	}

	public void tick(LinkedList<GameObject> object) {
		
		velX = 3;
		
		/*if(velX < 0)
			facing = -1;
		else if(velX > 0)
			facing = 1;
		*/
		
		if(facing == 1)
			x += velX;
		else if(facing == -1)
			x -= velX;
		//y += velY;
		
		
			
		
		/*if(falling || jumping) {
			
			velY += gravity;
			
			if(velY > MAX_SPEED)
				velY = MAX_SPEED;
		}*/
		
		Collision(object);
		
		enemy1WalkRight.runAnimation();
		enemy1WalkLeft.runAnimation();
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
					
					handler.removeObject(Enemy1.this);
					handler.removeObject(tempObject);
					System.out.println("Killed!!");
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		if(velX != 0) {
			
			if(facing == 1)
				enemy1WalkRight.drawAnimation(g, (int)x, (int)y, 70, 82);
			else
				enemy1WalkLeft.drawAnimation(g, (int)x, (int)y, 70, 82);
		} else {
			
			if(facing == 1)
				g.drawImage(tex.enemy1[2], (int)x, (int)y, 70, 82, null);
			else if(facing == -1)
				g.drawImage(tex.enemy1[0], (int)x, (int)y, 70, 82, null);
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
