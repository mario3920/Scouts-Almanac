package util;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entidade.Acessos;


public class AcessosController {
	@FXML
	private TextField textFieldUsuario;
	@FXML
	private PasswordField passwordFieldSenha;
	@FXML
	private Button buttonLogin;
	
	private Acessos acesso;
	
	@FXML
	public Acessos valContas(Event event) {
		Acessos acessos = this.acesso;
		acesso.setUsuario(textFieldUsuario.getText());
		acesso.setSenha(Integer.parseInt(passwordFieldSenha.getText()));
		
		String diretoria = "DIRETORIA";
		int senhaDiretoria = 1234;
		
		String lobinho = "LOBINHO";
		int senhaLobinho = 1248;
		
		String escoteiro = "ESCOTEIRO";
		int senhaescoteiro = 1234;
		
		String senior = "SENIOR";
		int senhaSenior = 1234;
		
		String pioneiro = "PIONEIRO";
		int senhaPioneiro = 1234;
		
		String mario = "MARIO";
		int senhaMario = 392027;
	
		if(acessos.getUsuario().equalsIgnoreCase(diretoria) && acessos.getSenha() == senhaDiretoria) {
			alerta("Sucesso","Login efetuado com sucesso!");
			acessos.setLogado(true);
			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
			return acessos;
		}
		if(acessos.getUsuario().equalsIgnoreCase(lobinho) && acessos.getSenha() == senhaLobinho) {
			alerta("Sucesso","Login efetuado com sucesso!");
			acessos.setLogado(true);
			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
			return acessos;
		}
		if(acessos.getUsuario().equalsIgnoreCase(escoteiro) && acessos.getSenha() == senhaescoteiro) {
			alerta("Sucesso","Login efetuado com sucesso!");
			acessos.setLogado(true);
			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
			return acessos;
		}
		if(acessos.getUsuario().equalsIgnoreCase(senior) && acessos.getSenha() == senhaSenior) {
			alerta("Sucesso","Login efetuado com sucesso!");
			acessos.setLogado(true);
			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
			return acessos;
		}
		if(acessos.getUsuario().equalsIgnoreCase(pioneiro) && acessos.getSenha() == senhaPioneiro) {
			alerta("Sucesso","Login efetuado com sucesso!");
			acessos.setLogado(true);
			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
			return acessos;
		}
		if(acessos.getUsuario().equalsIgnoreCase(mario) && acessos.getSenha() == senhaMario) {
			alerta("Sucesso","Login efetuado com sucesso!");
			acessos.setLogado(true);
			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
			return acessos;
		}
		else {
			alerta("Conta inválida!","Conta de acesso nao é válida!");
			return null;
		}
	}
	
	public boolean openLogin(Acessos acesso) {
		setAcesso(acesso);
		Stage modal = new Stage();
		modal.initOwner(new Stage());
		modal.initModality(Modality.WINDOW_MODAL);
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("AcessosView.fxml"));
			Scene cenario = new Scene(janela,300,150);
			cenario.getStylesheets().add(getClass().getResource("/view/design.css").toExternalForm());
			modal.setScene(cenario);
			modal.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void alerta(String titulo,String mensagem) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensagem);
		alert.showAndWait();	
	}
	
	public void setAcesso(Acessos acesso) {
		this.acesso = acesso;
	}
	
	
}