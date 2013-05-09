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

public class spectcircle extends PApplet {

int segmentCount = 360;
int radius = 100;

public void setup(){
	size(700,700);
	background(0);
	smooth();
	noStroke();
	colorMode(HSB,360,width,height);
	int radius = width/4;
}

public void draw(){

	radius = width/2;
	colorMode(HSB,360,width,height);
	background(0);

	float angleStep = 360/segmentCount;

	beginShape(TRIANGLE_FAN);
	vertex(height/2,width/2);
	for (int angle = 0; angle<=360; angle+=angleStep){
		float vx = width/2 + cos(radians(angle))*radius;
		float vy = height/2 + sin(radians(angle))*radius;
		vertex(vx,vy);
		fill(angle,mouseX,mouseY);
	}
	endShape();
}

	public void keyReleased(){
		switch (key){
			case'1':
				segmentCount = 360;
				break ;
			case '2' :
				segmentCount = 100;
			break;	
			case '3' :
				segmentCount =24;				
			break;	
			case '4' :
				segmentCount = 12;
			break;	
			case '5' :
				segmentCount = 6 ;
			break;	
		}
	}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "spectcircle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
