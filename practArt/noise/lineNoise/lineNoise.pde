	int step = 50;
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
		y +=  random(2,-2);

		
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

}






