package application;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.util.Duration;
 
public class Controller {
	int letter = 1;
	int playerXScore = 0;
	int playerOScore = 0;
	String letterColor = "9DBC98";
	AudioClip clipX = new AudioClip(Paths.get("C:\\Users\\Sean Rommel E\\eclipse-workspace\\TicTac\\SFX\\button1.mp3").toUri().toString());
	AudioClip clipO = new AudioClip(Paths.get("C:\\Users\\Sean Rommel E\\eclipse-workspace\\TicTac\\SFX\\button2.mp3").toUri().toString());
	
	@FXML
	Pane gamePane;
	@FXML
	//Top Buttons
	private Button topLeftButton;
	@FXML
	private Button topMiddleButton;
	@FXML
	private Button topRightButton;
	
	//Middle Buttons
	@FXML
	private Button middleLeftButton;
	@FXML
	private Button middleMiddleButton;
	@FXML
	private Button middleRightButton;
	
	//Bottom Buttons
	@FXML
	private Button bottomLeftButton;
	@FXML
	private Button bottomMiddleButton;
	@FXML
	private Button bottomRightButton;
	
	// Reset button
	@FXML
	private Button resetButton;
	@FXML
	private Label oScore;
	
	@FXML
	private Label xScore;
	
	@FXML
	private Label scoreLabel;
	public void buttonClicked(Event e) {
		String buttonId = ((Control)e.getSource()).getId();
		setTexts(buttonId);
		winningCombination();
//		topMiddleButton.setText("X");
//		System.out.println(topMiddleButton.getText().isEmpty());
	}
	public String currentLetter() {
		String currentChar;
		if (this.letter % 2 != 0) {
			currentChar = "X";
			this.clipX.play();
			this.letterColor = "9DBC98";
			this.letter++;
			
		}else {
			this.clipO.play();
			currentChar = "O";
			this.letterColor = "638889";
			this.letter++;
		}

		return currentChar;
	}

	
	public void setTexts(String id) {
		
		switch(id) {
			case "topLeftButton":
				if(topLeftButton.getText().isEmpty()) {
					topLeftButton.setText(currentLetter());
					topLeftButton.setTextFill(Color.web(this.letterColor));
				}
				break;
			case "topMiddleButton":
				if(topMiddleButton.getText().isEmpty()) {
					topMiddleButton.setText(currentLetter());
					topMiddleButton.setTextFill(Color.web(this.letterColor));
				}
				break;
			case "topRightButton":
				if(topRightButton.getText().isEmpty()) {
					
					topRightButton.setText(currentLetter());
					topRightButton.setTextFill(Color.web(this.letterColor));
				}
				break;
			case "middleLeftButton":
				if(middleLeftButton.getText().isEmpty()) {
					
					middleLeftButton.setText(currentLetter());
					middleLeftButton.setTextFill(Color.web(this.letterColor));
				}
				break;
			case "middleMiddleButton":
				if(middleMiddleButton.getText().isEmpty()) {
					
					middleMiddleButton.setText(currentLetter());
					middleMiddleButton.setTextFill(Color.web(this.letterColor));
				}
				break;
			case "middleRightButton":
				if(middleRightButton.getText().isEmpty()) {
					
					middleRightButton.setText(currentLetter());
					middleRightButton.setTextFill(Color.web(this.letterColor));
				}
				break;
			case "bottomLeftButton":
				if(bottomLeftButton.getText().isEmpty()) {
					
					bottomLeftButton.setText(currentLetter());
					bottomLeftButton.setTextFill(Color.web(this.letterColor));
				}
				break;
			case "bottomMiddleButton":
				if(bottomMiddleButton.getText().isEmpty()) {
					
					bottomMiddleButton.setText(currentLetter());
					bottomMiddleButton.setTextFill(Color.web(this.letterColor));
				}
				break;
			case "bottomRightButton":
				if(bottomRightButton.getText().isEmpty()) {
					
					bottomRightButton.setText(currentLetter());
					bottomRightButton.setTextFill(Color.web(this.letterColor));
				}
			default:
				break;
		}
		
//		if(id.equals("topLeftButton")) {
//			if(topLeftButton.getText().isEmpty()) {
//				topLeftButton.setText(currentLetter);
//			}
//		
//		}else if(id.equals("topMiddleButton")) {
//			if(topMiddleButton.getText().isEmpty()) {
//				topMiddleButton.setText(currentLetter);
//			}
//			
//		}else if(id.equals("topRightButton")) {
//			
//		}else if(id.equals("middleLeftButton")) {
//			
//		}else if(id.equals("middleMiddleButton")) {
//			
//		}else if(id.equals("middleRightButton")) {
//			
//		}else if(id.equals("bottomLeftButton")) {
//			
//		}else if(id.equals("bottomMiddleButton")) {
//			
//		}else if(id.equals("bottomRightButton")){
//			
//		}else {
//			
//		}
		
	
	}

	public void winningCombination() {
		/*
		 * Winning Combinations
		 * 		0				1				2
		 * topLeftButton, topMiddleButton, topRightButton
		 * 		3					4						5
		 * middleLeftButton, middleMiddleButton, middleRightButton
		 * 		6					7					8
		 * bottomLeftButton, bottomMiddleButton, bottomRightButton
		 * 
		 */
		
		// Horizontal Combination
		//							0					1				2
		Button[] buttonsArray = {topLeftButton, topMiddleButton, topRightButton,
								 middleLeftButton, middleMiddleButton, middleRightButton,
								 bottomLeftButton, bottomMiddleButton, bottomRightButton};

		// Horizontal Combinations
		if (buttonsArray[0].getText().equals(buttonsArray[1].getText()) && (buttonsArray[0].getText().isEmpty() != true) && buttonsArray[0].getText().equals(buttonsArray[2].getText())) {
			System.out.println("Horizonal Top win");
			scorer(buttonsArray[0]);
			letterReset();
			clearTable();
			
		}
		else if (buttonsArray[3].getText().equals(buttonsArray[4].getText()) && (buttonsArray[3].getText().isEmpty() != true) && buttonsArray[3].getText().equals(buttonsArray[5].getText())) {
			System.out.println("Horizontal Middle win");
			scorer(buttonsArray[3]);
			letterReset();
			clearTable();
			
		}
		else if (buttonsArray[6].getText().equals(buttonsArray[7].getText()) && (buttonsArray[6].getText().isEmpty() != true) && buttonsArray[6].getText().equals(buttonsArray[8].getText())) {
			System.out.println("Horizontal Bottom win");
			scorer(buttonsArray[6]);
			letterReset();
			clearTable();
			
		}
		
		// Vertical Combinations
		else if (buttonsArray[0].getText().equals(buttonsArray[3].getText()) && (buttonsArray[0].getText().isEmpty() != true) && buttonsArray[0].getText().equals(buttonsArray[6].getText())) {
			System.out.println("Vertical Left win");
			scorer(buttonsArray[0]);
			letterReset();
			clearTable();
			
		}
		else if (buttonsArray[1].getText().equals(buttonsArray[4].getText()) && (buttonsArray[1].getText().isEmpty() != true) && buttonsArray[1].getText().equals(buttonsArray[7].getText())) {
			System.out.println("Vertical Middle win");
			scorer(buttonsArray[1]);
			letterReset();
			clearTable();
					}
		else if (buttonsArray[2].getText().equals(buttonsArray[5].getText()) && (buttonsArray[2].getText().isEmpty() != true) && buttonsArray[2].getText().equals(buttonsArray[8].getText())) {
			System.out.println("Vertical Right win");
			scorer(buttonsArray[2]);
			letterReset();
			clearTable();
			
		}
		
		// Diagonal Combinations
		else if (buttonsArray[0].getText().equals(buttonsArray[4].getText()) && (buttonsArray[0].getText().isEmpty() != true) && buttonsArray[0].getText().equals(buttonsArray[8].getText())) {
			System.out.println("Digonal Left win");
			scorer(buttonsArray[0]);
			letterReset();
			clearTable();
			
		}
		else if (buttonsArray[2].getText().equals(buttonsArray[4].getText()) && (buttonsArray[2].getText().isEmpty() != true) && buttonsArray[2].getText().equals(buttonsArray[6].getText())) {
			System.out.println("Diagonal Right win");
			scorer(buttonsArray[2]);
			letterReset();
			clearTable();
			
		}
		isFull();


	}
	
	public void letterReset() {
		this.letter = 1;
		
	}
	
	public void scorer(Button id) {
		
		if(id.getText().equals("X")) {
			this.playerXScore++;
			xScore.setText("X : " + this.playerXScore);
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), e -> {
				scoreLabel.setText("X Wins!");
				
				Timeline revertTimeline = new Timeline(new KeyFrame(Duration.seconds(0.5), el ->{
					scoreLabel.setText("Score");
				}));
				
				revertTimeline.play();
			}));
			
			timeline.play();
			scoreLabel.setText("Score");
		}else if(id.getText().equals("O")) {
			this.playerOScore++;
			oScore.setText("O : " + this.playerOScore);
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), e -> {
				scoreLabel.setText("O Wins!");
				
				Timeline revertTimeline = new Timeline(new KeyFrame(Duration.seconds(0.5), el ->{
					scoreLabel.setText("Score");
				}));
				
				revertTimeline.play();
			}));
			
			timeline.play();
			scoreLabel.setText("Score");
			
		}
	}
	public void resetGame() {
		this.playerXScore = 0;
		this.playerOScore = 0;
		xScore.setText("X : ");
		oScore.setText("O : ");
		clearTable();
		
	}
	public void isFull() {
		// Check if table is full
		int counter = 0;
		
		Button[] buttonsArray = {topLeftButton, topMiddleButton, topRightButton,
				 middleLeftButton, middleMiddleButton, middleRightButton,
				 bottomLeftButton, bottomMiddleButton, bottomRightButton};
		
		for(int i = 0; i < buttonsArray.length; i++) {
			if (buttonsArray[i].getText().isEmpty() == false) {
				counter++;
			}
		}
		if(counter == 9) {
			System.out.println("Full");
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), e -> {
				scoreLabel.setText("Draw!");
				
				Timeline revertTimeline = new Timeline(new KeyFrame(Duration.seconds(0.5), el ->{
					scoreLabel.setText("Score");
				}));
				
				revertTimeline.play();
			}));
			
			timeline.play();
			scoreLabel.setText("Score");
			clearTable();
		}
	}
	

	public void clearTable() {
		letterReset();
		Button[] buttonsArray = {topLeftButton, topMiddleButton, topRightButton,
				 middleLeftButton, middleMiddleButton, middleRightButton,
				 bottomLeftButton, bottomMiddleButton, bottomRightButton};
		
		for (int i = 0; i < buttonsArray.length; i++) {
			buttonsArray[i].setText("");
		}
	}
}
