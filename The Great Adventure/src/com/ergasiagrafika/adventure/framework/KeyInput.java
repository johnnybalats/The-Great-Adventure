package com.ergasiagrafika.adventure.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.ergasiagrafika.adventure.objects.Bullet;
import com.ergasiagrafika.adventure.window.Game;
import com.ergasiagrafika.adventure.window.Game.STATE;
import com.ergasiagrafika.adventure.window.Handler;
import com.ergasiagrafika.adventure.window.Help;

public class KeyInput extends KeyAdapter {

	Handler handler;
	private boolean is_shooting = false;
	
	public KeyInput(Handler handler) {
		
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Player) {
				
				if(Game.State == STATE.GAME) {
					
					if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
					if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
					if((key == KeyEvent.VK_W || key == KeyEvent.VK_UP) && !tempObject.isJumping()) {
					
						tempObject.setJumping(true);
						tempObject.setVelY(-15);
					}
					if(key == KeyEvent.VK_SPACE && !is_shooting) {
					
						is_shooting = true;
						handler.addObject(new Bullet(tempObject.getX(), tempObject.getY() + 28, ObjectId.Bullet, tempObject.getFacing() * 10));
					}
				} else if(Help.State == STATE.HELP) {
					
					if(key == KeyEvent.VK_BACK_SPACE) {
						
						
						System.out.println("Worked!");
					}
				}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) {
			
			System.exit(1);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Player) {
				
				if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_SPACE) is_shooting = false;
			}
		}
	}
}
