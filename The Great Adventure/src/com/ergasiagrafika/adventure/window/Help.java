package com.ergasiagrafika.adventure.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Help extends Game {
	
	private static final long serialVersionUID = 1L;
	
	public void render(Graphics g) {
		
		Font fnt = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		g.drawString("Help Menu", 0, 50);
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.setColor(Color.WHITE);
		g.drawString("To go right press :  D  or  ->", -250, 120);
		Font fnt2 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("To go left press :  A  or  <-", -250, 160);
		Font fnt3 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt3);
		g.setColor(Color.WHITE);
		g.drawString("To jump press :  W  or  UP ", -250, 200);
		Font fnt4 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt4);
		g.setColor(Color.WHITE);
		g.drawString("To fire magic press :  Space ", -250, 240);
		Font fnt5 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt5);
		g.setColor(Color.WHITE);
		g.drawString("To exit the game press :  Esc ", -250, 280);
		
		// Back Button. Go back to the menu
		Font fnt6 = new Font("arial", Font.BOLD, 40);
		g.setFont(fnt6);
		g.setColor(Color.WHITE);
		g.drawRect(-20, 440, 200, 64);
		g.drawString("Back", 20, 485);
	}
}
