package testes.destaquesSemiAutomaticos;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.destaques.DestaqueCom4FotosAbaixo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;

public class DestaqueCom4FotosAbaixoTest {
	
	private static DestaqueCom4FotosAbaixo ultimas;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		ultimas = new DestaqueCom4FotosAbaixo(Navegador.CHROME);
		ultimas.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		ultimas.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void exibiuOAntititulo(){
		assertTrue(ultimas.exibiuOAntititulo());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void exibiuBoxDeDestaqueHorizontal(){
		assertTrue(ultimas.exibiuDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void exibiuFotoDoDestaqueHorizontal(){
		assertTrue(ultimas.exibiuFotoDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAFotoDoDestaqueHorizontalEstaComOCropCorreto(){
		assertTrue(ultimas.exibiuHeightWidthCropCorretoParaODestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void exibiuTituloDoDestaqueHorizontal(){
		ultimas.executaScrollParaAparecerOTituloDeUmaPosicao(ultimas.acessaTituloDoDestaqueHorizontal());
		assertTrue(ultimas.exibiuTituloDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void exibiuTituloDoDestaqueHorizontalComNoMaximo96Caracteres(){
		assertTrue(ultimas.exibiuTituloDoDestaqueHorizontalComNoMaximo96Caracteres());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void exibiuLinkNoTituloDoDestaqueHorizontal(){
		assertTrue(ultimas.exibiuLinkNoTituloDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void exibiuDescricaoDaMateriaDoDestaqueHorizontal(){
		assertTrue(ultimas.exibiuDescricaoDoDestaqueHorizontal());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void exibiuDescricaoDaMateriaDoDestaqueHorizontalComNoMaximo143Caracteres(){
		assertTrue(ultimas.exibiuDescricaoDoDestaqueHorizontalComNoMaximo143Caracteres());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void exibiuListaDeDestaques(){
		assertTrue(ultimas.exibiuListaDeDestaques());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeUmaFotoOuUmaDescricaoEstaSendoExibidaParaODestaque(){
		assertTrue(ultimas.exibiuFotoOuDescricaoNosDestaquesDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeUmaFotoDosDestaquesPossuemOCropCorreto(){
		assertTrue(ultimas.exibiuFotoDosDestaquesComOCropWidthEHeightCorretos());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOTituloEstaSendoExibidoEPossuiNoMaximoMaximo96Caracteres(){
		assertTrue(ultimas.exibiuTituloComNoMaximo100Caracteres());
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeOTituloMaisSobreEstaSendoExibido(){
		assertTrue(ultimas.exibiuTituloMaisSobre());
	}
}