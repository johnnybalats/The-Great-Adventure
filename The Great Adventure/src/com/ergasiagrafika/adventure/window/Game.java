package com.ergasiagrafika.adventure.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.ergasiagrafika.adventure.framework.KeyInput;
import com.ergasiagrafika.adventure.framework.MouseInput;
import com.ergasiagrafika.adventure.framework.ObjectId;
import com.ergasiagrafika.adventure.framework.Texture;
import com.ergasiagrafika.adventure.objects.Player;

import Audio.AudioPlayer;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 3369740132434760809L;

	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH, HEIGHT;
	
	public BufferedImage level = null, fire = null, skeleton = null,
			background = null, colona = null, coins = null;
	
	//Object
	Handler handler;
	Camera cam;
	static Texture tex;
	private Menu menu;
	private Help help;
	private About about;
	public static AudioPlayer music;
	
	Random rand = new Random();
	
	public static int LEVEL = 1;
	
	public static enum STATE {
		
		MENU,
		GAME,
		HELP,
		ABOUT;
	};
	
	public static STATE State = STATE.MENU;
	
	@SuppressWarnings("static-access")
	private void init() throws InterruptedException {
		
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new Texture();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/level1.png"); // loading the level
		fire = loader.loadImage("/background_fire1.png"); // loading the backgrounds
		//skeleton = loader.loadImage("/skeleton_background.png"); // loading background skeletons
		background = loader.loadImage("/castle_background.png");
		colona = loader.loadImage("/colona1.png");
		coins = loader.loadImage("/coins.png");
		
		cam = new Camera(0, 0);
		
		handler = new Handler(cam);
		 
		handler.LoadImageLevel(level);
		
		menu = new Menu();
		help = new Help();
		about = new About();
		
		music = new AudioPlayer("/Audio/music.wav");
		Thread th = new Thread();
	    th.sleep(1000);
		music.play();
		
		//handler.addObject(new Player(100, 100, handler, ObjectId.Player));
		
		//handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput());
	}
	
	public synchronized void start() {
		
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		
		try {
			
			init();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void tick() {
		
		if(State == STATE.GAME) {
			
			handler.tick();
		}
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			if(handler.object.get(i).getId() == ObjectId.Player) {
				
				cam.tick(handler.object.get(i));
			}
		}
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		Graphics2D g2d = (Graphics2D) g;
		///////////////////////////////////////
		
		//Draw Here
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.translate(cam.getX(), cam.getY()); // begin of cam
		
		
		
		if(State == STATE.GAME) {
			
			if(LEVEL == 1) {
				
				for(int xx = 0; xx < fire.getWidth() * 46; xx += fire.getWidth())
					g.drawImage(fire, xx, 250, this);
				/*
				for(int xx = 0; xx < skeleton.getWidth() * 12; xx += skeleton.getWidth())
					g.drawImage(skeleton, xx, 355, this);
					*/
			} else if(LEVEL == 2) {
				
				for(int xx = 0; xx < fire.getWidth() * 46; xx += fire.getWidth())
					g.drawImage(fire, xx, 250, this);
 			} else if(LEVEL == 3) {
				
				for(int xx = 0; xx < colona.getWidth() * 7; xx += colona.getWidth())
					g.drawImage(colona, xx, 30, this);
			} else if(LEVEL == 4) {
				
				for(int xx = 0; xx < colona.getWidth() * 7; xx += colona.getWidth())
					g.drawImage(colona, xx, 30, this);
			} else if(LEVEL == 5) {
				
				Font fnt = new Font("arial", Font.BOLD, 50);
				g.setFont(fnt);
				g.setColor(Color.WHITE);
				g.drawString("Game Over!!!", 200, 100);
				Font fnt1 = new Font("arial", Font.BOLD, 50);
				g.setFont(fnt1);
				g.setColor(Color.WHITE);
				g.drawString("Score : " + Player.sum, 200, 200);
			}
			
			handler.render(g);
		} else if(State == STATE.MENU) {
			
			g.drawImage(background, -277, -90, this);
			menu.render(g);
		} else if(State == STATE.HELP) {
			
			help.render(g);
		} else if(State == STATE.ABOUT) {
			
			about.render(g);
		}
		
		g2d.translate(-cam.getX(), -cam.getY()); // end of cam
		
		//////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	public static Texture getInstance() {
		
		return tex;
	}
	
	public static void main(String args[]) {
		
		new Window(800, 600, "The Great Adventure 2D", new Game());
	}
}
