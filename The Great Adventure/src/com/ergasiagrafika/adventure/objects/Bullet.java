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

public class Bullet extends GameObject {

	Texture tex = Game.getInstance();
	private Animation fireballright, fireballleft;
	
	public Bullet(float x, float y, ObjectId id, int velX) {
		super(x, y, id);
		this.velX = velX;
		
		fireballright = new Animation(1, tex.fireball[1], tex.fireball[2], tex.fireball[3]);
		fireballleft = new Animation(1, tex.fireball[5], tex.fireball[6], tex.fireball[7]);
	}

	public void tick(LinkedList<GameObject> object) {
		
		x += velX;
		
		fireballright.runAnimation();
		fireballleft.runAnimation();
	}	
	
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		if(facing == 1)
			g.drawImage(tex.fireball[0], (int)x, (int)y, null);
		else if(facing == -1)
			g.drawImage(tex.fireball[4], (int)x, (int)y, null);
		
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 16, 16);
	}
}
