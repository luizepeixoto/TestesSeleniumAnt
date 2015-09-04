package testes.destaquesSemiAutomaticos;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.destaques.DestaqueCom6Fotos;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class DestaqueCom6FotosTest {
	
	private static DestaqueCom6Fotos destaque;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		destaque = new DestaqueCom6Fotos(Navegador.CHROME);
		destaque.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		destaque.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void exibiuOAntititulo(){
		assertTrue(destaque.exibiuOAntititulo());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void exibiuBoxDeDestaqueHorizontal(){
		assertTrue(destaque.exibiuDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void exibiuFotoDoDestaqueHorizontal(){
		destaque.executarScroll(destaque.acessaFotoDestaqueHorizontal().getLocation());
		assertTrue(destaque.exibiuFotoDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAFotoDoDestaqueHorizontalEstaComOCropCorreto(){
		assertTrue(destaque.exibiuHeightWidthCropCorretoParaODestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void exibiuTituloDoDestaqueHorizontal(){
		assertTrue(destaque.exibiuTituloDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void exibiuTituloDoDestaqueHorizontalComNoMaximo96Caracteres(){
		assertTrue(destaque.exibiuTituloDoDestaqueHorizontalComNoMaximo96Caracteres());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void exibiuLinkNoTituloDoDestaqueHorizontal(){
		assertTrue(destaque.exibiuLinkNoTituloDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void exibiuDescricaoDaMateriaDoDestaqueHorizontal(){
		assertTrue(destaque.exibiuDescricaoDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void exibiuDescricaoDaMateriaDoDestaqueHorizontalComNoMaximo143Caracteres(){
		assertTrue(destaque.exibiuDescricaoDoDestaqueHorizontalComNoMaximo143Caracteres());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void exibiuListaDeDestaques(){
		assertTrue(destaque.exibiuListaDeDestaques());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeUmaFotoOuUmaDescricaoEstaSendoExibidaParaODestaque(){
		assertTrue(destaque.exibiuFotoOuDescricaoNosDestaquesDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeUmaFotoDosDestaquesPossuemOCropCorreto(){
		assertTrue(destaque.exibiuFotoDosDestaquesComOCropWidthEHeightCorretos());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOTituloEstaSendoExibidoEPossuiNoMaximoMaximo96Caracteres(){
		assertTrue(destaque.exibiuTituloComNoMaximo100Caracteres());
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeOTituloMaisSobreEstaSendoExibido(){
		assertTrue(destaque.exibiuTituloMaisSobre());
	}
}