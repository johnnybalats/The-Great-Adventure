package com.ergasiagrafika.adventure.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.ergasiagrafika.adventure.framework.GameObject;
import com.ergasiagrafika.adventure.framework.ObjectId;
import com.ergasiagrafika.adventure.framework.Texture;
import com.ergasiagrafika.adventure.window.Game;

public class Block extends GameObject {

	Texture tex = Game.getInstance();
	private int type;
	
	public Block(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
	}
	
	public void tick(LinkedList<GameObject> object) {
		
		
	}

	public void render(Graphics g) {
		
		if(type == 0) // dirt block
			g.drawImage(tex.block[0], (int)x, (int)y, null);
			
		if(type == 1) // grass block
			g.drawImage(tex.block[1], (int)x, (int)y, null);
		
		if(type == 2) // stone block
			g.drawImage(tex.block[2], (int)x, (int)y, null);
		
		if(type == 3) // stone block
			g.drawImage(tex.block[3], (int)x, (int)y, null);
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 32, 32);
	}
}
