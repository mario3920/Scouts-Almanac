package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class IniciarController {
	
	@FXML
	public void menuAtividadesClick() {
		Stage modal = new Stage();
		modal.initOwner(new Stage());
		modal.initModality(Modality.APPLICATION_MODAL);
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("crud/AtividadesView.fxml"));
			Scene cenario = new Scene(janela, 800, 400);
			cenario.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			modal.setScene(cenario);
			modal.setTitle("Atividades");
			modal.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void menuCancioneiroClick() {
		Stage modal = new Stage();
		modal.initOwner(new Stage());
		modal.initModality(Modality.APPLICATION_MODAL);
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("crud/CancioneiroView.fxml"));
			Scene cenario = new Scene(janela, 800, 400);
			cenario.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			modal.setScene(cenario);
			modal.setTitle("Canções");
			modal.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void menuFecharClick(){
		System.exit(0);
	}
	
	@FXML
	public void menuProjetosClick() {
		Stage modal = new Stage();
		modal.initOwner(new Stage());
		modal.initModality(Modality.APPLICATION_MODAL);
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("crud/ProjetosView.fxml"));
			Scene cenario = new Scene(janela,800,400);
			cenario.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			modal.setScene(cenario);
			modal.setTitle("Pedidos");
			modal.showAndWait();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public void menuDicasClick() {
		Stage modal = new Stage();
		modal.initOwner(new Stage());
		modal.initModality(Modality.APPLICATION_MODAL);
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("crud/DicasView.fxml"));
			Scene cenario = new Scene(janela,800,400);
			cenario.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			modal.setScene(cenario);
			modal.setTitle("Clientes");
			modal.showAndWait();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
