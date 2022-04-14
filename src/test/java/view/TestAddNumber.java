package view;

import java.io.IOException;
import org.testfx.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AddNumberModel;
import views.MainController;

@ExtendWith(ApplicationExtension.class)
public class TestAddNumber
{
	@Start	//Before
	private void start(Stage stage)
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(AddNumberModel.class.getResource("../views/MainView.fxml"));
		try
		{
			VBox view = loader.load();
			MainController cont = loader.getController();
			cont.setModel(new AddNumberModel());
			
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void enterNumber(FxRobot robot, String first, String second)
	{
		robot.clickOn("#firstNumberText");
		robot.write(first);
		
		robot.clickOn("#secondNumberText");
		robot.write(second);
	}
	
	private void checkSum(FxRobot robot, String sum)
	{
		Assertions.assertThat(robot.lookup("#sumLabel")
				.queryAs(Label.class)).hasText(sum);
	}
	
	@Test
	public void testAdd(FxRobot robot)
	{
		enterNumber(robot, "1", "2");
		robot.clickOn("#addButton");
		checkSum(robot, "3");
		
		enterNumber(robot, "5", "10");
		robot.clickOn("#addButton");
		checkSum(robot, "15");
		
		enterNumber(robot, "-5", "10");
		robot.clickOn("#addButton");
		checkSum(robot, "5");
		
		enterNumber(robot, "-5", "-10");
		robot.clickOn("#addButton");
		checkSum(robot, "-15");
	}
}
