import gifAnimation.*;

PImage [] clouds;
String [] cloudnames;
PFont itwalks;
PFont clickme;

boolean intro = true;

int [] cloudLocationX;
int [] cloudLocationY;
int [] cloudSpeed;



Gif walkingLeftLoop;

NoiseyLine [] noises = new NoiseyLine[80];
color[] noisescolors = new color[noises.length];



// float [][] cloudLocation ;//= {{random(width), random(height/2) },{random(width), random(height/2) },{random(width), random(height/2) },{random(width), random(height/2) }};


PImage [] grass;
// Annimation walkLeft, walkRight;
String [] grassNames;
int modd = 0;



java.io.File folder = new java.io.File(dataPath("/Users/dwolfm/Documents/gitz/sketchbook/codeday/finalProj/data/grass"));
 

java.io.FilenameFilter jpgFilter = new java.io.FilenameFilter() {
  boolean accept(File dir, String name) {
    return name.toLowerCase().endsWith(".png");
  }
};



void setup(){

	noCursor();		

	size(displayWidth, displayHeight);
	frameRate(10);


	String[] filenames = folder.list(jpgFilter);
	grass = new PImage[filenames.length];

	for (int i = 0; i < filenames.length; i++) {
		grass[i] = loadImage( "grass/" + filenames[i]);

	
	}

	for (int i=0; i<noises.length; i++){
		//new noiseyline(start, end, y, tall, steps)
		noisescolors[i] =  color((int)random(100)+100,random(255));
		// noises[i] = new NoiseyLine(width - 2*(int)random(width),width +100, (int)(height/4+ random(1,height/2)),(int)random(1,20),(int)random(7,14));
		noises[i] = new NoiseyLine(width/2,width, (int) random(height),(int)random(1,20),(int)random(2,300));
	
	}

	itwalks  = loadFont("AdobeGothicStd-Bold-150.vlw");
	clickme = loadFont("AdobeGothicStd-Bold-48.vlw");

	clouds = new PImage[15];
	cloudnames = new String[clouds.length];
	cloudLocationX = new int[clouds.length];
	cloudLocationY = new int [clouds.length];
	cloudSpeed = new int [clouds.length];

	for (int i = 0; i<clouds.length; i++){
		int why = (i%4)+1;
		cloudnames[i] = "cloud" + why + ".png";
		clouds[i] = loadImage(cloudnames[i]);
		cloudLocationX[i] =  (int) random(width);
		cloudLocationY[i] =  (int)random(height/2);
		cloudSpeed[i] = (int)random(4,20);
		
	}



	walkingLeftLoop = new Gif(this, "RIGHTFOOTS.gif");
	// walkkleft = Gif.getPImages()

	// walkRight = new Annimation("walk/walk", 10);
	// // walkLeft = new Annimation("walkLeft", 20);
	backitup();

}

boolean sketchFullScreen(){
	return true;
	}

void draw(){
	// background(0);

	if(intro == true ){
		backitup();
		textFont(itwalks);
		fill(255);
		text("it walks", 100 , height/4);
		text("on grass", 400 , height/2);

		if(frameCount%10 > 5){
			fill(0);
		} else {
			fill(255);
		}
		textFont(clickme);
		text("click to play", 475 , height - height/4);




	} else {

		
		backitup();

	for (int i = 0; i<clouds.length; i++){
		
		image(clouds[i], width - ((cloudLocationX[i] += cloudSpeed[i]) % (width + 200) ), cloudLocationY[i] );

	}



	for (int i = 0; i<400; i++){
		image(grass[1], random(width), height - random(200));
	}

	for(int i=0; i<noises.length/2; i++){
		stroke(noisescolors[i]);
		strokeCap(ROUND);
		strokeWeight(random(1,13));
		noises[i].drawRunner();

	}

	tint(90+random(100),100);

	// tint(255);
	image(walkingLeftLoop, width/4 , 175);
	image(walkingLeftLoop, width/4 , 175);
	image(walkingLeftLoop, width/4 , 175);
	image(walkingLeftLoop, width/4 , 175);
	image(walkingLeftLoop, width/4 , 175);

	// tint(255);
	for(int i=noises.length/2; i<noises.length; i++){
		stroke(noisescolors[i]);
		strokeCap(ROUND);
		strokeWeight(random(1,13));
		noises[i].drawRunner();

	}

	walkingLeftLoop.play();
	// walkRight.display(width/2, height/2);
	for (int i = 0; i<100; i++){
		image(grass[1], (int)random(width), height - random(height/4));
	}
		
}
}

void backitup(){
	int stepsizeW = width/(int)random(100,2);
	int stepsizeY = height/(int)random(5, 20);
	for (int gridy = 0; gridy<height; gridy+=stepsizeY){
		for (int gridx = 0; gridx<width; gridx+=stepsizeW){
			fill(random(0,20));
			noStroke();
			rect(gridx, gridy, stepsizeW, stepsizeY);
		}
	}

	// modd = (int )random(1,10);

}


void mousePressed(){

	stroke(255);
	strokeWeight(5);
	line(571,279,1126 ,108 + random(300));
	line(571,279,1126 ,108 + random(300));
	line(571,279,1126 ,108 + random(300));
	line(571,279,1126 ,108 + random(300));


	println("MouseX: " + mouseX);
	println("MouseY" + mouseY);

	intro = false;


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
		x = start;
	}

	void drawRunner(){

		float y = vert + noise(random(-tall,tall))*random(1,30);
		if(lastX> -999){

			line(width-x, y, width-lastX, lastY);
			noStroke();
			// ellipse(x+random(-100, 100), y + random(-100, 100), 5, 5);
		}
		lastX = x;
		lastY = y;

		if ( x >=end){
			x = start;
			lastX = -999;
			lastY = -999;
		}

		x+=step;


	}
}