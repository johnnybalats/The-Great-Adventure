package com.ergasiagrafika.adventure.framework;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ergasiagrafika.adventure.window.About;
import com.ergasiagrafika.adventure.window.Game;
import com.ergasiagrafika.adventure.window.Help;

public class MouseInput implements MouseListener {
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		
		if(mx > x && mx < x + width) {
			
			if(my > y && my < y + height) {
				
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		// Play Button
		if(mx >= Game.WIDTH / -150 + 400 && mx <= Game.WIDTH / -150 + 520) {
			
			if(my >= 150 && my <= 200) {
				
				Game.State = Game.STATE.GAME;
			}
		}
		
		// Help Button
		if(mx >= Game.WIDTH / -150 + 400 && mx <= Game.WIDTH / -150 + 520) {
			
			if(my >= 250 && my <= 300) {
				
				Help.State = Help.STATE.HELP;
				
				if(mouseOver(mx, my, -20, 440, 200, 64)) {
					
					Game.State = Game.STATE.MENU;
					System.out.println("Clicked!!");
				}
			}
		}
		
		// About Button
				if(mx >= Game.WIDTH / -150 + 400 && mx <= Game.WIDTH / -150 + 520) {
					
					if(my >= 350 && my <= 400) {
						
						About.State =About.STATE.ABOUT;
					}
				}
		
		// Quit Button
		if(mx >= Game.WIDTH / -150 + 400 && mx <= Game.WIDTH / -150 + 520) {
			
			if(my >= 450 && my <= 500) {
				
				System.exit(1);
			}
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
