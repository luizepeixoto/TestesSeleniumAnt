package pages.fotogaleria;

import br.com.infoglobo.pages.Device;
import br.com.infoglobo.pages.Navegador;

public class FotogaleriaLinkRelacionado extends Fotogaleria {
	
	public FotogaleriaLinkRelacionado() throws Exception {
		super();
	}
	
	public FotogaleriaLinkRelacionado(Navegador navegador) throws Exception {
		super(navegador);
	}

	public FotogaleriaLinkRelacionado(Navegador navegador, Device device) throws Exception {
		super(navegador, device);
	}
}