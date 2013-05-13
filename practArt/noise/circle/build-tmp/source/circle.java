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

public class circle extends PApplet {

float xstep = 1;
float lastx = -999;
float lasty = -999;
float angle = 1;
float y = 50;
int x = 0;

public void setup(){
size(1000,1000);
frameRate(30);

strokeWeight(1);
stroke(0);
}

public void draw(){
	background(0);
	stroke(44,170,200);
	thatthing2(800,10,13,60);
		if ( x >=width ){
		x = 0;
		lastx = -999;
		lasty = -999;
	}
	translate(0, 3, 0);
	strokeWeight(10);
	stroke(255,23,200);
	thatthing(600,6,1000,100);
		if ( x >=width ){
		x = 0;
		lastx = -999;
		lasty = -999;
	}

	translate(0, 500);
	stroke(200);
	thatthing(1000 + (int)sin(angle%8000)* 10000,7,80, 1);
	if ( x >=width ){
		x = 0;
		lastx = -999;
		lasty = -999;
	}


	// noStroke();
	// fill(0);
	// ellipse(width/2 + random(-10,10), height + random(-10,10), y, y);
	noStroke();
	fill(0);
	ellipse(width/2 , height - 1000, 500, 500);
	translate(0, -1000);

}

public void thatthing(int one, int two, int three,int four){
	for( x=0; x<=width; x+= xstep){
	float rad =  radians(angle);
	y = 1000+  -(noise(x/four)* one )+ (sin(rad* two)* three);
	if(lastx>= -999){
		ellipse(x, y, random (10), random(10));
		rect(x, y, random(10), random(10));
		rect(lasty, lastx, random(11), random(11));
		// line(x, y, lastx, lastx);
	}

	lastx = x;
	lasty = y;
	angle++;

}
}

public void thatthing2(int one, int two, int three,int four){
	for( x=0; x<=width; x+= xstep){
	float rad =  radians(angle);
	y = 1000+  -(noise(x/four)* one )+ (sin(rad* two)* three);
	if(lastx>= -999){
		ellipse(x, y, random (10), random(10));
		rect(x, y, random(10), random(10));
		rect(lasty, lastx, random(11), random(11));
		line(x, y, lastx, lastx);
	}

	lastx = x;
	lasty = y;
	angle++;


}


}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "circle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
