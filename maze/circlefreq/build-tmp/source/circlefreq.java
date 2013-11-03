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

public class circlefreq extends PApplet {

int r=0;
int nr =0;
float lastX = 0.0f;
float lastY = 0.0f;

public void setup(){
  size(displayWidth, displayHeight);
  smooth();
  background(0);
  translate(width/2, height/2);  
  // frameRate(15);

}

public boolean sketchFullScreen() {
  return true;
}

public void draw(){
  pushMatrix();
  pushMatrix();
  translate(width/2, height/2);
  rotate(r%360);
  r++;

  background(0);  

  int circleResolution = (int) map(mouseY, 0, height, 2, 100);
  float radius = mouseX + 0.5f;
  float angle = TWO_PI/circleResolution;

  strokeWeight(mouseX/20);

  for (int i = 0; i<=circleResolution; i++){
    noFill();
    stroke(random(100, 255));
    float x = cos(angle*i)*radius;
    float y = sin(angle*i)*radius;
    line(lastX,lastY,lastY,lastX);
    lastX = y;
    lastY = x;

  }

  popMatrix();
  translate(width/2, height/2);
  rotate(radians(300-(r%360)));

  for (int i = 0; i<=circleResolution; i++){
    noFill();
    stroke(255);
    float x = cos(angle*i)*radius;
    float y = sin(angle*i)*radius;
    line(0,0,lastY,lastX);
    lastX = y;
    lastY = x;

  }
  popMatrix();
  translate(width/2, height/2);
  rotate(radians(r%360));

  for (int i = 0; i<=circleResolution; i++){
    noFill();
    stroke(255);
    float x = cos(angle*i)*radius;
    float y = sin(angle*i)*radius;
    line(y,x,y,x);
    lastX = y;
    lastY = x;

  }

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "circlefreq" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
