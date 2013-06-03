class Orb{
	PImage orb;
	int x;
	int y;
	int orbWidth;
	int orbHeight;

	Orb(String name){
		orb =loadImage("cloudOrbs/" + name + ".png");
		orbWidth = orb.width;
		orbHeight = orb.height;
		x = width/2 - (orbWidth/2);
		y = height/2 - (orbHeight/2);


	}

	Orb(String name, int xpos, int ypos){
		orb =loadImage("cloudOrbs/" + name + ".png");
		int x = xpos;
		int y = ypos;
	}

	void drawOrb(){
		image(orb, x, y);
		
	}


	void drawOrb(int xpos, int ypos){
		this.x = xpos - orbWidth/2;
		this.y = ypos - orbHeight/2;

		image(orb, x, y);
		
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public int getWidth(){
		return this.orbWidth;
	}

	public int getHeight(){
		return this.orbHeight;
	}
}