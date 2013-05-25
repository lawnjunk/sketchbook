PImage img;
color [] colors;

void setup(){
	size(displayWidth,displayHeight);
	smooth();
	background(0);
	img = loadImage("oldman.jpg");
	noCursor();
}

boolean sketchFullScreen() {
  return true;
}

void draw(){


	image(img, 0, 0, width, height);
	int tileCount = width/max(mouseX, 10);
	float rectSize = width/(float)tileCount;

	int i=0;
	colors = new color[img.width*img.height];
	for (int gridY = 0; gridY<img.height; gridY++){
		for (int gridX = 0; gridX<img.width; gridX++){
			int px = (int)random(gridX);
			int py = (int)random(gridY);
			colors[i] = img.get(px,py);
			i++;
		}
	}

	i = 0;

	for (int gridY = 0; gridY<tileCount; gridY++){
		for (int gridX = 0; gridX<tileCount; gridX++){
			fill(colors[i]);
			rect(gridX*rectSize, gridY*rectSize, rectSize, rectSize);
			i++;

		}
	}

	i=0;
	for (int gridY = 0; gridY<tileCount; gridY++){
		for (int gridX = 0; gridX<tileCount; gridX++){
			fill(colors[i]);
			rect(gridX*rectSize, gridY*rectSize, rectSize, rectSize);
			i++;
			rotate(random(i)%360);
		}
	}

}