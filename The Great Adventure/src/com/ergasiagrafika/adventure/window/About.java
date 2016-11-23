package com.ergasiagrafika.adventure.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class About extends Game {

	private static final long serialVersionUID = -7711566777749910516L;
	
	public void render(Graphics g) {
		
		Font fnt = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		g.drawString("About Menu", 0, 50);
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.setColor(Color.WHITE);
		g.drawString("This game was created by ", -250, 120);
		Font fnt2 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("John Balatsos and Rafael Kermizidis!", -250, 160);
	}
}
