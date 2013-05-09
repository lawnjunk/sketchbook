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

public class hellocolor extends PApplet {

public void setup(){
	size(720, 720);
	// noCursor();
}



// This is a cool prorgram it uses the size wich is twice the size of 360
// (360 equals full range of hsb hue) the ba 
public void draw(){
	colorMode(HSB,360,100,100 );
	rectMode(CENTER);
	noStroke();
	background(mouseY/2, 100, 100);

	fill(360-mouseY, 100, 100);
	rect(360,360, mouseX+1, mouseX+1);
		
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "hellocolor" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
