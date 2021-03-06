package pages.capa.meio;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxDeVideos extends AceitacaoAbstractTest {
	
	public BoxDeVideos() throws Exception {
		super();
	}
	
	public WebElement getBoxDeVideosDaCapa() {
		return getDriver().findElement(By.className("galeria-videos"));
	}
	
	public List<WebElement> getListaVideosSecundariosDoBoxDeVideosDaCapa() {
		WebElement galeriaVideos = getBoxDeVideosDaCapa();
		if (galeriaVideos != null) {
			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.className("outros-videos")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
		} else {
			return new ArrayList<WebElement>();
		}
	}
	
	public boolean getBoxDeVideosEstaSendoExibido() {
		return getBoxDeVideosDaCapa() != null;
	}

	public boolean getTituloDoBoxDeVideos() {
		WebElement galeriaVideos = getBoxDeVideosDaCapa();
		if(galeriaVideos != null) {
			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.className("title")) != null;
		}
		
		return false;
	}

	public boolean getLinkParaTodosOsVideosDoBoxDeVideosEstaSendoExibido() {
		WebElement galeriaVideos = getBoxDeVideosDaCapa();
		if(galeriaVideos != null) {
			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.className("mais-videos")) != null;
		}
		
		return false;
	}

	public boolean getVideoEmDestaqueDoBoxDeVideosEstaSendoExibido() {
		WebElement galeriaVideos = getBoxDeVideosDaCapa();
		if(galeriaVideos != null) {
			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.tagName("div")).findElement(By.id("play")) != null;
		}
		
		return false;
	}

	public boolean getAntitituloDoVideoEmDestaqueDoBoxDeVideosEstaSendoExibido() {
		WebElement galeriaVideos = getBoxDeVideosDaCapa();
		if(galeriaVideos != null) {
			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.tagName("div")).findElement(By.className("editoria")) != null;
		}
		
		return false;
	}

	public boolean getTituloDoVideoEmDestaqueDoBoxDeVideosEstaSendoExibido() {
		WebElement galeriaVideos = getBoxDeVideosDaCapa();
		if(galeriaVideos != null) {
			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.tagName("div")).findElement(By.className("titulo")) != null;
		}
		
		return false;
	}

	public boolean getAreaDeOutrosVideosDoBoxDeVideosEstaSendoExibida() {
		WebElement galeriaVideos = getBoxDeVideosDaCapa();
		if(galeriaVideos != null) {
			return galeriaVideos.findElement(By.className("conteudo")).findElement(By.className("outros-videos")) != null;
		}
		
		return false;
	}

	public boolean getAreaDeOutrosVideosDoBoxDeVideosEstaExibindoQuatroVideos() {
		WebElement galeriaVideos = getBoxDeVideosDaCapa();
		if(galeriaVideos != null) {
			return getListaVideosSecundariosDoBoxDeVideosDaCapa().size() == 4;
		}
		return false;
	}

	public boolean getVideoQueEstaEmDestaqueEstaCobertoPeloQuadroAssistindoNoBoxDeVideos() {
		return false;
	}

	public boolean getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(0).findElement(By.tagName("a")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(0).findElement(By.tagName("a")).findElement(By.tagName("img")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(0).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("editoria")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getPrimeiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(0).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("titulo")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(1).findElement(By.tagName("a")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(1).findElement(By.tagName("a")).findElement(By.tagName("img")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(1).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("editoria")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getSegundoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(1).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("titulo")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public boolean getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(2).findElement(By.tagName("a")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(2).findElement(By.tagName("a")).findElement(By.tagName("img")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(2).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("editoria")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getTerceiroVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(2).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("titulo")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public boolean getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiLink() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(3).findElement(By.tagName("a")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiImagem() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(3).findElement(By.tagName("a")).findElement(By.tagName("img")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiAntititulo() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(3).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("editoria")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean getQuartoVideoDaAreaDeOutrosVideosDoBoxDeVideosPossuiTitulo() {
		List<WebElement> listaVideosSecundarios = getListaVideosSecundariosDoBoxDeVideosDaCapa();
		try {
			return (listaVideosSecundarios.get(3).findElement(By.tagName("a")).findElement(By.className("info")).findElement(By.className("titulo")) != null);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
}
