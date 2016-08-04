package com.ergasiagrafika.adventure.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.ergasiagrafika.adventure.window.Game.STATE;

public class Menu {

	public Rectangle playButton = new Rectangle(Game.WIDTH / -150 + 120, 150, 100, 50);
	public Rectangle helpButton = new Rectangle(Game.WIDTH / -150 + 120, 250, 100, 50);
	public Rectangle aboutButton = new Rectangle(Game.WIDTH / -150 + 120, 350, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / -150 + 120, 450, 100, 50);
	
	private BufferedImage playButtonImg = null;
	
	public void render(Graphics g) {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		playButtonImg = loader.loadImage("/button.png");
		
		if(Game.State == STATE.MENU) {
			
			Font fnt1 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt1);
			g.setColor(Color.BLACK);
			g.drawString("The Great Adventure", -110, 100);
		
			// Play
			g.drawImage(playButtonImg, 10, 70, null);
			Font fnt2 = new Font("arial", Font.BOLD, 40);
			g.setFont(fnt2);
			g.setColor(Color.BLACK);
			g.drawString("Play", playButton.x + 10, playButton.y + 40);
		
			// Help
			g.drawImage(playButtonImg, 10, 170, null);
			Font fnt3 = new Font("arial", Font.BOLD, 40);
			g.setFont(fnt3);
			g.setColor(Color.BLACK);
			g.drawString("Help", helpButton.x + 10, helpButton.y + 40);
		
			// About
			g.drawImage(playButtonImg, 10, 270, null);
			Font fnt4 = new Font("arial", Font.BOLD, 40);
			g.setFont(fnt4);
			g.setColor(Color.BLACK);
			g.drawString("About", aboutButton.x, aboutButton.y + 40);
		
			// Quit
			g.drawImage(playButtonImg, 10, 370, null);
			Font fnt5 = new Font("arial", Font.BOLD, 40);
			g.setFont(fnt5);
			g.setColor(Color.BLACK);
			g.drawString("Quit", quitButton.x + 10, quitButton.y + 40);
		} else if(Game.State == STATE.HELP) {
			
			
		}
	}
}
