package com.ergasiagrafika.adventure.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Health {
	
	private Player player;
	private static float health = 63;
	private static float maxHEALTH = 1;
	private static float healthScale = health / maxHEALTH;
	
	public Health(Player player) {
		
		this.player = player;
	}

	public void tick() {
		
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.gray);
		g.fillRect((int)player.getX() - 5, (int)player.getY() - 7, 32 * 2 - 1, 32-28);
		g.setColor(Color.green);
		g.fillRect((int)player.getX() - 5, (int)player.getY() - 7, (int)maxHEALTH * (int)healthScale, 32-28);
		if(healthScale <= 25) {
			
			g.setColor(Color.yellow);
			g.fillRect((int)player.getX() - 5, (int)player.getY() - 7, (int)maxHEALTH * (int)healthScale, 32-28);
		}
		if(healthScale <= 15) {
			
			g.setColor(Color.red);
			g.fillRect((int)player.getX() - 5, (int)player.getY() - 7, (int)maxHEALTH * (int)healthScale, 32-28);
		}
		g.setColor(Color.white);
		g.drawRect((int)player.getX() - 5, (int)player.getY() - 7, 32 * 2 - 1, 32-28);
	}
	
	public void setHealthScale() {
		
		healthScale = 63.0f;
	}
	
	public float getHealthScale() {
		
		return healthScale;
	}
	
	public void damage(float amount) {
		
		if(healthScale > 0 && !player.isDamaged()) {
			
			healthScale -= amount;
			player.setDamaged(true);
		}
		
		if(healthScale < 0)
			healthScale = 0;
		
		if(healthScale == 0) {
			
		}		
	}
}
