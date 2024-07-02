import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox 
{

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Label label;
	private TextField textfield;
	//  declare two HBoxes
	private HBox HBox1;
	private HBox HBox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	private DataManager dataManager;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	
	FXMainPane() 
	{
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Urdu");
		button5 = new Button("Clear");
		button6 = new Button("Exit");
		
		
		label = new Label("Feedback:");
		textfield = new TextField();	
		
		//  instantiate the HBoxes
		HBox1 = new HBox();
		HBox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		
		//  set margins 
		Insets inset = new Insets(10);
		HBox.setMargin(button1, inset);
		HBox.setMargin(button2, inset);
		HBox.setMargin(button3, inset);
		HBox.setMargin(button4, inset);
		HBox.setMargin(button5, inset);
		HBox.setMargin(button6, inset);

		// set alignment of the components
		HBox1.setAlignment(Pos.CENTER); 
		HBox2.setAlignment(Pos.CENTER); 
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		HBox2.getChildren().addAll(label, textfield);
		//  add the buttons to the other HBox
		HBox1.getChildren().addAll(button1, button2, button3, button4, button5, button6);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(HBox1, HBox2);  
		
		button1.setOnAction(new ButtonHandler());
		button2.setOnAction(new ButtonHandler());
		button3.setOnAction(new ButtonHandler());
		button4.setOnAction(new ButtonHandler());
		button5.setOnAction(new ButtonHandler());
		button6.setOnAction(new ButtonHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>
	{	
	
		public void handle(ActionEvent event)
		{
			
			if (event.getTarget() == button1)
			{
				String response = dataManager.getHello();
				textfield.setText(response);
			}
			else if (event.getTarget() == button2)
			{
				String response = dataManager.getHowdy();
				textfield.setText(response);
			}
			else if (event.getTarget() == button3)
			{
				String response = dataManager.getChinese();
				textfield.setText(response);
			}
			else if (event.getTarget() == button4)
			{
				String response = dataManager.getUrdu();
				textfield.setText(response);
			}
			else if (event.getTarget() == button5)
			{
				textfield.setText("");
			}
			else if (event.getTarget() == button6)
			{
				Platform.exit();
				System.exit(0);
			}
		}
	}
}	
