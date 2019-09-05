package view.crud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.dao.DAO;
import model.entidade.Atividades;
import util.ConnectionFactory;
import util.TextFieldFormatter;

public class EditarAtividadesController {
	
	//Definindo Componentes do FXML
	@FXML
	protected ChoiceBox choiceBoxminPessoas;
	@FXML
	protected ChoiceBox choiceBoxmaxPessoas;
	@FXML
	protected ChoiceBox choiceBoxRamo;
	@FXML
	protected ChoiceBox choiceBoxCategoria;
	@FXML
	protected TextField textFieldNome;
	@FXML
	protected TextField textFieldTempo;
	@FXML
	protected TextArea textAreaDescricao;
	@FXML
	protected TextArea textAreaMateriais;
	@FXML
	protected Button btnAlterar;
	@FXML
	protected Button btnCancelar;
	@FXML
	protected CheckBox checkBoxFisico;
	@FXML
	protected CheckBox checkBoxIntelectual;
	@FXML
	protected CheckBox checkBoxAfetivo;
	@FXML
	protected CheckBox checkBoxSocial;
	@FXML
	protected CheckBox checkBoxEspiritual;
	@FXML
	protected CheckBox checkBoxCarater;
	
	private Atividades atividade;
	
	protected DAO<Atividades, Long> dao;
	
	ObservableList<String> ramos = FXCollections.observableArrayList("Lobinho", "Escoteiro", "Senior", "Pioneiro");
	ObservableList<String> categoria = FXCollections.observableArrayList("Quebra Gelo", "Entre Ramos", "p/ Acampamento" );
	ObservableList<String> numPessoas = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");
	
	@FXML
	public void initialize() {
		dao = new DAO<Atividades, Long>(ConnectionFactory.currentManager(), Atividades.class);
		choiceBoxRamo.setItems(ramos);
		choiceBoxCategoria.setItems(categoria);
		choiceBoxminPessoas.setItems(numPessoas);
		choiceBoxmaxPessoas.setItems(numPessoas);
		
	}
	
	public void alerta(String titulo,String mensagem) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensagem);
		alert.showAndWait();	
	}
	@FXML
	public void btnAlterarAtividade(ActionEvent event) {
		if(isValid()) {
			Atividades atividadeOld = dao.load(this.atividade.getId());
			atividade = SetAtividade(atividadeOld);
			dao.save(atividade);
			alerta("Sucesso!","Atividade alterada com sucesso!");
			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
		}
	}
	
	public Atividades SetAtividade(Atividades atividade) {
		
		atividade.setNome(textFieldNome.getText());
		atividade.setTempo(textFieldTempo.getText());
		atividade.setDescricao(textAreaDescricao.getText());
		atividade.setMaterial(textAreaMateriais.getText());
		atividade.setRamo(choiceBoxRamo.getValue());
		atividade.setCategoria(choiceBoxCategoria.getValue());
		atividade.setMinPessoas(choiceBoxminPessoas.getValue());
		atividade.setMaxPessoas(choiceBoxmaxPessoas.getValue());
		atividade.setFisico(checkBoxFisico.isSelected());
		atividade.setIntelectual(checkBoxIntelectual.isSelected());
		atividade.setAfetivo(checkBoxAfetivo.isSelected());
		atividade.setSocial(checkBoxSocial.isSelected());
		atividade.setEspiritual(checkBoxEspiritual.isSelected());
		atividade.setCarater(checkBoxCarater.isSelected());
		
		return atividade;
	}
	
	public void loadAtividade(Atividades atividade) {
		this.atividade = atividade;
		
		textFieldNome.setText(atividade.getNome());
		textFieldTempo.setText(atividade.getTempo());
		textAreaDescricao.setText(atividade.getDescricao());
		textAreaMateriais.setText(atividade.getMaterial());
		choiceBoxRamo.setValue(atividade.getRamo());
		choiceBoxCategoria.setValue(atividade.getCategoria());
		choiceBoxminPessoas.setValue(atividade.getMinPessoas());
		choiceBoxmaxPessoas.setValue(atividade.getMaxPessoas());
		checkBoxFisico.setSelected(atividade.getFisico());
		checkBoxIntelectual.setSelected(atividade.getIntelectual());
		checkBoxAfetivo.setSelected(atividade.getAfetivo());
		checkBoxSocial.setSelected(atividade.getSocial());
		checkBoxEspiritual.setSelected(atividade.getEspiritual());
		checkBoxCarater.setSelected(atividade.getCarater());
		
	}
	
	public boolean isValid() {
		if(textFieldNome.getText().isEmpty()) {
			alerta("Campo Vazio!","Digite um nome para a atividade");
			return false;
		}
		if(choiceBoxminPessoas.getValue() == null) {
			alerta("Campo Vazio!","Selecione a quantidade mínima de participantes");
			return false;
		}
		if(choiceBoxmaxPessoas.getValue() == null) {
			alerta("Campo vazio!", "Selecione a quantidade máxima de participantes");
			return false;
		}
		if(Integer.parseInt((String) choiceBoxminPessoas.getValue()) >= Integer.parseInt((String) choiceBoxmaxPessoas.getValue())) {
			alerta("Campo Inválido", "Número mínimo é maior ou igual ao número máximo de participantes");
			return false;
		}
		if(textFieldTempo.getText().isEmpty()) {
			alerta("Campo vazio!","Digite o tempo de duração da atividade");
			return false;
		}
		if(choiceBoxCategoria.getValue() == null) {
			alerta("Categoria inválida", "Categoria não foi selecionada");
			return false;
		}
		if(textAreaDescricao.getText().isEmpty()) {
			alerta("Campo Vazio!","Digite a descrição da atividade");
			return false;
		}
		if(textAreaMateriais.getText().isEmpty()) {
			alerta("Campo Vazio!","Digite os materiais para a atividade");
			return false;
		}
		if(choiceBoxRamo.getValue() == null) {
			alerta("Ramo Inválido", "Ramo não foi selecionado");
			return false;
		}
		
		return true;
	}
		
	public void tfTempo() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("### Minutos");
		tff.setvalidCharacters("0123456789");
		tff.setTf(textFieldTempo);
		tff.formatter();
	}
	
	
}
