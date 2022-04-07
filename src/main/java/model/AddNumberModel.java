package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class AddNumberModel 
{
	IntegerProperty sum = new SimpleIntegerProperty();
	
	public AddNumberModel() 
	{
		
	}
	
	public int getSum()
	{
		return sum.getValue().intValue();
	}
	
	public void add(int num1, int num2) 
	{
		sum.set(num1 + num2);
	}
}
