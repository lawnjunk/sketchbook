	int step = 10;
	float lastX =-999;
	float lastY =-999;
	float y = height/2;
	int borderX = 20;
	int borderY;
	int x = borderX;


void setup(){
	
	size(1000, 200);
	smooth();
	frameRate(10);
	borderY= 90;

}

void draw(){
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







