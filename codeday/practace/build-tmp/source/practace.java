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

public class practace extends PApplet {

int tileCount = 30;

public void setup(){
size(displayWidth, displayHeight);
smooth();	
frameRate(6);
background(0);
}

public boolean sketchFullScreen(){
	return true;
}

public void draw(){
	background(0);
	strokeCap(ROUND);
	
	tileCount = mouseX/100;

	for (int gridY = 0; gridY<tileCount; gridY++){
		for (int gridX = 0; gridX<tileCount; gridX++){
			stroke(255);
			int posX = width/tileCount*gridX;
			int posY = width/tileCount*gridY;
			int toggle = (int) random(0,2);

			if(toggle == 0){
				strokeWeight(30);
				line(posX,posY,posX+height/tileCount,posY+height/tileCount);
			} 

			if (toggle == 1){
				strokeWeight(30);
				line(posX,posY+width/tileCount,posX+width/tileCount,posY);
			}


		}
	}	
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "practace" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
