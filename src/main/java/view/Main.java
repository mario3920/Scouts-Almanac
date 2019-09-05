package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.ConnectionFactory;
/*
 * Author:
 *  Mario Massari
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("Inicial.fxml"));
			Scene cenario = new Scene(janela, 800, 400);
			cenario.getStylesheets().add(getClass().getResource("Inicial.css").toExternalForm());
			primaryStage.setScene(cenario);
			primaryStage.setMaximized(false);
			primaryStage.setTitle("Author: Mario massari");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Main.launch(args);
		ConnectionFactory.close();
	}
}