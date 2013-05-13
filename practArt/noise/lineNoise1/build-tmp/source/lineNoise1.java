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

public class lineNoise1 extends PApplet {

NoiseyLine [] noises = new NoiseyLine[4];

public void setup(){
	size(1000, 200);
	frameRate(10);
	smooth();
	for (int i=0; i<noises.length; i++){
		noises[i] = new NoiseyLine(50,width-50, (int)random(height),(int)random(1,20),(int)random(1,50));
	}

	// NoiseyLine one = new NoiseyLine(50,800, height/2, 50, 10);
}

public void draw(){
	background(200, 200, 200);
	stroke(111);
	strokeWeight(4);
	noises[0].drawNoiseyLine();
		stroke(11);
	strokeWeight(3);
	noises[1].drawNoiseyLine();
		stroke(181);
	strokeWeight(2);
	noises[3].drawNoiseyLine();
}

class NoiseyLine{
	int step, vert, start, end, tall, x;
	float lastX, lastY;

	NoiseyLine(int xStart, int xEnd, int why, int talll, int steps){
		step = steps;
		lastX = -999;
		lastY = -999;
		vert = why;
		start = xStart;
		end = xEnd;
		tall = talll;
	}

	public void drawNoiseyLine(){
		for ( x = start; x <= end; x+=step){
			int y = vert + (int)random(-tall,tall);

			if (lastX> -999){
				line(x, y, lastX, lastY);
			}
			
			lastX = x;
			lastY = y;
		}

			if ( x >=end){
				x = start;
				lastX = -999;
				lastY = -999;
			}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "lineNoise1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
