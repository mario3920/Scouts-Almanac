package view.crud;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.dao.DAO;
import model.entidade.Acessos;
import model.entidade.Atividades;
import util.AcessosController;
import util.ConnectionFactory;

public class AtividadesController {

	@FXML
	protected GridPane gridClientes;
	@FXML
	protected Button btnRemover;
	@FXML
	protected Button btnEditar;
	
	protected TableViewController<Atividades> tableView;
	protected DAO<Atividades, Long> dao;
	protected AcessosController login = new AcessosController();
	
	private Acessos acesso = new Acessos();
	
	@FXML
	public void initialize() {
		dao = new DAO<Atividades, Long>(ConnectionFactory.currentManager(), Atividades.class);
		tabelaConfig();
		tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
		        	Atividades atividade = tableView.getSelectionModel().getSelectedItem();
		        	Stage modal = new Stage();
		    		modal.initOwner(new Stage());
		    		modal.initModality(Modality.APPLICATION_MODAL);
		    		try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("VisualizarAtividadesView.fxml"));
						BorderPane janela = (BorderPane) loader.load();
						
						VisualizarAtividadesController visualizarAtividadesController = loader.getController();
						visualizarAtividadesController.loadAtividade(atividade);
						
						Scene cenario = new Scene(janela,800,400);
						cenario.getStylesheets().add(getClass().getResource("/view/design.css").toExternalForm());
						modal.setScene(cenario);
						modal.setTitle("Clientes");
						modal.showAndWait();
		    		} catch(Exception e) {
		    			e.printStackTrace();
		    		}                   
		        }
		    }
		});
	}
	
	@FXML
	public void menuCadastrarClick() {
		Stage modal = new Stage();
		modal.initOwner(new Stage());
		modal.initModality(Modality.APPLICATION_MODAL);
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("CadastrarAtividadesView.fxml"));
			Scene cenario = new Scene(janela,800,400);
			cenario.getStylesheets().add(getClass().getResource("/view/design.css").toExternalForm());
			modal.setScene(cenario);
			modal.setTitle("Cadastrar Atividade");
			modal.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateTableView() {
		tableView.getItems().clear();
		tableView.getItems().addAll(getAtividades());
	}
	
	public ObservableList<Atividades> getAtividades() {
		List<Atividades> atividades = dao.list();
		ObservableList<Atividades> lista = FXCollections.observableArrayList();
		for (Atividades atividade : atividades) {
				lista.add(atividade);
		}
		return lista;
	}
	public void tabelaConfig() {
		tableView = new TableViewController<>(Atividades.class,"ramo", "categoria", "nome", "tempo", "area_de_desenvolvimento");
		gridClientes.getChildren().add(tableView);
		updateTableView();
	}
	
	public boolean selectAtividade() {
		Atividades atividade = tableView.getSelectionModel().getSelectedItem();
		if(atividade == null) {
			alerta("Atividade inválida!","A atividade não foi selecionada corretamente");
			return false;
		}
		return true;
	}
	
	
	@FXML
	public void btnRemoveClick(ActionEvent event) {
		if(selectAtividade()== true) {
			Stage modal = new Stage();
			modal.initOwner(new Stage());
			modal.initModality(Modality.WINDOW_MODAL);
			try {
				acesso.setLogado(false);
				FXMLLoader loader =new FXMLLoader(getClass().getResource("/util/AcessosView.fxml"));
				BorderPane janela = (BorderPane) loader.load();
				
				AcessosController acController = loader.getController();
				acController.setAcesso(acesso);
				
				
				Scene cenario = new Scene(janela,300,150);
				cenario.getStylesheets().add(getClass().getResource("/view/design.css").toExternalForm());
				modal.setScene(cenario);
				modal.showAndWait();
			} catch(Exception e) {
				e.printStackTrace();
			}

			if(acesso.getLogado() == true) {
				Atividades atividade = tableView.getSelectionModel().getSelectedItem(); 
					dao.load(atividade.getId());
					dao.delete(atividade);
					updateTableView();
			}
		}
	}
	
	@FXML
	public void btnEditClick(ActionEvent event) {
		if(selectAtividade()) {
			Atividades atividade = tableView.getSelectionModel().getSelectedItem();
			Stage modal = new Stage();
			modal.initOwner(new Stage());
			modal.initModality(Modality.APPLICATION_MODAL);
			try {
				acesso.setLogado(false);
				FXMLLoader loader =new FXMLLoader(getClass().getResource("/util/AcessosView.fxml"));
				BorderPane janela = (BorderPane) loader.load();
				
				AcessosController acController = loader.getController();
				acController.setAcesso(acesso);
				
				
				Scene cenario = new Scene(janela,300,150);
				cenario.getStylesheets().add(getClass().getResource("/view/design.css").toExternalForm());
				modal.setScene(cenario);
				modal.showAndWait();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			if(acesso.getLogado() == true) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarAtividadesView.fxml"));
					BorderPane janela = (BorderPane) loader.load();
					
					EditarAtividadesController editarAtividadesController = loader.getController();
					editarAtividadesController.loadAtividade(atividade);
					
					Scene cenario = new Scene(janela,800,400);
					cenario.getStylesheets().add(getClass().getResource("/view/design.css").toExternalForm());
					modal.setScene(cenario);
					modal.setTitle("Clientes");
					modal.showAndWait();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void alerta(String titulo,String mensagem) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensagem);
		alert.showAndWait();	
	}
	
}
