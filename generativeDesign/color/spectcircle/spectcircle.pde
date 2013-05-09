int segmentCount = 360;
int radius = 100;

void setup(){
	size(700,700);
	background(0);
	smooth();
	noStroke();
	colorMode(HSB,360,width,height);
	int radius = width/4;
}

void draw(){

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

	void keyReleased(){
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