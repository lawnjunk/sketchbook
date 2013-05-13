NoiseyLine [] noises = new NoiseyLine[4];

void setup(){
	size(1000, 200);
	frameRate(10);
	smooth();
	for (int i=0; i<noises.length; i++){
		noises[i] = new NoiseyLine(50,width-50, (int)random(height),(int)random(1,20),(int)random(1,50));
	}

	// NoiseyLine one = new NoiseyLine(50,800, height/2, 50, 10);
}

void draw(){
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

	void drawNoiseyLine(){
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