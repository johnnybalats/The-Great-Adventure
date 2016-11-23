package com.ergasiagrafika.adventure.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.ergasiagrafika.adventure.framework.GameObject;
import com.ergasiagrafika.adventure.framework.ObjectId;
import com.ergasiagrafika.adventure.framework.Texture;
import com.ergasiagrafika.adventure.window.Game;

public class Flag extends GameObject {
	
	Texture tex = Game.getInstance();
	
	public Flag(float x, float y, ObjectId id) {
		super(x, y, id);
		
	}

	public void tick(LinkedList<GameObject> object) {
		
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.yellow);
		g.drawImage(tex.flag[0], (int)x, (int)y, 100, 165, null);
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 65, 65);
	}
}

