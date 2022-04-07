package views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.AddNumberModel;

public class MainController {
		AddNumberModel m;

	    @FXML
	    private TextField firstTextElement, secondElement;

	    @FXML
	    private Label totalLabel;

	    private int getFirstNumber()
	    {
	    	String val = firstTextElement.textProperty().get();
	    	int num = 0;
	    	try
	    	{
	    		num = Integer.parseInt(val);
	    	}
	    	catch (NumberFormatException e)
	    	{
	    		firstTextElement.textProperty().set("");
	    	}
	    	return num;
	    }
	    
	    private int getSecondNumber()
	    {
	    	
	    	String val = secondElement.textProperty().get();
	    	int num = 0;
	    	
	    	try
	    	{
	    		num = Integer.parseInt(val);
	    	}
	    	catch (NumberFormatException e)
	    	{
	    		secondElement.textProperty().set("");
	    	}
	    	
	    	return num;
	    }
	    
	    @FXML
	    void onAddButton(ActionEvent event) 
	    {
	    	int num1 = getFirstNumber();
	    	int num2 = getSecondNumber();
	    	m.add(num1, num2);
	    	totalLabel.setText(String.valueOf(m.getSum()));
	    }
	    
	    public void setModel(AddNumberModel m)
	    {
	    	this.m = m;
	    }

	}


	

