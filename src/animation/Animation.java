package animation;

import processing.core.*;

public class Animation extends PApplet{
	
	
	private static final long serialVersionUID = 1L;
	private PImage viking[] = new PImage[4], wave[] = new PImage[3], boat = new PImage();
	private PVector mainPos = new PVector(100, 0), wavePos[] = new PVector[4], boatPos = new PVector(-400,260);
	private PVector indPos[] = new PVector[4], offset[] = new PVector[4], waveOffset[] = new PVector[3], boatOffset = new PVector(0,0);
	private int count = 0, count2 = 0, count3 = 0;
	private boolean forw;
	private PFont f = new PFont();
	
	public static void main(String args[]){
		PApplet.main(new String[] {Animation.class.getName()});
	}
	
	public void setup(){
		viking[0] = loadImage("res/body.png");
		viking[1] = loadImage("res/arm1.png");
		viking[2] = loadImage("res/arm2.png");
		viking[3] = loadImage("res/head.png");
		wave[0] = loadImage("res/waves.png");
		wave[1] = loadImage("res/waves.png");
		boat = loadImage("res/boat.png");
		indPos[0] = new PVector(0, 0);
		indPos[1] = new PVector(90, 30);
		indPos[2] = new PVector(-30, 30);
		indPos[3] = new PVector(20, -30);
		offset[0] = new PVector(0, 0);
		offset[1] = new PVector(0, 0);
		offset[2] = new PVector(0, 0);
		offset[3] = new PVector(0, 0);
		wavePos[0] = new PVector(-30, 560);
		wavePos[1] = new PVector(30, 530);
		waveOffset[0] = new PVector(0, 0);
		waveOffset[1] = new PVector(0, 0);

		//indPos[1] =;
		//indPos[2] =;
		//indPos[3] =;
		size(1200, 720);
		
		f = createFont("Arial", 64, true);
		this.frameRate(60);
		
	}
	

	
	public void draw(){
		
		
		/*
		  noStroke();

		  stroke(0);
		  for(int i = 20; i < 720; i = i + 20){
			  line(i, 0, i, 480);
		  }
		  for(int i = 20; i < 4800; i = i + 20){
			  line(0, i, 720, i);
		  }
		  
		  stroke(255, 0, 0);
		  pushMatrix();
		  translate(50, 50);
		  for(int i = 20; i < 720; i = i + 20){
			  line(i, 0, i, 480);
		  }
		  for(int i = 20; i < 4800; i = i + 20){
			  line(0, i, 720, i);
		  }
		  popMatrix();
		  */
		
		
		
		this.background(255);
		/*
		stroke(0);
		  for(int i = 20; i < 720; i = i + 20){
			  line(i, 0, i, 480);
		  }
		  for(int i = 20; i < 4800; i = i + 20){
			  line(0, i, 720, i);
		  }
		  
		  
		this.pushMatrix();
		translate(mainPos.x, mainPos.y);
		stroke(255, 0, 0);
		for(int i = 0; i < 720; i = i + 20){
			  line(i, 0, i, 480);
		}
		for(int i = 0; i < 480; i = i + 20){
			 line(0, i, 720, i);
		}
		*/
		
		this.pushMatrix();
		translate(wavePos[1].x, wavePos[1].y);
		tint(170, 180);
		image(wave[0], waveOffset[1].x, waveOffset[1].y, 600, 200);
		image(wave[0], waveOffset[1].x - 600, waveOffset[1].y - 10, 600, 200);
		image(wave[0], waveOffset[1].x + 600, waveOffset[1].y, 600, 200);
		
		this.noTint();
		this.popMatrix();
		
		this.pushMatrix();
		translate(boatPos.x + 40, boatPos.y + 240 + boatOffset.y);

		translate(indPos[1].x, indPos[1].y);
		if(frameCount % 1 == 0){			
			count3++;
		}
		rotate((float) Math.toRadians(count3 * 7));
		image(viking[1], offset[1].x, offset[1].y);
		popMatrix();
		
		this.pushMatrix();
		translate(boatPos.x + 40, boatPos.y + 240 + boatOffset.y);
		

		translate(indPos[2].x + 60, indPos[2].y);
		rotate((float) Math.toRadians(-count3 * 7));
		translate(-60 , 0);
		image(viking[2], 0, 0);
		
		this.popMatrix();
		this.pushMatrix();
		translate(boatPos.x + 40, boatPos.y + 240 + boatOffset.y);

		image(viking[0], indPos[0].x, indPos[0].y);
		
		translate(indPos[3].x, indPos[3].y);
		image(viking[3], offset[3].x, offset[3].y);
		
		
		this.popMatrix();
		
		
		
		
		textAlign(CENTER, CENTER);
		fill(0);
		textFont(f, 50);
		text("JAKE THE VIKING", 300, 100);
		
		pushMatrix();
		translate(boatPos.x, boatPos.y);
		scale(.8f);
		image(boat, boatOffset.x, boatOffset.y);
		this.popMatrix();
		
		this.pushMatrix();
		translate(wavePos[0].x, wavePos[0].y);
		image(wave[0], waveOffset[0].x, waveOffset[0].y, 1300, 300);
		image(wave[0], waveOffset[0].x + 1300, waveOffset[0].y, 1300, 300);
		this.popMatrix();
		
		
		
		
		
		if(frameCount % 1 == 0){
			mainPos.y = (float) Math.abs((250 + (60 * (Math.sin(Math.toRadians(count * 2)))))); 
			offset[3].x = (float) (20 * Math.cos(Math.toRadians(5 * count)));
			offset[3].y = (float) (20 * Math.sin(Math.toRadians(5 * count)));
			
			waveOffset[0] = getPos(count * 3);
			waveOffset[0].x = waveOffset[0].x * 20;
			waveOffset[0].y = waveOffset[0].y * 20;
			boatOffset.y = waveOffset[0].y;
			
			waveOffset[1] = getPos((count * 3) + 180);
			waveOffset[1].x = waveOffset[1].x * 10;
			waveOffset[1].y = waveOffset[1].y * 10;
			
			count++;
			if(count == 360)
				count = 0;
			mainPos.x ++;
			boatPos.x++;
			
			if(forw){
				//offset[3].y++;
				//indPos[1].y--;
				//indPos[2].y--;
				count2++;
				
			}
			if(!forw){
				//offset[3].y--;
				//indPos[1].y++;
				//indPos[2].y++;
				count2--;
				
			}
			if(count2 >= 10){
				forw = false;
			}
			if(count2 <= 0){
				forw = true;
			}
			
			
		//	System.out.println(count2);
			
			//System.out.println(.5 - (float) ( Math.abs(Math.sin(Math.toRadians(count)))));
		}
		if(mainPos.x == 1200)
			mainPos.x = 10;
		
		if(boatPos.x == 1200)
			boatPos.x = -boat.width;
	}
	
	private PVector getPos(int degrees){
		degrees = degrees % 360;
		PVector out = new PVector(0, 0);
		
		if(degrees <= 360 && degrees >= 0){
			 out.x = (float) Math.cos(Math.toRadians(degrees - 180));
			 out.y =  (float) Math.sin(Math.toRadians(degrees - 180));
			
		}
		else if(degrees > 180 && degrees < 360){
			 out.x = (float) (1/(degrees - 180) * 180);
			 
			 out.y = 0;
			
		}
		
		return out;
		
	}

}
