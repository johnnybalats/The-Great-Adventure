package com.ergasiagrafika.adventure.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.ergasiagrafika.adventure.framework.GameObject;
import com.ergasiagrafika.adventure.framework.ObjectId;
import com.ergasiagrafika.adventure.framework.Texture;
import com.ergasiagrafika.adventure.window.Animation;
import com.ergasiagrafika.adventure.window.Camera;
import com.ergasiagrafika.adventure.window.Game;
import com.ergasiagrafika.adventure.window.Handler;

public class Player extends GameObject {

	private float width = 70, height = 82;
	
	private float gravity = 0.5f;
	private double dmgTime = 100;
	private final float MAX_SPEED = 10;
	private Handler handler;
	public Health health = new Health(this);
	public Score score = new Score(this);
	public static int sum = 0;
	
	Texture tex = Game.getInstance();
	private Game game;
	
	private Animation playerWalk, playerWalkLeft;
	
	public Player(float x, float y, Handler handler, Camera cam, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		
		playerWalk = new Animation(6, tex.player[1], tex.player[2], tex.player[3], tex.player[4], tex.player[5], tex.player[6],
				tex.player[7], tex.player[8], tex.player[9]);
		
		playerWalkLeft = new Animation(6, tex.player[11], tex.player[12], tex.player[13], tex.player[14], tex.player[15],
				tex.player[16], tex.player[17], tex.player[18], tex.player[19]);
	}
	
	public void tick(LinkedList<GameObject> object) {
		
		health.tick();
		
		if(isDamaged()) {
			
			if(dmgTime != 0)
				dmgTime -= 1;
				
			if(dmgTime <= 0) {
				
				setDamaged(false);
				dmgTime = 100;
			}
		}
		
		x += velX;
		y += velY;
		
		if(velX < 0)
			facing = -1;
		else if(velX > 0)
			facing = 1;
			
		
		if(falling || jumping) {
			
			velY += gravity;
			
			if(velY > MAX_SPEED)
				velY = MAX_SPEED;
		}
		
		Collision(object);
		
		playerWalk.runAnimation();
		playerWalkLeft.runAnimation();
	}
	
	@SuppressWarnings("static-access")
	private void Collision(LinkedList<GameObject> object) {
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Block) {
				
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					
					y = tempObject.getY() + 32;
					velY = 0;
				}
				
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
				}
				
				if(getBoundsLeft().intersects(tempObject.getBounds())) {
					
					x = tempObject.getX() + 35;
				}
			} else if(tempObject.getId() == ObjectId.Flag) {
				
				// switch level
				if(getBounds().intersects(tempObject.getBounds())) {
					
					handler.switchLevel();
				}
			} else if(tempObject.getId() == ObjectId.Enemy1) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					
					health.damage(10);
					if(health.getHealthScale() == 0) {
						
						handler.death(game);
						health.setHealthScale();
						score.setScore();
					}
				}
			} else if(tempObject.getId() == ObjectId.Mummy) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					
					health.damage(10);
					if(health.getHealthScale() == 0) {
						
						handler.death(game);
						health.setHealthScale();
						score.setScore();
					}
				}
			} else if (tempObject.getId() == ObjectId.Coins){
				
				if (getBoundsLeft().intersects(tempObject.getBounds()) || getBoundsRight().intersects(tempObject.getBounds()) || getBounds().intersects(tempObject.getBounds())){
					
						handler.removeObject(tempObject);
						
						sum = sum + handler.sumbonus ;
						System.out.println("Bonus : " + " " + sum);
				}
			} else if(tempObject.getId() == ObjectId.Ditch) {
				
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					
					handler.death(game);
					sum = 0;
				}
			}
		}
	}
	
	public void render(Graphics g) {
				
		g.setColor(Color.blue);
		if(jumping) {
			
			if(facing == 1)
				g.drawImage(tex.player_jump[0], (int)x, (int)y, 70, 82, null);
			else if(facing == -1)
				g.drawImage(tex.player_jump[1], (int)x, (int)y, 70, 82, null);
		} else {
			
			if(velX != 0) {
				
				if(facing == 1)
					playerWalk.drawAnimation(g, (int)x, (int)y, 70, 82);
				else
					playerWalkLeft.drawAnimation(g, (int)x, (int)y, 70, 82);
			} else {
				
				if(facing == 1)
					g.drawImage(tex.player[0], (int)x, (int)y, 70, 82, null);
				else if(facing == -1)
					g.drawImage(tex.player[10], (int)x, (int)y, 70, 82, null);
			}
		}
		
		health.render(g);
		score.render(g);
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
