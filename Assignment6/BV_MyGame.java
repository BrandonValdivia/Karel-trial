
/*
 * Brandon Valdivia
 * This will play a game using interactors.
 */



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

@SuppressWarnings("serial")
public class BV_MyGame extends GraphicsProgram{
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public void init() {
		setUpSpots();
		decideKarel();	
		createButtons();
		createBeeper();
		createKarel();
		createBoundary();
		createRoofing();
		createMessage();
		addMouseListeners();
		setSize (700, 450);
	}
	
	/** Initializes every spot in spots and sets them to 0 **/
	private void setUpSpots() {
		spots = new int[20][20];
		for(int x2 = 0; x2 < 20; x2++){
			for(int y2 = 0; y2 < 20; y2++){
				spots[x2][y2] = 0;
			}
		}
		
	}
	
	/** Makes Beeper **/
	private void createBeeper() {
		beeper = new GRect(15,15);
		beeper.setColor(Color.RED);
		beeper.setFilled(true);
	}
	/** Creates buttons for the user to choose the Karel type with **/
	private void decideKarel() {
		newsPaper = new GCompound();
		GRect news = new GRect(150, 150);
		news.setColor(Color.GRAY);
		news.setFilled(true);
		newsPaper.add(news);
		GLabel news2 = new GLabel("News Paper Karel");
		news2.setLocation(news.getX()+news.getWidth()/2 - news2.getWidth()/2, news.getY()+news.getHeight()/2 - news2.getHeight()/2);
		newsPaper.add(news2);
		decision = 0;
		add(newsPaper);		
		
		stoneMason = new GCompound();
		GRect stone = new GRect(150, 150);
		stone.setColor(Color.GRAY);
		stone.setFilled(true);
		stone.setLocation(160, 0);
		stoneMason.add(stone);
		GLabel stone2 = new GLabel("Stone Mason Karel");
		stone2.setLocation(stone.getX() + stone.getWidth()/2 - stone2.getWidth()/2, stone.getY()+stone.getHeight()/2 - stone2.getHeight()/2);
		stoneMason.add(stone2);
		decision = 0;
		add(stoneMason);
		
	}

	/** Makes all the JButtons for the user **/
	private void createButtons() {
		move = new JButton("move()");
		turn = new JButton("turn()");
		putBeeper = new JButton("putBeeper()");
		pickBeeper = new JButton("pickBeeper");
		
		add (putBeeper, EAST);
		add(pickBeeper, EAST);
		add(move, EAST);
		add(turn, EAST);
	}


	/** Creates the boundaries used in News Paper Karel**/
	private void createBoundary() {
		GRect boundary = new GRect(boxW*6 + boxW/4, boxH/2);
		boundary.setLocation(boxW*4 , boxH*4 - boundary.getHeight()/2);
		boundary.setFilled(true);
		
		GRect leftW = new GRect(boxW/2, boxH*7 - boxH/2);
		leftW.setLocation(boxW*4 - leftW.getWidth()/2 , boxH*4 - boundary.getHeight()/2);
		leftW.setFilled(true);
		
		GRect bottom = new GRect(boxW*6 + boxW/4, boxH/2);
		bottom.setLocation(boxW*4 , boxH*10 - bottom.getHeight()/2+1);
		bottom.setFilled(true);
		
		GRect rightW = new GRect(boxW/2, boxH*5 - boxH/2);
		rightW.setLocation(boxW*10 - rightW.getWidth()/2 , boxH*6 - boundary.getHeight()/2);
		rightW.setFilled(true);
		
		b = new GCompound();
		b.add(rightW);
		b.add(bottom);
		b.add(leftW);
		b.add(boundary);
		
	}

	/**Creates the Barriers used in Stone Mason **/
	private void createRoofing() {
		roofing = new GCompound();
		GRect f = new GRect(boxW/2, boxW/2, boxW, boxW*2.75);
		f.setFilled(true);
		roofing.add(f);
		GRect f2 = new GRect(boxW/2 + boxW*4, boxW/2, boxW, boxW*2.75);
		f2.setFilled(true);
		roofing.add(f2);
		GRect f3 = new GRect(boxW/2 + boxW*8, boxW/2, boxW, boxW*2.75);
		f3.setFilled(true);
		roofing.add(f3);
		GRect f4 = new GRect(boxW/2 + boxW*12, boxW/2, boxW, boxW*2.75);
		f4.setFilled(true);
		roofing.add(f4);
		GRect f5 = new GRect(boxW/2 + boxW*16, boxW/2, boxW*3, boxW*2.75);
		f5.setFilled(true);
		roofing.add(f5);
		GRect s = new GRect(boxW/2 + boxW, boxW/2, boxW, boxW*2);
		s.setFilled(true);
		roofing.add(s);
		GRect s2 = new GRect(boxW/2 + boxW*3, boxW/2, boxW, boxW*2);
		s2.setFilled(true);
		roofing.add(s2);
		GRect s3 = new GRect(boxW/2 + boxW*5, boxW/2, boxW, boxW*2);
		s3.setFilled(true);
		roofing.add(s3);
		GRect s4 = new GRect(boxW/2 + boxW*7, boxW/2, boxW, boxW*2);
		s4.setFilled(true);
		roofing.add(s4);
		GRect s5 = new GRect(boxW/2 + boxW*9, boxW/2, boxW, boxW*2);
		s5.setFilled(true);
		roofing.add(s5);
		GRect s6 = new GRect(boxW/2 + boxW*11, boxW/2, boxW, boxW*2);
		s6.setFilled(true);
		roofing.add(s6);
		GRect s7 = new GRect(boxW/2 + boxW*13, boxW/2, boxW, boxW*2);
		s7.setFilled(true);
		roofing.add(s7);
		GRect s8 = new GRect(boxW/2 + boxW*15, boxW/2, boxW, boxW*2);
		s8.setFilled(true);
		roofing.add(s8);
		
		GRect top = new GRect(boxW/2, 0, boxW * 18, boxW*1.75);
		top.setFilled(true);
		roofing.add(top);
		
	}

	/** Makes the error message board **/
	private void createMessage() {
		GRect backBoard = new GRect( boxW*10, boxH *10);
		backBoard.setColor(Color.GRAY);
		backBoard.setFilled(true);
		backBoard.setLocation(boxW, boxH);
		
		GLabel declare = new GLabel("That command would have caused a");
		declare.setLocation(boxW + backBoard.getWidth()/2 - declare.getWidth()/2, boxH + backBoard.getHeight()/2 - declare.getHeight()/2 );
		declare.setColor(Color.RED);
		
		GLabel declare2 = new GLabel("bug in the program, try something else.");
		declare2.setLocation(declare.getX(), declare.getY() + declare.getHeight() +2);
		declare2.setColor(Color.RED);
		
		GLabel declare3 = new GLabel("Click on this box to continue");
		declare3.setLocation(declare2.getX(), declare2.getY() + declare2.getHeight() +2);
		declare3.setColor(Color.RED);
		
		message = new GCompound();
		message.add(backBoard);
		message.add(declare);
		message.add(declare2);
		message.add(declare3);
		
	}


	/** Adds all pictures of Karel into one GCompound named Karel **/
	private void createKarel() {
		east = new GImage("karelW.png");
		east.setSize(30,30);
		position = 0;
		
		northW = new GImage("karelNW.png");
		northW.setSize(30, 30);
		
		south = new GImage("karelS.png");
		south.setSize(30, 30);
		
		west = new GImage("karelE.png");
		west.setSize(30,30);
		
		karel = new GCompound();
		karel.add(northW);
		karel.add(west);
		karel.add(south);
		karel.add(east);
	}



	public void actionPerformed(ActionEvent e) {
		Object direction = (Object) e.getSource();
		if(getElementAt(boxW*10 +1, boxH *10 +1) != message){ //If the Error message is not being displayed
			if(direction == move){
				moveKarel();
			}
			if(direction == turn){
				turnKarel();
			}
			if (direction == putBeeper){
				karel.sendToBack(); //Gets karel out of the way, so getElementAt wont be affected
				multiBeeper = new GCompound();
				if(spots[x][y] == 0){
					beeper = new GRect(15,15);
					beeper.setColor(Color.RED);
					beeper.setFilled(true);
					beeper.setLocation(karel.getX() + karel.getWidth()/2 - beeper.getWidth()/2,karel.getY() + karel.getHeight()/2 - beeper.getHeight()/2 );
					add(beeper); //Displays a beeper in correct spot
					spots[x][y]++; //Records spots to add a beeper in that spot.
				} else {
					remove(getElementAt(karel.getX() + karel.getWidth()/2 - beeper.getWidth()/2 +1,karel.getY() + karel.getHeight()/2 - beeper.getHeight()/2));
					//Clears that spot
					spots[x][y]+= 1; // Adds another beeper to the recorded number of beepers in that spot
					GLabel number = new GLabel (" " + spots[x][y]); //Displays the number of beepers in that spot
					number.setLocation(karel.getX() + karel.getWidth()/2 - number.getWidth()/2, karel.getY() + karel.getHeight()/2 + number.getHeight()/2);
					multiBeeper.add(beeper);
					multiBeeper.add(number);
					add(multiBeeper); //Adds a beeper with a number for how many beepers are in that spot.
				}
				karel.sendToFront(); //Moves karel back to the front
				
			}
			if (direction == pickBeeper){
				karel.sendToBack(); //Gets karel out of the way, so getElementAt wont be affected
				if(spots[x][y] != 0){
					remove(getElementAt(karel.getX() + karel.getWidth()/2 - beeper.getWidth()/2,karel.getY() + karel.getHeight()/2 - beeper.getHeight()/2));
					spots[x][y]--; //Takes a away one beeper from the amount of recorded beepers for the spot
					if(spots[x][y] >= 2){ 
						//If after taking away one from the recorded there is still more than one beeper in the spot
						multiBeeper = new GCompound();
						GLabel number = new GLabel (""+spots[x][y]); 
						number.setLocation(karel.getX() + karel.getWidth()/2 - number.getWidth()/2, karel.getY() + karel.getHeight()/2 + number.getHeight()/2);
						multiBeeper.add(beeper);
						multiBeeper.add(number);
						add(multiBeeper); //Creates a new multiBeeper with one less beeper than before
					} else {
						if (spots[x][y] == 1){ 
							//If there is one beeper left, than it only adds a beeper, without the number.
							beeper = new GRect(15,15);
							beeper.setColor(Color.RED);
							beeper.setFilled(true);
							beeper.setLocation(karel.getX() + karel.getWidth()/2 - beeper.getWidth()/2,karel.getY() + karel.getHeight()/2 - beeper.getHeight()/2 );
							add(beeper);
						} 
					}
				} else {
					error++; //If no beeper is in that spot than an error message is shown
				}
				karel.sendToFront();
			}
			remove(karel);
			add(karel); //Updates karels location
			if (error != 0){ //Displays the error message if any occured
				message.sendToFront();
				add(message);
				addMouseListeners();
			}
		}
	}
	
	/** Moves the correct facing picture to the front **/
	private void turnKarel() {
		if(position == 0){
			northW.sendToFront(); // Send the Karel facing north forward
		}
		if (position == 1){
			west.sendToFront(); //Send the Karel facing west forward
		}
		if(position == 2){
			south.sendToFront(); //Send the Karel facing South forward
		} 
		if(position == 3){
			east.sendToFront(); // Send the karel facing East forward
			position = 0; //Sets it back to west
		}else position++; // Unless it is three than all others should just add one.
		
	}

	/** Moves Karel in the direction she is facing, if she can move **/
	private void moveKarel() {
		if (position == 0){ //Karel is facing East
			if (karel.getX()+ karel.getWidth()< boxW*17 && getElementAt(karel.getX() + boxW*1.5, karel.getY() + karel.getHeight()/2) != b && getElementAt(karel.getX() + boxW*1.5, karel.getY() + karel.getHeight()/2) != roofing) {
				//If front is clear
				karel.setLocation(karel.getX() + boxW, karel.getY()); 
				x++; //Updates the position for spots
			} else error++; 
		}
		if (position == 1){ //Karel is Facing North
			if (karel.getY() - 20 > 0 && getElementAt(karel.getX(), karel.getY() - boxH + karel.getHeight()/2) != b && getElementAt(karel.getX(), karel.getY() - boxH + karel.getHeight()/2) != roofing) {
				//If front is clear
				karel.setLocation(karel.getX(), karel.getY() - boxH);
				y--; //Updates the position for spots
			} else error++;
		}
		if (position == 2 ){ //Karel is facing West
			if (karel.getX() - 20 > 8 && getElementAt(karel.getX() - boxW/2, karel.getY() + karel.getHeight()/2) != b && getElementAt(karel.getX() - boxW/2, karel.getY() + karel.getHeight()/2) != roofing) {
				//If front is clear
				karel.setLocation(karel.getX() - boxW, karel.getY());
				x--; //Updates the position for spots
			} else error++;
		}
		if (position == 3){ // Karel is facing South
			if (karel.getY() + 20 < boxH*15 && getElementAt(karel.getX(), karel.getY() + boxH + karel.getHeight()/2) != b && getElementAt(karel.getX(), karel.getY() + boxH + karel.getHeight()/2) != roofing) {
				//If front is clear
				karel.setLocation(karel.getX(), karel.getY() + boxH);
				y++; //Updates the position for spots
			} else error++;
		}
	}

	public void mouseClicked(MouseEvent t){
		Object Clicked = getElementAt(t.getX(), t.getY());
		if (decision != 0){ // If a karel type has already been selected
			if (Clicked == message){
				remove(message); 
				error = 0; //Removes the message, and says there are no more errors
			}
		} else {
			if (Clicked != null) { //If they did click on something
				removeAll(); //Removes the Karel types
				createGrid();
				
				beeper.setLocation(boxW*13 - beeper.getWidth()/2 , boxW*8 +2  ); //Adds a beeper used in both classes
				add(beeper);
				spots[12][10] = 1; // Records the location of the beeper
				
				
				if (Clicked == newsPaper){	//If Nes Paper Karel is chosen
					karel.setLocation(boxW*5 - northW.getWidth()/2, boxH *9  - northW.getHeight() / 2); //Sets Karel in spot for news paper
					x = 4; //Updating location used for spots
					y = 8; //Updating location used for spots
					add(b); //Adds barriers
					add(karel);	//Adds karel
				}
				if (Clicked == stoneMason){
					for (int h = 1; h <= 18; h++){
						if(h == 1 || h%4 == 1){
							if(h != 13){
								int j = 0;
								if(h != 1){
									j = rgen.nextInt(5, 11);
								} else {
									j = rgen.nextInt(5, 10);
								}
								beeper = new GRect(15,15);
								beeper.setColor(Color.RED);
								beeper.setFilled(true);
								beeper.setLocation((boxW*h) - beeper.getWidth()/2, (boxH*j) - beeper.getHeight()/2);
								add(beeper); // Adds a beeper in a random spot in each comlumn for stones.
								spots[h-1][j-1]++; //Tells spots where each of those beepers are.
							}
						}
					}
					add(roofing); //Add stone mason barriers
					karel.setLocation(boxW - northW.getWidth()/2, boxH * 15 - karel.getHeight()/2);
					x = 0; //Updating location used for spots
					y = 14; //Updating location used for spots
					add(karel); //Adds Karel
				}
				decision++; //Karel type is decided
				addActionListeners(); 
			}
		}
	}
	
	/** Adds all the dots to the canvas **/
	private void createGrid() {
		for (int count = 1; count <= 18; count++){
			for (int count2 = 1; count2 <= 15; count2++){
				GOval dot = new GOval(2.5,2.5);
				dot.setFilled(true);
				dot.setLocation(boxW*count, boxH*count2); //Creates 18 columns and 15 rows.
				add(dot);
			}
		}
		
	}

	/** Keeps track of which way Karel is facing (which picture is in front)**/
	private int position;
	private JButton pickBeeper;
	private GRect beeper;
	private JButton putBeeper;
	private JButton turn;
	private JButton move;
	private final int boxW = 36;
	private final int boxH = 27;
	/** The picture of Karel facing South **/
	private GImage south;
	/** The picture of Karel facing East **/
	private GImage east;
	/** The picture of Karel facing West **/
	private GImage west;
	/** The picture of Karel facing North **/
	private GImage northW;
	private GCompound karel;
	/** Holds all the barriers inside of News Paper Karel **/
	private GCompound b;
	/** Displays a message on the screen to let the player know they were causing an error **/
	private GCompound message;
	/** Keeps track of whether or not the error message is displayed **/
	private int error;
	/** Used when more then one beeper is in the same spot **/
	private GCompound multiBeeper;
	/** Keeps track if a type of Karel has been decided. **/
	private int decision;
	/** The square to choose News Paper Karel **/
	private GCompound newsPaper;
	/** The square to choose Stone Mason Karel **/
	private GCompound stoneMason;
	/** The barriers inside of Stone Mason Karel **/
	private GCompound roofing;
	/** Records how many beepers are in each spot **/
	private int[][] spots;
	/** Keeps track of which column Karel is in, and is used to update Spots **/
	private int x;
	/** Keeps track of which row Karel is in, and is used to update Spots **/
	private int y;
}
