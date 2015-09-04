package pages.ela.materia.widget;

import pages.materia.widget.BoxFotogaleriaInline;
import br.com.infoglobo.pages.Navegador;

public class BoxFotogaleriaInlineEla extends BoxFotogaleriaInline {

	public BoxFotogaleriaInlineEla(Navegador navegador) throws Exception {
		super(navegador);
	}

	public boolean exibiuOCssCorretoNasLegendasEAutores() {
		return false;
	}
}