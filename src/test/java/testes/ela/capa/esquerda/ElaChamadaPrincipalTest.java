package testes.ela.capa.esquerda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.ela.capa.esquerda.ElaCapaDaEsquerda;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class ElaChamadaPrincipalTest {
	
		//Matéria na primeira posição. Contendo:
		//	- Chamada tipo Nenhum contendo: titulo, descrição e comentários sendo exibidos
		//	- Chamada secundária contendo: exibindo foto, descrição, autor e comentários
		//	- Duas Chamadas de opinião contendo: Foto, antitítulo, Autor, Descrição 
	
	private static ElaCapaDaEsquerda capa;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new ElaCapaDaEsquerda(Navegador.CHROME);
		capa.executaScrollParaAparecerOTituloDeUmaPosicao(capa.acessaChamadaPrincipal());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxDaChamadaPrincipalEstaSendoExibida(){
		assertNotNull(capa.exibiuChamadaPrincipal());
	}
	
	/*Validação da matéria chamada principal*/
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeAEditoriaDaChamadaPrincipalEstaSendoExibida(){
		assertTrue(capa.exibiuEditoriaNaChamadaPrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOLayoutDaEditoriaDaChamadaPrincipalEstaCorreto(){
		assertTrue(capa.exibiuLayoutCorretoParaAEditoriaDoEla());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAEditoriaDaChamadaPrincipalPossuiUmLink(){
		assertTrue(capa.exibiuLinkNaEditoriaDaChamadaPrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAMateriaDaChamadaPrincipalPossuiUmaImagem(){
		assertTrue(capa.exibiuImagemNaChamadaPrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeImagemDaChamadaPrincipalPossuiWidthHeightCropsEsperados(){
		assertTrue(capa.exibiuWidthHeightECropCorretoParaAImagemNaMateriaDaChamadaPrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeAMateriaDaChamadaPrincipalPossuiUmTitulo(){
		assertTrue(capa.exibiuTituloDaChamadaPrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeOTituloDaAMateriaDaChamadaPrincipalPossuiOLayoutCorreto(){
		assertTrue(capa.exibiuTituloDaChamadaPrincipalComLayoutCorretoDoEla());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeAMateriaDaChamadaPrincipalPossuiUmTituloComUmLink(){
		assertTrue(capa.exibiuTituloDaChamadaPrincipalComUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeAMateriaDaChamadaPrincipalEstaExibindoOAutor(){
		assertTrue(capa.exibiuAutorDaChamadaPrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeOAutorDaMateriaDaChamadaPrincipalPossuiOLayoutCorreto(){
		assertTrue(capa.exibiuLayoutCorretoParaOAutorDaChamadaPrincipalDoEla());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeADescricaoDaMateriaDaChamadaPrincipalEstaSendoExibida(){
		assertTrue(capa.exibiuDescricaoDaMateriaChamadaPrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOTotalDeComentariosDaChamadaPrincipalEstaSendoExibido(){
		assertTrue(capa.exibiuComentariosParaAChamadaPrincipal());
	}
	
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeOTotalDeComentariosDaChamadaPrincipalPossuiOLayoutCorreto(){
		assertTrue(capa.exibiuLayoutCorretoParaOBalaoDeComentariosDoEla(capa.acessaComentarioDaChamadaPrincipal()));
	}
	
	/*Validação da chamada secundária*/
	@OrdemExecucaoTeste(Ordem=15)
	@Test
	public void verificaSeOBoxDaMateriaDaRelacionadaEstaSendoExibido(){
		assertTrue(capa.exibiuChamadaSecundaria());
	}
	
	@OrdemExecucaoTeste(Ordem=16)
	@Test
	public void verificaSeAMateriaRelacionadaEstaExibindoUmaFoto(){
		assertTrue(capa.exibiuUmaFotoNaChamadaSecundaria());
	}
	
	@OrdemExecucaoTeste(Ordem=17)
	@Test
	public void verificaSeAFotoDaMateriaRelacionadaPossuiAClasseLinkAnimado(){
		assertTrue(capa.exibiuClasseAnimadaParaAImagemDaChamadaSecundaria());
	}
	
	@OrdemExecucaoTeste(Ordem=18)
	@Test
	public void verificaSeAFotoDaMateriaSecundariaPossuiOWidthDe140px(){
		assertTrue(capa.exibiuImagemDaChamadaSecundariaComWidthCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=19)
	@Test
	public void verificaSeAFotoDaMateriaSecundariaPossuiOHeightDe84px(){
		assertTrue(capa.exibiuImagemDaChamadaSecundariaComHeightCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=20)
	@Test
	public void verificaSeAFotoDaMateriaSecundariaPossuiOCropCorreto(){
		assertTrue(capa.exibiuImagemDaChamadaSecundariaComCropCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=21)
	@Test
	public void verificaSeAMateriaSecundariaEstaExibindoUmTitulo(){
		assertTrue(capa.exibiuTituloParaAChamadaSecundaria());
	}
	
	@OrdemExecucaoTeste(Ordem=22)
	@Test
	public void verificaSeAMateriaRelacionadaPossuiUmTituloComUmLink(){
		assertTrue(capa.exibiuUmTituloComLinkParaAChamadaSecundaria());
	}
	
	@OrdemExecucaoTeste(Ordem=23)
	@Test
	public void verificaSeAMateriaRelacionadaEstaExibindoOAutor(){
		assertTrue(capa.exibiuAutorParaAChamadaSecundaria());
	}
	
	@OrdemExecucaoTeste(Ordem=24)
	@Test
	public void verificaSeAMateriaRelacionadaEstaExibindoOAutorComOLayoutCorreto(){
		assertTrue(capa.exibiuLayoutCorretoParaOAutorNaAChamadaSecundariaDoEla());
	}
	
	@OrdemExecucaoTeste(Ordem=25)
	@Test
	public void verificaSeADescricaoDaMateriaRelacionadaEstaSendoExibinda(){
		assertTrue(capa.exibiuDescricaoParaAChamadaSecundaria());
	}
	
	@OrdemExecucaoTeste(Ordem=26)
	@Test
	public void verificaSeOTotalDeComentariosDaMateriaRelacionadaEstaSendoExibido(){
		assertTrue(capa.exibiuLayoutCorretoParaOBalaoDeComentariosDoEla(capa.acessaComentarioDaChamadaSecundaria()));
	}
	
	/*Validação do box de opinião*/
	@OrdemExecucaoTeste(Ordem=27)
	@Test
	public void verificaSeOsBoxDeOpiniaoPossuemUmLink(){
		assertTrue(capa.exibiuLinkNoBoxDeOpiniao());
	}
	@OrdemExecucaoTeste(Ordem=28)
	@Test
	public void verificaSeCadaUmDosBoxDeOpiniaoPossuemOBackgroundCorreto(){
		assertTrue(capa.exibiuBackgroundParaCadaUmDosBoxDeOpiniao());
	}
	
	@OrdemExecucaoTeste(Ordem=29)
	@Test
	public void verificaSeCadaUmDosBoxDeOpiniaoEstaoExibindoUmaImagem(){
		assertTrue(capa.exibiuImagemParaCadaUmDosBoxDeOpiniao());
	}
	
	@OrdemExecucaoTeste(Ordem=30)
	@Test
	public void verificaSeCadaUmDosBoxDeOpiniaoEstaoExibindoUmaImagemComWidthDe60Px(){
		assertTrue(capa.exibiuWidthCorretoParaAsImagemParaCadaUmDosBoxDeOpiniao());
	}
	
	@OrdemExecucaoTeste(Ordem=31)
	@Test
	public void verificaSeCadaUmDosBoxDeOpiniaoEstaoExibindoUmaImagemComHeightDe60Px(){
		assertTrue(capa.exibiuHeightCorretoParaAsImagemParaCadaUmDosBoxDeOpiniao());
	}
	
	@OrdemExecucaoTeste(Ordem=32)
	@Test
	public void verificaSeCadaUmDosBoxDeOpiniaoEstaoExibindoUmaImagemComOCropCorretox(){
		assertTrue(capa.exibiuCropCorretoParaAsImagemParaCadaUmDosBoxDeOpiniao());
	}
	
	@OrdemExecucaoTeste(Ordem=33)
	@Test
	public void verificaSeCadaUmDosBoxDeOpiniaoEstaoExibindoOAntititulo(){
		assertTrue(capa.exibiuAntitituloParaCadaUmDosBoxDeOpiniao());
	}
	
	@OrdemExecucaoTeste(Ordem=34)
	@Test
	public void verificaSeCadaUmDosBoxDeOpiniaoEstaoExibindoOTituloComLayoutCorreto(){
		assertTrue(capa.exibiuAntitituloDosBoxDeOpiniaoComLayoutCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=35)
	@Test
	public void verificaSeOPrimeiroBoxDaWebChamadaEstaExibindoAutor(){
		assertTrue(capa.exibiuAutorParaCadaUmDosBoxDeOpiniao());
	}
	
	@OrdemExecucaoTeste(Ordem=36)
	@Test
	public void verificaSeCadaUmDosBoxDeOpiniaoEstaoExibindoOAutorComLayoutCorreto(){
		assertTrue(capa.exibiuAutorDosBoxDeOpiniaoComLayoutCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=37)
	@Test
	public void verificaSeOsBoxDasWebChamadasEstaoExibindoTituloComNoMaximo44Caracteres(){
		assertTrue(capa.getBoxWebChamadaTitulosBoxMaximoCaracteres());
	}
	
	@OrdemExecucaoTeste(Ordem=38)
	@Test
	public void verificaSeAsDescricoesDasWebChamadasPossuemMaisDe80Caracteres(){
		assertTrue(capa.exibiuTamanhoDoTituloCorreto());
	}
}	