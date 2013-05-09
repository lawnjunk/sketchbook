void setup(){
	size(720, 720);
	// noCursor();
}



// This is a cool prorgram it uses the size wich is twice the size of 360
// (360 equals full range of hsb hue) the ba 
void draw(){
	colorMode(HSB,360,100,100 );
	rectMode(CENTER);
	noStroke();
	background(mouseY/2, 100, 100);

	fill(360-mouseY, 100, 100);
	rect(360,360, mouseX+1, mouseX+1);
		
}