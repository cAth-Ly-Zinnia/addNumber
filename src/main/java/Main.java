
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AddNumberModel;
import views.MainController;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception 
	{
		AddNumberModel model = new AddNumberModel();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/MainView.fxml"));
		VBox view = loader.load();
		
		MainController cont = loader.getController();
		cont.setModel(model);
		
		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
