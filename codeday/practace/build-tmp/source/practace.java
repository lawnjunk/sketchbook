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

PImage img;
int [] colors;

public void setup(){
	size(displayWidth,displayHeight);
	smooth();
	background(0);
	img = loadImage("oldman.jpg");
	noCursor();
}

public boolean sketchFullScreen() {
  return true;
}

public void draw(){


	image(img, 0, 0, width, height);
	int tileCount = width/max(mouseX, 10);
	float rectSize = width/(float)tileCount;

	int i=0;
	colors = new int[img.width*img.height];
	for (int gridY = 0; gridY<img.height; gridY++){
		for (int gridX = 0; gridX<img.width; gridX++){
			int px = (int)random(gridX);
			int py = (int)random(gridY);
			colors[i] = img.get(px,py);
			i++;
		}
	}

	i = 0;

	for (int gridY = 0; gridY<tileCount; gridY++){
		for (int gridX = 0; gridX<tileCount; gridX++){
			fill(colors[i]);
			rect(gridX*rectSize, gridY*rectSize, rectSize, rectSize);
			i++;

		}
	}

	i=0;
	for (int gridY = 0; gridY<tileCount; gridY++){
		for (int gridX = 0; gridX<tileCount; gridX++){
			fill(colors[i]);
			rect(gridX*rectSize, gridY*rectSize, rectSize, rectSize);
			i++;
			rotate(random(i)%360);
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
