package pages.ela.materia.widget;

import pages.materia.widget.BoxCitacao;
import br.com.infoglobo.pages.Navegador;

public class BoxCitacaoEla extends BoxCitacao {
	
	public BoxCitacaoEla(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean exibiuOBoxCitacaoSemBorda() {
		return getBoxCitacao().getCssValue("border").equals("0px none rgb(0, 0, 0)");
	}
	
	public boolean exibiuAFonteCorretaNoBoxCitacao() {
		return getBoxCitacao().getCssValue("font-family").equals("OgloboXCondensed, sans-serif");
	}

	public boolean exibiuOCssCorretoNaFrase() {
		//Cor
		String corEsperada = "rgba(2, 2, 2, 1)";
		if (! obterFraseDoBox().getCssValue("color").equals(corEsperada)) {
			System.out.println("A frase não está sendo exibida com a cor esperada.");
			return false;
		}
		//Altura linha
		String alturaEsperada = "25px";
		if (! obterFraseDoBox().getCssValue("line-height").equals(alturaEsperada)) {
			System.out.println("A frase não está sendo exibida com a altura da linha esperada.");
			return false;
		}
		//Tamanho fonte
		String tamanhoEsperado = "25px";
		if (! obterFraseDoBox().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("A frase não está sendo exibida com o tamanho da fonte esperado.");
			return false;
		}
		//Estilo fonte
		String estiloEsperado = "italic";
		if (! obterFraseDoBox().getCssValue("font-style").equals(estiloEsperado)) {
			System.out.println("A frase não está sendo exibida com o estilo da fonte esperado.");
			return false;
		}
		return true;
	}

	public boolean exibiuOCssCorretoNoAutor() {
		//Cor
		String corEsperada = "rgba(0, 0, 0, 1)";
		if (! obterAutorDaFrase().getCssValue("color").equals(corEsperada)) {
			System.out.println("O autor não está sendo exibido com a cor esperada.");
			return false;
		}
		//Alinhamento
		String alinhamentoEsperado = "right";
		if (! obterAutorDaFrase().getCssValue("text-align").equals(alinhamentoEsperado)) {
			System.out.println("O autor não está sendo exibido com o alinhamento esperado.");
			return false;
		}
		//Tamanho fonte
		String tamanhoEsperado = "21px";
		if (! obterAutorDaFrase().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("O autor não está sendo exibido com o tamanho da fonte esperado.");
			return false;
		}
		//Peso fonte
		String pesoEsperado = "600";
		if (! obterAutorDaFrase().getCssValue("font-weight").equals(pesoEsperado)) {
			System.out.println("O autor não está sendo exibido com o peso da fonte esperado.");
			return false;
		}
		//Estilo fonte
		String estiloEsperado = "uppercase";
		if (! obterAutorDaFrase().getCssValue("text-transform").equals(estiloEsperado)) {
			System.out.println("O autor não está sendo exibido com o estilo da fonte esperado.");
			return false;
		}
		return true;
	}

	public boolean exibiuOCssCorretoNoCargoDoAutor() {
		//Cor
		String corEsperada = "rgba(116, 116, 116, 1)";
		if (! obterCargoDoAutor().getCssValue("color").equals(corEsperada)) {
			System.out.println("O cargo do autor não está sendo exibido com a cor esperada.");
			return false;
		}
		//Alinhamento
		String alinhamentoEsperado = "right";
		if (! obterCargoDoAutor().getCssValue("text-align").equals(alinhamentoEsperado)) {
			System.out.println("O cargo do autor não está sendo exibido com o alinhamento esperado.");
			return false;
		}
		//Tamanho fonte
		String tamanhoEsperado = "20px";
		if (! obterCargoDoAutor().getCssValue("font-size").equals(tamanhoEsperado)) {
			System.out.println("O cargo do autor não está sendo exibido com o tamanho da fonte esperado.");
			return false;
		}
		return true;
	}
}