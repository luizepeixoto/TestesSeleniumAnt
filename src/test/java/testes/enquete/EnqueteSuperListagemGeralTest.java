package testes.enquete;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.enquete.EnqueteSuperPaginaGeral;


public class EnqueteSuperListagemGeralTest {
	
	private static EnqueteSuperPaginaGeral enquete;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		enquete = new EnqueteSuperPaginaGeral();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		enquete.fechar();
	}
	
	/*	Matéria dever ser configurada com:
			Opção de busca habilitada
			Mais de uma opção no menu de enquetes
			Lista de opções para a enquete apresentada
			Cada uma das opções deve possui foto, subtítulo e descrição
	 */	
	
	@Test
	public void verificaSeOMenuDeEnquetesDisponiveisEstaSendoExibido(){
		assertNotNull(enquete.exibiuMenuDeEnquetesDisponiveis());
	}
	
	@Test
	public void verificaSeOMenuDeEnquetesDisponiveisPossuiMaisDeUmaOpcao(){
		assertTrue(enquete.exibiuMaisDeUmaOpcaoParaAsEnquetes());
	}
	
	@Test
	public void verificaSeAsOpcoesDeEnquetesDisponiveisPossuemUmTitulo(){
		assertTrue(enquete.exibiuUmTituloParaCadaUmaEnquetesDisponiveis());
	}
	
	@Test
	public void verificaSeAsOpcoesDeEnquetesDisponiveisPossuemUmLink(){
		assertTrue(enquete.exibiuUmLinkEmCadaUmDosTituloDasEnquetesDisponiveis());
	}
	
	@Test
	public void verificaSeAOpcaoDeBuscaDasEnquetesEstaSendoExibida(){
		assertTrue(enquete.exibiuBusca());
	}
	
	@Test
	public void verificaSeOTituloDaEnqueteEstaSendoExibido(){
		assertTrue(enquete.exibiuTituloDaEnquete());
	}
	
	@Test
	public void verificaSeAEnqueteEstaExibidoUmaListaDeOpcoes(){
		assertTrue(enquete.exibiuListaDeOpcoes());
	}
	
	@Test
	public void verificaSeCadaUmaDasOpcoesPossuiUmaFoto(){
		assertTrue(enquete.exibiuAsOpcoesDeVotoComUmaImagem());
	}
	
	@Test
	public void verificaSeAlgumaDasFotosApresentadaNasOpcoesEstaExibindoOFlagAzulDeVotado(){
		assertTrue(enquete.exibiuAsFlagDeVotadoEmAlgumaFoto());
	}
	
	@Test
	public void verificaSeCadaUmaDasOpcoesPossuiUmTitulo(){
		assertTrue(enquete.exibiuAsOpcoesDeVotoComUmTitulo());
	}
	
	@Test
	public void verificaSeCadaUmaDasOpcoesPossuiUmSubtitulo(){
		assertTrue(enquete.exibiuAsOpcoesDeVotoComUmSubtitulo());
	}
	
	@Test
	public void verificaSeCadaUmaDasOpcoesPossuiUmaDescricao(){
		assertTrue(enquete.exibiuAsOpcoesDeVotoComUmaDescricao());
	}
	
	@Test
	public void verificaSeCadaUmaDasOpcoesPossuiUmBotaoDeVotar(){
		assertTrue(enquete.exibiuOBotaoDeVotarEmCadaUmaDasOpcoes());
	}
	
	@Test
	public void verificaSeOBotaoDeVotarDeCadaUmaDasOpcoesPossuiUmLink(){
		assertTrue(enquete.exibiuOBotaoDeVotarComUmLink());
	}
	
	@Test
	public void verificaSeCadaUmDosBotoesDeVotarPossuiOTituloCorreto(){
		assertTrue(enquete.exibiuOTituloVotar());
	}
}