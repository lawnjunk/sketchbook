import processing.video.*;


PImage back ;
Movie bk;

NoiseyLine [] noises = new NoiseyLine[100];
color[] noisescolors = new color[noises.length];
int z = 0;
int b = 0;
int ha = 0;
int add;
int addd;

int create = 0;

void setup(){
	size(displayWidth, displayHeight,OPENGL);
	frameRate(20);
	smooth();
	strokeCap(PROJECT);

	for (int i=0; i<noises.length; i++){
		//new noiseyline(start, end, y, tall, steps)
		noisescolors[i] =  color((int)random(100)+100);
		// noises[i] = new NoiseyLine(width - 2*(int)random(width),width +100, (int)(height/4+ random(1,height/2)),(int)random(1,20),(int)random(7,14));
		noises[i] = new NoiseyLine((int)random(width) - 400,width, (int)(height/4+ random(1,height/2)),(int)random(1,20),(int)random(2,17));
	
	}



	bk = new Movie(this, "garbage.mov");
	bk.loop();
    bk.speed(0.5);
	back = loadImage("background.jpg");
	// NoiseyLine one = new NoiseyLine(50,800, height/2, 50, 10);
}

// Called every time a new frame is available to read
void movieEvent(Movie m) {
  m.read();
}


void draw(){
	// background(z);

	bk.jump(random(bk.duration()));
	image(back, 0, 0, width, height);

	if(z ==0){
		add = 1;
	} else if (z == 200) {
		add = -1;
	}

	if(frameCount%5 == 0){	
	z+= add;
	}
	
	for(int i=0; i<create; i++){
		stroke(noisescolors[i]);
		strokeCap(ROUND);
		strokeWeight(random(1,13));
		noises[i].drawRunner();

	}
	for (int i = 0; i<10; i++){

		strokeCap(ROUND);
		strokeWeight(6);
		// stroke(255-z, 50+ z/4, 60 + Z/2);
		stroke(0, 0, 0);
		noises[(int)random(noises.length)].drawNoiseyLine();
	}

	tint(50, 100);
	create += addd;

	if (create == 0){
		addd = 1;
	} else if (create == noises.length) {
		addd = -1;
	}


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

	void drawNoiseyLine(){
		for ( x = start; x <= end; x+=step){
			float y = vert + random(-tall,tall);

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

	void drawRunner(){

		float y = vert + noise(random(-tall,tall))*random(1,30);
		if(lastX> -999){

			line(x, y, lastX, lastY);
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