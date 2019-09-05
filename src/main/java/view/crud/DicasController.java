package view.crud;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.dao.DAO;
import model.entidade.Cliente;
import util.ConnectionFactory;

public class DicasController {

	@FXML
	protected GridPane gridClientes;
	@FXML
	protected Button btnRemover;
	@FXML
	protected Button btnEditar;
	
	protected TableViewController<Cliente> tableView;
	protected DAO<Cliente, Long> dao;
	
	@FXML
	public void initialize() {
		dao = new DAO<Cliente, Long>(ConnectionFactory.currentManager(), Cliente.class);
		tabelaConfig();
	}
	
	@FXML
	public void menuCadastrarClick() {
		Stage modal = new Stage();
		modal.initOwner(new Stage());
		modal.initModality(Modality.APPLICATION_MODAL);
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("CadastrarView.fxml"));
			Scene cenario = new Scene(janela,800,400);
			cenario.getStylesheets().add(getClass().getResource("/view/design.css").toExternalForm());
			modal.setScene(cenario);
			modal.setTitle("Clientes");
			modal.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateTableView() {
		tableView.getItems().clear();
		tableView.getItems().addAll(getClientes());
	}
	
	public ObservableList<Cliente> getClientes() {
		List<Cliente> clientes = dao.list();
		ObservableList<Cliente> lista = FXCollections.observableArrayList();
		for (Cliente cliente : clientes) {
				lista.add(cliente);
		}
		return lista;
	}
	public void tabelaConfig() {
		tableView = new TableViewController<>(Cliente.class, "id", "nome", "email", "cpf", "telefone", "endereco", "numero", "cep", "bairro", "complemento");
		gridClientes.getChildren().add(tableView);
		updateTableView();
	}
	
	public boolean selectCliente() {
		Cliente cliente = tableView.getSelectionModel().getSelectedItem();
		if(cliente == null) {
			alerta("Cliente inválido!","O cliente não foi selecionado corretamente!");
			return false;
		}
		return true;
	}
	@FXML
	public void btnRemoveClick(ActionEvent event) {
		if(selectCliente()) {
			Cliente cliente = tableView.getSelectionModel().getSelectedItem();
			dao.load(cliente.getId());
			dao.delete(cliente);
			updateTableView();
		}
	}
	
	@FXML
	public void btnEditClick(ActionEvent event) {
		if(selectCliente()) {
			Stage modal = new Stage();
			modal.initOwner(new Stage());
			modal.initModality(Modality.APPLICATION_MODAL);
			
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarCliente.fxml"));
				BorderPane janela = (BorderPane) loader.load();
				
				//EditarClienteController editarClienteController = loader.getController();
				//editarClienteController.loadCliente(cliente);
				
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
	
	public void alerta(String titulo,String mensagem) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensagem);
		alert.showAndWait();	
	}
	
}
