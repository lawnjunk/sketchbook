// THIS IS THE MAZZZE PROGRAM
//
//


int tileCount = 30;

void setup(){
size(displayWidth, displayHeight);
smooth();	
frameRate(6);
background(0);
}

boolean sketchFullScreen(){
	return true;
}

void draw(){
	background(0);
	strokeCap(ROUND);
	
	tileCount = mouseX/100;

	for (int gridY = 0; gridY<tileCount; gridY++){
		for (int gridX = 0; gridX<tileCount; gridX++){
			stroke(255);
			int posX = width/tileCount*gridX;
			int posY = width/tileCount*gridY;
			int toggle = (int) random(0,2);

			if(toggle == 0){
				strokeWeight(30);
				line(posX,posY,posX+height/tileCount,posY+height/tileCount);
			} 

			if (toggle == 1){
				strokeWeight(30);
				line(posX,posY+width/tileCount,posX+width/tileCount,posY);
			}


		}
	}	
}