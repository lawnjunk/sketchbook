import de.looksgood.ani.*;
PImage darkleft;
PImage darkright;

CloudOrbs cloudbubble;
DeepBackground mybg;
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

void setup(){
	size(displayWidth, displayHeight);
	smooth();
	cloudbubble = new CloudOrbs();
	mybg = new DeepBackground();
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

	// black fade to photo
	if(fadeblack<255){
		fadeBlack();
		s = frameCount;
		mybg.imageBackground(0);
	}

	if(frameCount - s < 10*frameRate  ){
		tint(200);
		mybg.imageBackground(0);
		cloudbubble.randomDraw(splitX1, height/2);
	} else if (frameCount - s < 20*frameRate)  {
		Ani x1 = new Ani(this, 1.5, "splitX1", splitWidth1, Ani.ELASTIC_OUT);
		Ani x2 = new Ani(this, 1.5, "splitX2", splitWidth2, Ani.ELASTIC_OUT );

		tint(200);
		mybg.imageBackground(0);
		cloudbubble.randomDraw(splitX1 + (int)random(-crazyY,crazyY) , height/2 +  (int)random(-crazyY,crazyY) );
		cloudbubble.randomDraw(splitX2 +  (int)random(-crazyY,crazyY) , height/2 +  (int)random(-crazyY,crazyY) );
		
		if (crazyY < 100){
			crazyY++;
		}

	} else {
		

		if (granalpha<255){
			tint(200);
			mybg.imageBackground(0);
			mybg.granulate(0,granalpha);
			cloudbubble.massOrbs(width/2, height/2, width/3, height/2, prob);
			granalpha++;

		} else {

			granalpha = 4444;

			tint(200);
			mybg.granulate(0,granalpha);
			cloudbubble.massOrbs(width/2, height/2, width/3, height/2, prob);
		}

		if (prob > 0.2){
			prob -= 0.002;
		}
 }

 	if(darkleftscroll < width/2){
 		tint(255);
 		image(darkleft, darkleftscroll+=10, 0);
 		image(darkright,width + (width - -darkleftscroll), 0);

 		if (darkleftscroll >= 0){
 			fill(0);
 			rect(0, 0, darkleftscroll, height);
 			rect(width,0,width - -darkleftscroll, height);
 		}
 	}
	// tint(200);
	// mybg.granulate(0);
	// if (frameCount%20 == 0){
	// mybg.imageBackground((int) random(5));

	// cloudbubble.massOrbs(width/2, height/2, width/3, height/2);
	
	// black fade to photo
	// if(fadeblack<255){
	// 	fadeBlack();
	// }
}

void fadeBlack(){
	fadeblack+=2;

	fill(0, 255-fadeblack);
	rect(0,0, width, height);

}






