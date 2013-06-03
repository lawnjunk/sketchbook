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

public void setup(){
	size(displayWidth, displayHeight);
	smooth();
	cloudbubble = new CloudOrbs();
	mybg = new DeepBackground();
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

	// black fade to photo
	if(fadeblack<255){
		fadeBlack();
		s = frameCount;
		mybg.imageBackground(0);
	}

	if(frameCount - s < 10*frameRate  ){
		tint(200);
		mybg.imageBackground(0);
		cloudbubble.randomDraw(splitX1, height/2);
	} else if (frameCount - s < 20*frameRate)  {
		Ani x1 = new Ani(this, 1.5f, "splitX1", splitWidth1, Ani.ELASTIC_OUT);
		Ani x2 = new Ani(this, 1.5f, "splitX2", splitWidth2, Ani.ELASTIC_OUT );

		tint(200);
		mybg.imageBackground(0);
		cloudbubble.randomDraw(splitX1 + (int)random(-crazyY,crazyY) , height/2 +  (int)random(-crazyY,crazyY) );
		cloudbubble.randomDraw(splitX2 +  (int)random(-crazyY,crazyY) , height/2 +  (int)random(-crazyY,crazyY) );
		
		if (crazyY < 100){
			crazyY++;
		}

	} else {
		

		if (granalpha<255){
			tint(200);
			mybg.imageBackground(0);
			mybg.granulate(0,granalpha);
			cloudbubble.massOrbs(width/2, height/2, width/3, height/2, prob);
			granalpha++;

		} else {

			granalpha = 4444;

			tint(200);
			mybg.granulate(0,granalpha);
			cloudbubble.massOrbs(width/2, height/2, width/3, height/2, prob);
		}

		if (prob > 0.2f){
			prob -= 0.002f;
		}
 }

 	if(darkleftscroll < width/2){
 		tint(255);
 		image(darkleft, darkleftscroll+=10, 0);
 		image(darkright,width + (width - -darkleftscroll), 0);

 		if (darkleftscroll >= 0){
 			fill(0);
 			rect(0, 0, darkleftscroll, height);
 			rect(width,0,width - -darkleftscroll, height);
 		}
 	}
	// tint(200);
	// mybg.granulate(0);
	// if (frameCount%20 == 0){
	// mybg.imageBackground((int) random(5));

	// cloudbubble.massOrbs(width/2, height/2, width/3, height/2);
	
	// black fade to photo
	// if(fadeblack<255){
	// 	fadeBlack();
	// }
}

public void fadeBlack(){
	fadeblack+=2;

	fill(0, 255-fadeblack);
	rect(0,0, width, height);

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
