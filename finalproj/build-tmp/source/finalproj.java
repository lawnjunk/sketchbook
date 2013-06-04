import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import de.looksgood.ani.*; 
import de.looksgood.ani.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class finalproj extends PApplet {


PImage darkleft;
PImage darkright;

CloudOrbs cloudbubble;
DeepBackground mybg;
ShapeSection shaper;

int fadeblack = 0;
int s;

int splitX1;
int splitX2;
int splitWidth1;
int splitWidth2;
Ani x1;
Ani x2;

float prob = 0.9f;
int crazyX = 0;
int crazyY = 0;
int granalpha = 0;
int darkleftscroll;
int tryitX = 0;
int tryitY = 0;
int whichpart = 1;
int hexspeed=10;
int lastrandobg = 1;
int lastrandoshape =4;
int tint1 = 80;
int tint2 = 255;

public void setup(){
	size(displayWidth, displayHeight);
	smooth();

	cloudbubble = new CloudOrbs();
	mybg = new DeepBackground();
	shaper = new ShapeSection(); 

	noCursor();

	darkleft = loadImage("backgrounds/darkleft.png");
	darkright = loadImage("backgrounds/darkright.png");

	splitX1 = width/2;
	splitX2 = width/2;
	splitWidth1 = splitX1 + 200;
	splitWidth2 = splitX2 - 200;
	
	darkleftscroll = 0-darkleft.width;

	Ani.init(this);
	
}

public boolean sketchFullScreen(){
	return true;
}


public void draw(){

	if (whichpart ==1){
		tint(200);
		mybg.imageBackground(0);
		cloudbubble.randomDraw(splitX1, height/2);
	} else if (whichpart == 2) {
		Ani x1 = new Ani(this, 1.5f, "splitX1", splitWidth1, Ani.ELASTIC_OUT);
		Ani x2 = new Ani(this, 1.5f, "splitX2", splitWidth2, Ani.ELASTIC_OUT );

		tint(200);
		mybg.imageBackground(0);
		cloudbubble.randomDraw(splitX1 + (int)random(-crazyY,crazyY) , height/2 +  (int)random(-crazyY,crazyY) );
		cloudbubble.randomDraw(splitX2 +  (int)random(-crazyY,crazyY) , height/2 +  (int)random(-crazyY,crazyY) );
		
		if (crazyY < 100){
			crazyY++;
		}

	} else if (whichpart == 3) {
		tint(200);
		mybg.imageBackground(0);
		cloudbubble.massOrbs(width/2, height/2, width/3, height/2, prob);

	} else if (whichpart ==4) {
		if (granalpha<255){
			granalpha++;
		} 

			tint(200);
			mybg.imageBackground(0);
			mybg.granulate(0,granalpha);
			cloudbubble.massOrbs(width/2, height/2, width/3, height/2, prob);
		if (prob > 0.2f){
			prob -= 0.002f;
		}
	} else if (whichpart == 5) {
		granalpha = 4444;

		tint(200);
		mybg.granulate(0,granalpha);
		cloudbubble.massOrbs(width/2, height/2, width/3, height/2, prob);
	} else if (whichpart == 6) {
		if (frameCount% (1+(int)(mouseX/(width/10)))==0){
			tint(tint1);
			mybg.imageBackground(2);
			tint(tint2);
			shaper.grid(3);
		}
	} else if (whichpart == 7) {
		if (frameCount% (1+(int)(mouseX/(width/10)))==0){
			tint(tint1);
			mybg.imageBackground(1);
			tint(tint2);
			shaper.grid(2);
		}
	} else if (whichpart == 8) {
		if (frameCount% (1+(int)(mouseX/(width/10)))==0){
			tint(tint2);
			mybg.imageBackground(3);
			tint(tint1);
			shaper.grid(1);
		}
	} else if (whichpart == 9) {
		if (random(0, 1)> 0.7f){
			int z = tint1;
			tint1 = tint2;
			tint2 = z;
			lastrandobg = (int)ceil(random(4));
			lastrandoshape = (int)ceil(random(3));
		} 

		if (frameCount% (1+(int)(mouseX/(width/10)))==0){
			tint(tint1,tint1);
			mybg.imageBackground(lastrandobg);
			tint(tint2,tint1);
			shaper.grid(lastrandoshape);
		}
	}
 		
	saveFrame("saved/finalproj-####.tif");

	if(fadeblack<255){
		fadeBlack();
	}
}

public void fadeBlack(){
	fadeblack+=2;

	fill(0, 255-fadeblack);
	rect(0,0, width, height);

}

public void keyPressed(){
	if (key == '1'){
		whichpart = 1;
	} else if (key == '2') {
		whichpart = 2;
	} else if (key == '3') {
		whichpart = 3;
		println("part3");
	} else if (key == '4') {
		whichpart = 4;
	} else if (key == '5') {
		whichpart = 5;
	} else if (key == '6') {
		whichpart = 6;
	} else if (key == '7') {
		whichpart = 7;
	} else if (key == '8' ) {
		whichpart = 8;
	} else if (key == '9') {
		whichpart = 9;
	} else if (key == '0') {
		whichpart = 0; 
	}
}






class CloudOrbs{
	Orb [] allOrbs = new Orb [16];
	// Ani.init(this);

	CloudOrbs(){
		fillOrbs();
	}

	public void randomDraw(int x, int y){
		tint(random(150,255), random(150,255));
		allOrbs[(int)random(allOrbs.length)].drawOrb(x,y);
	}

	public void massOrbs(int x, int y, int massWidth, int massHeight, float prob) {
		frameRate(15);
		int xpos = x - (massWidth/2);
		int ypos = y - (massHeight/2);
		int widthh = xpos + massWidth;
		int heightt = ypos + massHeight;
		for (int gridy = ypos; gridy<heightt; gridy+=(allOrbs[gridy%allOrbs.length].getHeight()/3)){
			for (int gridX = xpos; gridX<widthh; gridX+=(allOrbs[gridy%allOrbs.length].getWidth()/3)){
				if (random(0.0f,1.0f) > prob){
					int chooseAnOrb = (int)random(allOrbs.length);
					tint(random(255), random(19,255));
					allOrbs[chooseAnOrb].drawOrb(gridX,gridy);
				}
			}
		}
	}

	private void fillOrbs(){
		for (int i = 0; i<allOrbs.length; i++){
			allOrbs[i] = new Orb("cloudOrb" + i);
		}
	}

	// public void splitTwo(boolean go, int xpos, int ypos, int space){
	// 	float x1;
	// 	float x2;
	// 	float y1 = ypos;
	// 	float y2 = ypos;

	// 	if (!go){
	// 		x1 = xpos;
	// 		x2 = xpos;
	// 		this.randomDraw(x1, y1);
	// 	} else {
	// 		Ani.to(this, 1.5, "x1", x1+space);
	// 		Ani.to(this, 1.3, "x2", x2+space);
	// 		randomDraw(x1, y1);
	// 		randomDraw(x2, y2);
	// 	}

	// }



}
class DeepBackground{
	PImage[] bgFotos;
	PImage[] bgStripes;

	DeepBackground(){
		bgFotos = new PImage[5];
		for (int i = 0; i<bgFotos.length; i++){
			bgFotos[i] = loadImage("backgrounds/bgFoto" + i + ".png");			

		}

	}

	public void imageBackground(int bgnum) {
		image(bgFotos[bgnum], 0, 0);	
	}

	public void imageBackground(int bgnum, int xpos, int ypos, int wide, int tall) {
		image(bgFotos[bgnum], xpos, ypos, wide, tall);
	}

	public void granulate(int bgnum, int thealpha) {
				// image(bgFotos[bgnum], 0, 0, width, height);
				// loadPixels();
		for (int gridy = 0; gridy<height; gridy+= 13){
			for (int gridX = 0; gridX<width; gridX+= 13){
				// bgFotos[bgnum].loadPixels();
				// color grainCol = pixels[gridy*gridy];
				// imageBackground(bgnum);
				int grainCol = bgFotos[bgnum].get((int)random(gridX),(int)random(gridy));
				noStroke();
				fill(grainCol, thealpha);
				rect(gridX, gridy, 13, 13);

				// println(grainCol);
				// set(gridX, gridy, grainCol);
			}
		}
		
	}

	public void blackFade(int fade){
		background(0,255-fade);
	}

	



 }

class ShapeSection{
	int startX;
	int endX;
	int startY;
	int endY;
	int gridSizeX;
	int gridSizeY;
	int allowd;
	int allowdY;

	PImage[] hexa;
	PImage[] circles;
	PImage[] square;
	PImage[] trap;
	PImage[] trapu;

	ShapeSection(){
		hexa = new PImage[5];
		for (int i = 0; i<hexa.length; i++){
			 hexa[i] = loadImage("hex/hex" + i + ".png");
		}

		circles = new PImage[9];
		for (int i = 0; i<circles.length; i++){
			 circles[i] = loadImage("circles/circle" + i + ".png");
		}

		square = new PImage[10];
		for (int i = 0; i<square.length; i++){
			 square[i] = loadImage("squares/square" + i + ".png");
		}

		trap = new PImage[5];
		trapu = new PImage[5];
		for (int i = 0; i<trap.length; i++){
			trap[i] = loadImage("trap/trap" + i + ".png");
			trapu[i] = loadImage("trap/trapu" + i + ".png");
		}
	
	}

	public void grid(int shape){
		switch (shape){
			case 1:
				gridSizeX = width/10;
				gridSizeY = height/5;

				startX = 150;
				endX = (width - square[1].width - 30);
				startY = 50;
				endY = (height-square[shape].height);

				for (int gridY = startY; gridY<endY; gridY+= gridSizeY){
					for (int gridX = startX; gridX<endX; gridX+= gridSizeX){
						image(square[(int)random(100)%square.length], gridX, gridY);
					}
				}

				break;

			case 2:
				gridSizeX = width/7;
				gridSizeY = height/6;

				startX = 200;
				endX = (width - trap[1].width - 50);
				startY = 150;
				endY = (height-100-trap[1].height);

				for (int gridY = startY; gridY<endY; gridY+= gridSizeY){
					for (int gridX = startX; gridX<endX; gridX+= gridSizeX){
						float choose = random(0, 1);
						if (choose>0.5f){
							image(trap[(int)random(100)%trap.length], gridX, gridY);
						} else {
							image(trapu[(int)random(	100)%trapu.length], gridX, gridY);	
						}
					}
				}
				break ;
			case 3:
				gridSizeX = width/5;
				gridSizeY = height/3;

				startX = 250;
				endX = (width - 100 - hexa[1].width);
				startY = 225;
				endY = (height - 100 - hexa[1].height);

				for (int gridY = startY; gridY<endY; gridY+= gridSizeY){
					for (int gridX = startX; gridX<endX; gridX+= gridSizeX){
						image(hexa[(int)random(100)%hexa.length], gridX, gridY);
					}
				}





				// endX = (width - trap[1].


			default :
				
			break;	
		}
	}


	public void gridal(int shape, int allow, int allowy){
		switch (shape){
			case 1:
				gridSizeX = width/10;
				gridSizeY = height/5;
				allowd= allow * gridSizeX;
				allowdY = allowy * gridSizeY;
				startX = 150;
				endX = allowd%(width - square[1].height - 30);
				startY = 50;
				endY = allowdY%(height-square[shape].width);

				println(allowd);

			for (int gridY = startY; gridY<endY; gridY+= gridSizeY){
				for (int gridX = startX; gridX<endX; gridX+= gridSizeX){
					image(square[(int)random(100)%square.length], gridX, gridY);
				}
			}
				break;
			default :
				
			break;	
		}


	}


}
class Orb{
	PImage orb;
	int x;
	int y;
	int orbWidth;
	int orbHeight;

	Orb(String name){
		orb =loadImage("cloudOrbs/" + name + ".png");
		orbWidth = orb.width;
		orbHeight = orb.height;
		x = width/2 - (orbWidth/2);
		y = height/2 - (orbHeight/2);


	}

	Orb(String name, int xpos, int ypos){
		orb =loadImage("cloudOrbs/" + name + ".png");
		int x = xpos;
		int y = ypos;
	}

	public void drawOrb(){
		image(orb, x, y);
		
	}


	public void drawOrb(int xpos, int ypos){
		this.x = xpos - orbWidth/2;
		this.y = ypos - orbHeight/2;

		image(orb, x, y);
		
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public int getWidth(){
		return this.orbWidth;
	}

	public int getHeight(){
		return this.orbHeight;
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "finalproj" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
