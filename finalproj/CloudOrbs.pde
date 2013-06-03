import de.looksgood.ani.*;

class CloudOrbs{
	Orb [] allOrbs = new Orb [16];
	// Ani.init(this);

	CloudOrbs(){
		fillOrbs();
	}

	public void randomDraw(int x, int y){
		tint(random(150,255), random(150,255));
		allOrbs[(int)random(allOrbs.length)].drawOrb(x,y);
	}

	public void massOrbs(int x, int y, int massWidth, int massHeight, float prob) {
		frameRate(15);
		int xpos = x - (massWidth/2);
		int ypos = y - (massHeight/2);
		int widthh = xpos + massWidth;
		int heightt = ypos + massHeight;
		for (int gridy = ypos; gridy<heightt; gridy+=(allOrbs[gridy%allOrbs.length].getHeight()/3)){
			for (int gridX = xpos; gridX<widthh; gridX+=(allOrbs[gridy%allOrbs.length].getWidth()/3)){
				if (random(0.0,1.0) > prob){
					int chooseAnOrb = (int)random(allOrbs.length);
					tint(random(255), random(19,255));
					allOrbs[chooseAnOrb].drawOrb(gridX,gridy);
				}
			}
		}
	}

	private void fillOrbs(){
		for (int i = 0; i<allOrbs.length; i++){
			allOrbs[i] = new Orb("cloudOrb" + i);
		}
	}

	// public void splitTwo(boolean go, int xpos, int ypos, int space){
	// 	float x1;
	// 	float x2;
	// 	float y1 = ypos;
	// 	float y2 = ypos;

	// 	if (!go){
	// 		x1 = xpos;
	// 		x2 = xpos;
	// 		this.randomDraw(x1, y1);
	// 	} else {
	// 		Ani.to(this, 1.5, "x1", x1+space);
	// 		Ani.to(this, 1.3, "x2", x2+space);
	// 		randomDraw(x1, y1);
	// 		randomDraw(x2, y2);
	// 	}

	// }



}