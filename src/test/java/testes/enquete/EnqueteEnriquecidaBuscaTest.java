package testes.enquete;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.enquete.EnqueteEnriquecidaBusca;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class EnqueteEnriquecidaBuscaTest {
	
	private static EnqueteEnriquecidaBusca enqueteSimples;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		enqueteSimples = new EnqueteEnriquecidaBusca(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		enqueteSimples.fechar();
	}
	
	/*	Enquete de bloco de carnaval dever ser configurada com:
		Opção de busca habilitada
		Lista de opções para a enquete apresentada
		Cadastrar um bloco como o nome de Infoglobo ou info
	 */
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOCampoBuscaEstaSendoExibidoNoTopoDaTela() throws Exception{
		assertTrue(enqueteSimples.exibiuCampoDeBusca());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOPlaceholderDoCampoBuscaEstaSendoExibido() throws Exception{
		String placeholderEsperado = "Buscar...";
		assertEquals(placeholderEsperado, enqueteSimples.exibiuPlaceholderNoCampoDeBusca());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAoExecutarUmaBuscaValidaApenasONomeInformadoSeraExibido() throws Exception{
		enqueteSimples.preencherOCampoBusca();
		assertTrue(enqueteSimples.exibiuResultadoDeBuscaCorreto());
	}
}