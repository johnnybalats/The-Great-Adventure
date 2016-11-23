package com.ergasiagrafika.adventure.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {

	protected float x, y;
	protected ObjectId id;
	protected float velX = 0, velY = 0;
	protected boolean falling = true;
	protected boolean jumping = false;
	protected int facing = 1;
	protected boolean damaged;
	protected boolean taking;
	protected boolean dead;
	
	public GameObject(float x, float y, ObjectId id) {
		
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public float getX() {
		
		return x;
	}
	
	public float getY() {
		
		return y;
	}
	
	public void setX(float x) {
		
		this.x = x;
	}
	
	public void setY(float y) {
		
		this.y = y;
	}
	
	public float getVelX() {
		
		return velX;
	}
	
	public float getVelY() {
		
		return velY;
	}
	
	public void setVelX(float velX) {
		
		this.velX = velX;
	}
	public void setVelY(float velY) {
		
		this.velY = velY;
	}
	
	public boolean isFalling() {
		
		return falling;
	}

	public void setFalling(boolean falling) {
		
		this.falling = falling;
	}

	public boolean isJumping() {
		
		return jumping;
	}

	public void setJumping(boolean jumping) {
		
		this.jumping = jumping;
	}
	
	public void setDamaged(boolean damaged) {
		
		this.damaged = damaged;
	}
	
	public void setTakeCoins(boolean taking) {
		
		this.taking = taking;
	}
	
	public int getFacing() {
		
		return facing;
	}

	public ObjectId getId() {
		
		return id;
	}
	
	public boolean isDamaged() {
		
		return damaged;
	}
	
	public boolean getTakeCoins() {
		
		return taking;
	}
	
	public void setDead(boolean dead) {
		
		this.dead = dead;
	}
	
	public boolean isDead() {
		
		return dead;
	}
}
