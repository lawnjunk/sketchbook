class DeepBackground{
	PImage[] bgFotos;
	PImage[] bgStripes;

	DeepBackground(){
		bgFotos = new PImage[5];
		for (int i = 0; i<bgFotos.length; i++){
			bgFotos[i] = loadImage("backgrounds/bgFoto" + i + ".png");			

		}

	}

	public void imageBackground(int bgnum) {
		image(bgFotos[bgnum], 0, 0);	
	}

	public void imageBackground(int bgnum, int xpos, int ypos, int wide, int tall) {
		image(bgFotos[bgnum], xpos, ypos, wide, tall);
	}

	public void granulate(int bgnum, int thealpha) {
				// image(bgFotos[bgnum], 0, 0, width, height);
				// loadPixels();
		for (int gridy = 0; gridy<height; gridy+= 13){
			for (int gridX = 0; gridX<width; gridX+= 13){
				// bgFotos[bgnum].loadPixels();
				// color grainCol = pixels[gridy*gridy];
				// imageBackground(bgnum);
				color grainCol = bgFotos[bgnum].get((int)random(gridX),(int)random(gridy));
				noStroke();
				fill(grainCol, thealpha);
				rect(gridX, gridy, 13, 13);

				// println(grainCol);
				// set(gridX, gridy, grainCol);
			}
		}
		
	}

	public void blackFade(int fade){
		background(0,255-fade);
	}

	



 }

