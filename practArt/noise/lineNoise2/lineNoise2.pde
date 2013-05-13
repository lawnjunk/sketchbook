	size(1000, 200);
	int step = 15;
	float lastX =-999;
	float lastY =-999;
	float y = height/2;
	int borderX = 20;
	int borderY;
	int x = borderX;
	
	strokeWeight(5);
	stroke(0, 30);
	for(x= borderX; x<=width-borderX; x+= step){
		y = 20 + (noise(random(10))*20);

		
		if (lastX>-999){
			line(x, y, lastX, lastY);		
		}

		lastX = x;
		lastY = y;
		
	}