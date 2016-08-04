package com.ergasiagrafika.adventure.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {

	private Player player;
	
	public Score(Player player) {
		
		this.player = player;
	}
	
	public void tick() {
		
		
	}
	
	@SuppressWarnings("static-access")
	public void render(Graphics g) {
		
		Font fnt = new Font("arial", Font.BOLD, 12);
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		g.drawString("Score : " + player.sum, (int)player.getX() - 5, (int)player.getY() - 9);
	}
	
	@SuppressWarnings("static-access")
	public void setScore() {
		
		player.sum = 0;
	}
}
