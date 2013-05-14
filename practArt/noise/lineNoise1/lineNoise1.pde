NoiseyLine [] noises = new NoiseyLine[1000];
color[] noisescolors = new color[noises.length];
int z = 0;
int b = 0;
int ha = 0;
int add;

void setup(){
	size(displayWidth, 300,OPENGL);
	frameRate(10);
	smooth();
	strokeCap(PROJECT);

	for (int i=0; i<noises.length; i++){
		//new noiseyline(start, end, y, tall, steps)
		noisescolors[i] =  color((int)random(100)+100);
		noises[i] = new NoiseyLine(width - 2*(int)random(width),width +100, (int)random(1,height),(int)random(1,20),(int)random(30,1));
	}

	// NoiseyLine one = new NoiseyLine(50,800, height/2, 50, 10);
}

void draw(){
	background(z);

	if(z ==0){
		add = 1;
	} else if (z == 255) {
		add = -1;
	}

	z+= add;
	
	for(int i=0; i<noises.length; i++){
		stroke(noisescolors[i]);
		strokeWeight(random(1,3));
		noises[i].drawRunner();

	}
	for (int i = 0; i<10; i++){
		strokeCap(ROUND);
		strokeWeight(10);
		stroke(0);
		noises[i].drawNoiseyLine();
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

		float y = vert + noise(random(-tall,tall))*30;
		if(lastX> -999){
			line(x, y, lastX, lastY);
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