import de.looksgood.ani.*;
PImage darkleft;
PImage darkright;

CloudOrbs cloudbubble;
DeepBackground mybg;
ShapeSection shaper;

int fadeblack = 0;
int s;

int splitX1;
int splitX2;
int splitWidth1;
int splitWidth2;
Ani x1;
Ani x2;

float prob = 0.9;
int crazyX = 0;
int crazyY = 0;
int granalpha = 0;
int darkleftscroll;
int tryitX = 0;
int tryitY = 0;
int whichpart = 1;
int hexspeed=10;
int lastrandobg = 1;
int lastrandoshape =4;
int tint1 = 80;
int tint2 = 255;

void setup(){
	size(displayWidth, displayHeight);
	smooth();

	cloudbubble = new CloudOrbs();
	mybg = new DeepBackground();
	shaper = new ShapeSection(); 

	noCursor();

	darkleft = loadImage("backgrounds/darkleft.png");
	darkright = loadImage("backgrounds/darkright.png");

	splitX1 = width/2;
	splitX2 = width/2;
	splitWidth1 = splitX1 + 200;
	splitWidth2 = splitX2 - 200;
	
	darkleftscroll = 0-darkleft.width;

	Ani.init(this);
	
}

boolean sketchFullScreen(){
	return true;
}


void draw(){

	if (whichpart ==1){
		tint(200);
		mybg.imageBackground(0);
		cloudbubble.randomDraw(splitX1, height/2);
	} else if (whichpart == 2) {
		Ani x1 = new Ani(this, 1.5, "splitX1", splitWidth1, Ani.ELASTIC_OUT);
		Ani x2 = new Ani(this, 1.5, "splitX2", splitWidth2, Ani.ELASTIC_OUT );

		tint(200);
		mybg.imageBackground(0);
		cloudbubble.randomDraw(splitX1 + (int)random(-crazyY,crazyY) , height/2 +  (int)random(-crazyY,crazyY) );
		cloudbubble.randomDraw(splitX2 +  (int)random(-crazyY,crazyY) , height/2 +  (int)random(-crazyY,crazyY) );
		
		if (crazyY < 100){
			crazyY++;
		}

	} else if (whichpart == 3) {
		tint(200);
		mybg.imageBackground(0);
		cloudbubble.massOrbs(width/2, height/2, width/3, height/2, prob);

	} else if (whichpart ==4) {
		if (granalpha<255){
			granalpha++;
		} 

			tint(200);
			mybg.imageBackground(0);
			mybg.granulate(0,granalpha);
			cloudbubble.massOrbs(width/2, height/2, width/3, height/2, prob);
		if (prob > 0.2){
			prob -= 0.002;
		}
	} else if (whichpart == 5) {
		granalpha = 4444;

		tint(200);
		mybg.granulate(0,granalpha);
		cloudbubble.massOrbs(width/2, height/2, width/3, height/2, prob);
	} else if (whichpart == 6) {
		if (frameCount% (1+(int)(mouseX/(width/10)))==0){
			tint(tint1);
			mybg.imageBackground(2);
			tint(tint2);
			shaper.grid(3);
		}
	} else if (whichpart == 7) {
		if (frameCount% (1+(int)(mouseX/(width/10)))==0){
			tint(tint1);
			mybg.imageBackground(1);
			tint(tint2);
			shaper.grid(2);
		}
	} else if (whichpart == 8) {
		if (frameCount% (1+(int)(mouseX/(width/10)))==0){
			tint(tint2);
			mybg.imageBackground(3);
			tint(tint1);
			shaper.grid(1);
		}
	} else if (whichpart == 9) {
		if (random(0, 1)> 0.7){
			int z = tint1;
			tint1 = tint2;
			tint2 = z;
			lastrandobg = (int)ceil(random(4));
			lastrandoshape = (int)ceil(random(3));
		} 

		if (frameCount% (1+(int)(mouseX/(width/10)))==0){
			tint(tint1,tint1);
			mybg.imageBackground(lastrandobg);
			tint(tint2,tint1);
			shaper.grid(lastrandoshape);
		}
	}
 		
	saveFrame("saved/finalproj-####.tif");

	if(fadeblack<255){
		fadeBlack();
	}
}

void fadeBlack(){
	fadeblack+=2;

	fill(0, 255-fadeblack);
	rect(0,0, width, height);

}

void keyPressed(){
	if (key == '1'){
		whichpart = 1;
	} else if (key == '2') {
		whichpart = 2;
	} else if (key == '3') {
		whichpart = 3;
		println("part3");
	} else if (key == '4') {
		whichpart = 4;
	} else if (key == '5') {
		whichpart = 5;
	} else if (key == '6') {
		whichpart = 6;
	} else if (key == '7') {
		whichpart = 7;
	} else if (key == '8' ) {
		whichpart = 8;
	} else if (key == '9') {
		whichpart = 9;
	} else if (key == '0') {
		whichpart = 0; 
	}
}




