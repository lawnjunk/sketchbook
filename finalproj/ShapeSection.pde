class ShapeSection{
	int startX;
	int endX;
	int startY;
	int endY;
	int gridSizeX;
	int gridSizeY;
	int allowd;
	int allowdY;

	PImage[] hexa;
	PImage[] circles;
	PImage[] square;
	PImage[] trap;
	PImage[] trapu;

	ShapeSection(){
		hexa = new PImage[5];
		for (int i = 0; i<hexa.length; i++){
			 hexa[i] = loadImage("hex/hex" + i + ".png");
		}

		circles = new PImage[9];
		for (int i = 0; i<circles.length; i++){
			 circles[i] = loadImage("circles/circle" + i + ".png");
		}

		square = new PImage[10];
		for (int i = 0; i<square.length; i++){
			 square[i] = loadImage("squares/square" + i + ".png");
		}

		trap = new PImage[5];
		trapu = new PImage[5];
		for (int i = 0; i<trap.length; i++){
			trap[i] = loadImage("trap/trap" + i + ".png");
			trapu[i] = loadImage("trap/trapu" + i + ".png");
		}
	
	}

	public void grid(int shape){
		switch (shape){
			case 1:
				gridSizeX = width/10;
				gridSizeY = height/5;

				startX = 150;
				endX = (width - square[1].width - 30);
				startY = 50;
				endY = (height-square[shape].height);

				for (int gridY = startY; gridY<endY; gridY+= gridSizeY){
					for (int gridX = startX; gridX<endX; gridX+= gridSizeX){
						image(square[(int)random(100)%square.length], gridX, gridY);
					}
				}

				break;

			case 2:
				gridSizeX = width/7;
				gridSizeY = height/6;

				startX = 200;
				endX = (width - trap[1].width - 50);
				startY = 150;
				endY = (height-100-trap[1].height);

				for (int gridY = startY; gridY<endY; gridY+= gridSizeY){
					for (int gridX = startX; gridX<endX; gridX+= gridSizeX){
						float choose = random(0, 1);
						if (choose>0.5){
							image(trap[(int)random(100)%trap.length], gridX, gridY);
						} else {
							image(trapu[(int)random(	100)%trapu.length], gridX, gridY);	
						}
					}
				}
				break ;
			case 3:
				gridSizeX = width/5;
				gridSizeY = height/3;

				startX = 250;
				endX = (width - 100 - hexa[1].width);
				startY = 225;
				endY = (height - 100 - hexa[1].height);

				for (int gridY = startY; gridY<endY; gridY+= gridSizeY){
					for (int gridX = startX; gridX<endX; gridX+= gridSizeX){
						image(hexa[(int)random(100)%hexa.length], gridX, gridY);
					}
				}





				// endX = (width - trap[1].


			default :
				
			break;	
		}
	}


	public void gridal(int shape, int allow, int allowy){
		switch (shape){
			case 1:
				gridSizeX = width/10;
				gridSizeY = height/5;
				allowd= allow * gridSizeX;
				allowdY = allowy * gridSizeY;
				startX = 150;
				endX = allowd%(width - square[1].height - 30);
				startY = 50;
				endY = allowdY%(height-square[shape].width);

				println(allowd);

			for (int gridY = startY; gridY<endY; gridY+= gridSizeY){
				for (int gridX = startX; gridX<endX; gridX+= gridSizeX){
					image(square[(int)random(100)%square.length], gridX, gridY);
				}
			}
				break;
			default :
				
			break;	
		}


	}


}
