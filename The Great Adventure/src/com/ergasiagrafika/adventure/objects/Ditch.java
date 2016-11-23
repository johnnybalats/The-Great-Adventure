package com.ergasiagrafika.adventure.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.ergasiagrafika.adventure.framework.GameObject;
import com.ergasiagrafika.adventure.framework.ObjectId;
import com.ergasiagrafika.adventure.window.Handler;

public class Ditch extends GameObject {
	
	private float width = 70, height = 82;
	@SuppressWarnings("unused")
	private Handler handler;

	public Ditch(float x, float y,Handler handler,ObjectId id) {
		
		super(x, y, id);
		this.handler = handler;
	}

	
	public void tick(LinkedList<GameObject> object) {
		
		
	}
	
	public void render(Graphics g) {
		
			
	}
	
	public void gameover(Graphics g){
		
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x + ((int)width / 2) - (((int)width / 2) / 2), (int)y + ((int)height / 2), (int)width / 2, (int)height / 2);
	}
	
	public Rectangle getBoundsTop() {
		
		return new Rectangle((int)x + ((int)width / 2) - (((int)width / 2) / 2), (int)y, (int)width / 2, (int)height / 2);
	}
}
