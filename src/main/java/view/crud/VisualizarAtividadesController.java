package view.crud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.dao.DAO;
import model.entidade.Atividades;
import util.ConnectionFactory;
import util.PDFGenerator;
import util.TextFieldFormatter;

public class VisualizarAtividadesController {
	
	private PDFGenerator<Atividades> relatorioAtividades = new PDFGenerator<>();
	
	//Definindo Componentes do FXML
	@FXML
	protected Button PDFGenerator;
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
	
	public void loadAtividade(Atividades atividade) {
		this.atividade = atividade;
		
		textFieldNome.setText(atividade.getNome());
		textFieldNome.setEditable(false);
		textFieldTempo.setText(atividade.getTempo());
		textFieldTempo.setEditable(false);
		textAreaDescricao.setText(atividade.getDescricao());
		textAreaDescricao.setEditable(false);
		textAreaMateriais.setText(atividade.getMaterial());
		textAreaMateriais.setEditable(false);
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
	
	public void tfTempo() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("### Minutos");
		tff.setvalidCharacters("0123456789");
		tff.setTf(textFieldTempo);
		tff.formatter();
	}
	@FXML
	public void btnGerarPDF() throws Exception {
		relatorioAtividades.getListaObjetos().add(atividade);
		relatorioAtividades.imprimir();
	}
	
	
	
}
