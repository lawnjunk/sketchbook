import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class spectrumgrid extends PApplet {

int stepX;
int stepY;

public void setup(){
	size(800, 400);
	background(0);
	smooth();
	noStroke();
}

public void draw(){
	colorMode(HSB, width, height, 100);
	
	frameRate(10);

	stepX = mouseX+2;
	stepY = mouseY+2;


	for (int gridY = 0; gridY<height; gridY+=stepY){
		for (int gridX = 0; gridX<width; gridX+=stepX){

			fill(gridX+(int)random(60), (int)random(width/2), height, (int)random(10));
			for (int bubble = 0; bubble<10; bubble++){
				ellipse(gridX +(int)random(stepX), gridY + (int)random(stepY), 10, 10);

			}
			// rect(gridX, gridY, stepX, stepY);
		}
	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "spectrumgrid" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
