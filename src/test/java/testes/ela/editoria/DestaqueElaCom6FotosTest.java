package testes.ela.editoria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.ela.editoria.DestaqueElaCom6Fotos;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class DestaqueElaCom6FotosTest {
	
	private static DestaqueElaCom6Fotos destaque;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		destaque = new DestaqueElaCom6Fotos(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		destaque.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void exibiuBoxDeDestaqueHorizontal(){
		assertTrue(destaque.exibiuDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void exibiuFotoDoDestaqueHorizontal(){
		destaque.executarScroll(destaque.acessaFotoDestaqueHorizontal().getLocation());
		assertTrue(destaque.exibiuFotoDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAFotoDoDestaqueHorizontalEstaComOCropCorreto(){
		assertTrue(destaque.exibiuHeightWidthCropCorretoParaODestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void exibiuTituloDoDestaqueHorizontal(){
		assertTrue(destaque.exibiuTituloDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void exibiuTituloDoDestaqueHorizontalComNoMaximo96Caracteres(){
		assertTrue(destaque.exibiuTituloDoDestaqueHorizontalComNoMaximo96Caracteres());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void exibiuLinkNoTituloDoDestaqueHorizontal(){
		assertTrue(destaque.exibiuLinkNoTituloDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void exibiuDescricaoDaMateriaDoDestaqueHorizontal(){
		assertTrue(destaque.exibiuDescricaoDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void exibiuDescricaoDaMateriaDoDestaqueHorizontalComNoMaximo143Caracteres(){
		assertTrue(destaque.exibiuDescricaoDoDestaqueHorizontalComNoMaximo143Caracteres());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void exibiuListaDeDestaques(){
		assertTrue(destaque.exibiuListaDeDestaques());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeUmaFotoOuUmaDescricaoEstaSendoExibidaParaODestaque(){
		assertTrue(destaque.exibiuFotoOuDescricaoNosDestaquesDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeUmaFotoDosDestaquesPossuemOCropCorreto(){
		assertTrue(destaque.exibiuFotoDosDestaquesComOCropWidthEHeightCorretos());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeOTituloEstaSendoExibidoEPossuiNoMaximoMaximo96Caracteres(){
		assertTrue(destaque.exibiuTituloComNoMaximo100Caracteres());
	}
}