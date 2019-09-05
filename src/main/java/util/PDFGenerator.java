package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class PDFGenerator<E> {
	private String path; // Caminho base

	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper

	private List<E> objetos = new ArrayList<>(); 
	
	// Recupera os caminhos para que a classe possa encontrar os relatórios
	public PDFGenerator() {
		this.path = "/Users/mariomassari/Desktop/Workspace/Projeto GE/src/main/java/util/Relatorio.jasper";
		System.out.println(path);
	}

	public void imprimir() throws Exception {

		// Segundo passo: Obter lista com objetos Pedido. Para este exemplo foi criado
		// um PedidoDAO
		//List<Atividades> dadosRelatorio = new ArrayList<>();
		//Atividades atividade = new Atividades();
		//atividade.setNome("HELLO ATIVIDADE UM");
		//dadosRelatorio.add(atividade);

		// Terceiro passo: Criar o data source
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(getListaObjetos());

		// Quarto passo: criar HashMap com os parâmetros dos relatórios
		Map<String, Object> parametros = new HashMap<String, Object>();

		// Caminho do diretório onde está o jasper do sub-relatório

		JasperPrint impressao = null;
		try {
			// Quinto passo: preencher o relatório
			impressao = JasperFillManager.fillReport(this.path, parametros, ds);
			// Sexto passo: mostrar o relatório
			JasperViewer viewer = new JasperViewer(impressao, false);
			viewer.setVisible(true);
		} catch (JRException e) {
			System.out.println(e.getMessage());
		}

	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

	public String getPath() {
		return this.path;
	}
	
	public List<E> getListaObjetos() {
		return objetos;
	}
}
