package com.ergasiagrafika.adventure.window;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.ergasiagrafika.adventure.framework.GameObject;
import com.ergasiagrafika.adventure.framework.ObjectId;
import com.ergasiagrafika.adventure.objects.Block;
import com.ergasiagrafika.adventure.objects.Coins;
import com.ergasiagrafika.adventure.objects.Ditch;
import com.ergasiagrafika.adventure.objects.Enemy1;
import com.ergasiagrafika.adventure.objects.Flag;
import com.ergasiagrafika.adventure.objects.Mummy;
import com.ergasiagrafika.adventure.objects.Player;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	private Camera cam;
	private Coins coins;
	private BufferedImage level1 = null, level2 = null, level3 = null, level4 = null;
	public static int sumbonus = 50;
	Graphics g = null;
	
	public Handler(Camera cam) {
		
		this.cam = cam;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level1 = loader.loadImage("/level1.png"); // loading the level
		level2 = loader.loadImage("/level2.png"); 
		level3 = loader.loadImage("/level3.png");
		level4 = loader.loadImage("/level4.png");
	}
	
	public void tick() {
		
		for(int i = 0; i < object.size(); i++) {
			
			tempObject = object.get(i);
			
			tempObject.tick(object);
		}
	}
	
	public void render(Graphics g) {
		
		for(int i = 0; i < object.size(); i++) {
			
			tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void LoadImageLevel(BufferedImage image) {
		
		int w = image.getWidth();
		int h = image.getHeight();
		
		System.out.println("width, height " + w + " " + h);
		
		for(int xx = 0; xx < h; xx++) {
			
			for(int yy = 0; yy < w; yy++) {
				
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255 && green == 255 && blue == 255)
					addObject(new Block(xx * 32, yy * 32, 0, ObjectId.Block));
				
				if(red == 128 && green == 128 && blue == 128)
					addObject(new Block(xx * 32, yy * 32, 1, ObjectId.Block));
				
				if(red == 73 && green == 218 && blue == 44)
					addObject(new Block(xx * 32, yy * 32, 2, ObjectId.Block));
				
				if(red == 253 && green == 253 && blue == 253)
					addObject(new Block(xx * 32, yy * 32, 3, ObjectId.Block));
				
				if(red == 0 && green == 0 && blue == 255)
					addObject(new Player(xx * 32, yy * 32, this, cam, ObjectId.Player));
				
				if(red == 255 && green == 216 && blue == 0)
					addObject(new Flag(xx * 32, yy * 32, ObjectId.Flag));
				
				if(red == 255 && green == 0 && blue == 0)
					addObject(new Enemy1(xx * 32, yy * 32, this, ObjectId.Enemy1));
				
				if(red == 254 && green == 0 && blue == 0)
					addObject(new Mummy(xx * 32, yy * 32, this, ObjectId.Mummy));
				
				if (red == 0 && green == 254 && blue == 0)
					addObject(new Coins(xx * 32, yy * 32, ObjectId.Coins));
				
				if (red == 255 && green == 165 && blue == 0)
					addObject(new Ditch(xx*32,yy*32,this,ObjectId.Ditch));
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void switchLevel() {
		
		clearLevel();
		cam.setX(0);
		
		switch(Game.LEVEL) {
		
		case 0:
			
			LoadImageLevel(level1);
			break;
		case 1:
			
			LoadImageLevel(level2);
			break;
		case 2:
			
			LoadImageLevel(level3);
			break;
		case 3:
			
			LoadImageLevel(level4);
			break;
		case 4:
			
			Game.music.stop();
		}
		
		Game.LEVEL++;
		sumbonus += coins.coins;
	}

	private void clearLevel() {
		
		object.clear();
	}
	
	public void addObject(GameObject object) {
		
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		
		this.object.remove(object);
	}
	
	@SuppressWarnings("static-access")
	public void death(Game game) {
		
		clearLevel();
		game.LEVEL = 1;
		
		if (Game.LEVEL == 0){
			
			System.out.println("Level 1 pista");
			LoadImageLevel(level1);

		} else if (Game.LEVEL == 1){
			
			clearLevel();
			System.out.println("Exases magka pali apo thn arxh");
			LoadImageLevel(level1);
			
		} else if (Game.LEVEL == 2){
			
			clearLevel();
			LoadImageLevel(level1);
			System.out.println("Exases magka pali apo thn arxh");
		
		} else if (Game.LEVEL == 3){
				
				clearLevel();
				LoadImageLevel(level1);
				System.out.println("Exases magka pali apo thn arxh");
		} else if (Game.LEVEL == 4) {
				
				clearLevel();
				LoadImageLevel(level1);
				System.out.println("Exases magka pali apo thn arxh");
			
		}
	}
}
