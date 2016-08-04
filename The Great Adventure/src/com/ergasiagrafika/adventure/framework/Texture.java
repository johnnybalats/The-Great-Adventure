package com.ergasiagrafika.adventure.framework;

import java.awt.image.BufferedImage;

import com.ergasiagrafika.adventure.window.BufferedImageLoader;

public class Texture {

	SpriteSheet bs, ps, bulsh, fs, e1s, ms, cs;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	private BufferedImage fireball_sheet = null;
	private BufferedImage flag_sheet = null;
	private BufferedImage enemy1_sheet = null;
	private BufferedImage mummy_sheet = null;
	private BufferedImage coins_sheet = null;
	
	public BufferedImage[] block = new BufferedImage[4];
	public BufferedImage[] player = new BufferedImage[20];
	public BufferedImage[] player_jump = new BufferedImage[5];
	public BufferedImage[] fireball = new BufferedImage[8];
	public BufferedImage[] flag = new BufferedImage[1];
	public BufferedImage[] enemy1 = new BufferedImage[4];
	public BufferedImage[] mummy = new BufferedImage[4];
	public BufferedImage[] coin = new BufferedImage[8];
	
	public Texture() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			
			block_sheet = loader.loadImage("/block_sheet.png");
			player_sheet = loader.loadImage("/neon_knight.png");
			fireball_sheet = loader.loadImage("/fireballs.png");
			flag_sheet = loader.loadImage("/door.png");
			enemy1_sheet = loader.loadImage("/enemy1_skull.png");
			mummy_sheet = loader.loadImage("/mummy.png");
			coins_sheet = loader.loadImage("/coins.png");
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		bulsh = new SpriteSheet(fireball_sheet);
		fs = new SpriteSheet(flag_sheet);
		e1s = new SpriteSheet(enemy1_sheet);
		ms = new SpriteSheet(mummy_sheet);
		cs = new SpriteSheet(coins_sheet);
		
		getTextures();
	}
	
	private void getTextures() {
		
		block[0] = bs.grabImage(1, 1, 32, 32); // dirt block
		block[1] = bs.grabImage(2, 1, 32, 32); // grass block
		block[2] = bs.grabImage(3, 1, 32, 32); // stone block
		block[3] = bs.grabImage(4, 1, 32, 32); // castle block
		
		// looking right
		player[0] = ps.grabImage(1, 1, 34, 33); // player
		player[1] = ps.grabImage(2, 1, 34, 33); // walking animation for player
		player[2] = ps.grabImage(3, 1, 34, 33); // walking animation for player
		player[3] = ps.grabImage(4, 1, 34, 33); // walking animation for player
		player[4] = ps.grabImage(5, 1, 34, 33); // walking animation for player
		player[5] = ps.grabImage(6, 1, 34, 33); // walking animation for player
		player[6] = ps.grabImage(7, 1, 34, 33); // walking animation for player
		player[7] = ps.grabImage(8, 1, 34, 33); // walking animation for player
		player[8] = ps.grabImage(9, 1, 34, 33); // walking animation for player
		player[9] = ps.grabImage(1, 2, 34, 33); // walking animation for player
		
		// looking left
		player[10] = ps.grabImage(2, 2, 34, 33); // player
		player[11] = ps.grabImage(3, 2, 34, 33); // walking animation for player
		player[12] = ps.grabImage(4, 2, 34, 33); // walking animation for player
		player[13] = ps.grabImage(5, 2, 34, 33); // walking animation for player
		player[14] = ps.grabImage(6, 2, 34, 33); // walking animation for player
		player[15] = ps.grabImage(7, 2, 34, 33); // walking animation for player
		player[16] = ps.grabImage(8, 2, 34, 33); // walking animation for player
		player[17] = ps.grabImage(9, 2, 34, 33); // walking animation for player
		player[18] = ps.grabImage(1, 3, 34, 33); // walking animation for player
		player[19] = ps.grabImage(2, 3, 34, 33); // walking animation for player
		
		// player is jumping
		player_jump[0] = ps.grabImage(3, 3, 33, 34);
		player_jump[1] = ps.grabImage(4, 3, 33, 34);
		
		// fire balls
		fireball[0] = bulsh.grabImage(1, 1, 16, 16);
		fireball[1] = bulsh.grabImage(2, 1, 16, 16);
		fireball[2] = bulsh.grabImage(3, 1, 16, 16);
		fireball[3] = bulsh.grabImage(4, 1, 16, 16);
		fireball[4] = bulsh.grabImage(1, 2, 16, 16);
		fireball[5] = bulsh.grabImage(2, 2, 16, 16);
		fireball[6] = bulsh.grabImage(3, 2, 16, 16);
		fireball[7] = bulsh.grabImage(4, 2, 16, 16);
		
		// door
		flag[0] = fs.grabImage(1, 1, 100, 140);
		
		// enemy is walking left
		enemy1[0] = e1s.grabImage(1, 1, 34, 34);
		enemy1[1] = e1s.grabImage(2, 1, 34, 34);
		
		//enemy is walking right
		enemy1[2] = e1s.grabImage(3, 1, 34, 34);
		enemy1[3] = e1s.grabImage(4, 1, 34, 34);
		
		// mummy enemy is walking left
		mummy[0] = ms.grabImage(1, 1, 34, 41);
		mummy[1] = ms.grabImage(2, 1, 34, 41);
		
		// mummy enemy is walking right
		mummy[2] = ms.grabImage(3, 1, 34, 41);
		mummy[3] = ms.grabImage(4, 1, 34, 41);
		
		// coins spinning
		coin[0] = cs.grabImage(1, 1, 32, 32);
		coin[1] = cs.grabImage(2, 1, 32, 32);
		coin[2] = cs.grabImage(3, 1, 32, 32);
		coin[3] = cs.grabImage(4, 1, 32, 32);
		coin[4] = cs.grabImage(5, 1, 32, 32);
		coin[5] = cs.grabImage(6, 1, 32, 32);
		coin[6] = cs.grabImage(7, 1, 32, 32);
		coin[7] = cs.grabImage(8, 1, 32, 32);
	}
}
