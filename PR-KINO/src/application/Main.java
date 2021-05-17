package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
<<<<<<< HEAD
			System.out.println("GIT test");
			System.out.println("GIT TESTOWY");
			System.out.println("TEST NUMER 3");

			int numer = 2;
			for(int i=0;i<numer;i++)
			{
				System.out.println("SIEMA!");
			}
			
=======
			System.out.println("Mateusz Osikowski dzia³a");
>>>>>>> branch 'master' of https://github.com/januszbyt/praktyka_gr1
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
