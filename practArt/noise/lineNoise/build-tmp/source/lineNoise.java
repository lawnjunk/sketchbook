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

public class lineNoise extends PApplet {

	int step = 10;
	float lastX =-999;
	float lastY =-999;
	float y = height/2;
	int borderX = 20;
	int borderY;
	int x = borderX;


public void setup(){
	
	size(1000, 200);
	smooth();
	frameRate(10);
	borderY= 90;

}

public void draw(){
	background(222, 222, 222);
		strokeWeight(5);
	for(x= borderX; x<=width-borderX; x+= step){
		y = 22 + random(-14,14);
		
		if (lastX>-999){
			line(x, y, lastX, lastY);		
		}

		lastX = x;
		lastY = y;
		
	}
		if (x>=width-borderX){
			x = borderX + 3;
			lastY = -999;
			lastX = -999;
		}

	// borderY+= random(2);
}

// class noiseRun{
// 	int why, x, y, step;
// 	float lastX,lastY;

// 	noiseRun(int x, int why, int tall, int step){
// 		this.x = x;
// 		this.y = why + random(-tall, tall);
// 		this.why = why;
// 		this.step = step;
// 		line(x, y, lastX, lastY);
// 	}

// 	void drawNoise(int y){
// 		x+= this.step;
// 		y = random()

// 		lastX =x;
// 		lastY =y;

// 		line(x, y, x2, y2);

// 	}
// }







  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "lineNoise" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
