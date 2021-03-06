package assistente;

import java.util.ArrayList;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class Assistente {

	public ArrayList<String> obterOnzeUrls(String ambiente, String dominio) {
		ArrayList<String> urlNavegacao = new ArrayList<String>();

		if (ambiente.equals("PRD")) {
			
			urlNavegacao.add(dominio+"economia/nivel-dos-reservatorios-das-regioes-sudeste-centro-oeste-tem-nova-queda-11627374");
			urlNavegacao.add(dominio+"mundo/estudantes-detidos-na-venezuela-dizem-ter-sido-espancados-despidos-na-prisao-11626579");
			urlNavegacao.add(dominio+"rio/apos-confrontos-beltrame-afirma-que-vai-aumentar-efetivo-na-rocinha-11625070");
			urlNavegacao.add(dominio+"esportes/adilson-elogia-douglas-mas-lamenta-derrota-critica-arbitragem-11623594");
			urlNavegacao.add(dominio+"blogs/pagenotfound/posts/2014/02/17/chines-pula-em-cerca-de-tigres-se-oferece-como-comida-524709.asp");
			urlNavegacao.add(dominio+"ciencia/militares-americanos-desenvolvem-pizza-que-dura-tres-anos-11627332");
			urlNavegacao.add(dominio+"economia/pela-primeira-vez-em-dez-anos-cvm-nao-recebe-pedidos-de-ipo-ate-fevereiro-11627017");
			urlNavegacao.add(dominio+"tecnologia/assassins-creed-4-uma-mistura-de-pirates-com-assassinos-11595654");
			urlNavegacao.add(dominio+"rio/bolsao-dagua-na-ernani-cardoso-causa-engarrafamento-em-cascadura-no-campinho-1-11624381");
			urlNavegacao.add(dominio+"rio/novo-esquema-de-transito-no-centro-para-av-brasil-linha-amarela-11624135");
			urlNavegacao.add(dominio+"cultura/jk-rowling-lanca-novo-livro-sob-pseudonimo-de-robert-galbraith-11625629");
		}
		else if (ambiente.equals("STGTESTE")){

			urlNavegacao.add(dominio+"rio/copa-do-mundo-roteiro-maracana-nosso-deles-1021389");
			urlNavegacao.add(dominio+"rio/marina-nao-acreditou-na-rede-1023100");
			urlNavegacao.add(dominio+"mundo/brasileiros-desafiam-frio-patagonico-na-meia-maratona-do-glaciar-1020420");
			urlNavegacao.add(dominio+"mundo/nacionalista-modi-vence-com-ampla-maioria-sera-premier-da-india-1018105");
			urlNavegacao.add(dominio+"economia/na-estreia-em-davos-dilma-vende-brasil-como-terra-de-oportunidades-de-responsabilidade-economica-1015315");
			urlNavegacao.add(dominio+"eu-reporter/monumento-general-osorio-esta-sem-espada-parte-da-grade-1021482");
			urlNavegacao.add(dominio+"rio/moradores-tem-carros-rebocados-por-causa-da-obra-do-bondinho-1020666");
			urlNavegacao.add(dominio+"sociedade/ciencia/cientistas-encontram-pinturas-de-600-anos-em-templo-no-camboja-1021263");
			urlNavegacao.add(dominio+"tecnologia/cisco-pede-para-ue-anular-compra-da-skype-pela-microsoft-991874");
			urlNavegacao.add(dominio+"rio/consultor-apontado-como-operador-do-esquema-de-pagamento-de-propinas-da-petrobras-se-entrega-1032815");
			urlNavegacao.add(dominio+"economia/economistas-veem-pela-primeira-vez-estouro-da-meta-de-inflacao-em-2015-1025827");

		}
		else if (ambiente.equals("STG")){

			urlNavegacao.add(dominio+"brasil/dilma-vai-entregar-unidades-do-minha-casa-minha-vida-em-tocantins-1026035");
			urlNavegacao.add(dominio+"brasil/documentario-sobre-maracanazo-estreia-no-uruguai-1026079");
			urlNavegacao.add(dominio+"teste-jenkins/aumento-do-repasse-ao-fundo-partidario-um-escarnio-diz-joaquim-barbosa-1056991");
			urlNavegacao.add(dominio+"brasil/dilma-destina-38-bilhoes-para-mobilidade-urbana-em-5-estados-df-1026121");
			urlNavegacao.add(dominio+"brasil/neri-geller-aceita-convite-de-dilma-para-assumir-agricultura-diz-lider-do-pmdb-1026138");
			urlNavegacao.add(dominio+"brasil/malasia-investiga-engenheiro-que-viajava-em-aviao-desaparecido-1027010");
			urlNavegacao.add(dominio+"brasil/igrejas-resistencia-colaboracao-durante-ditadura-militar-1027018");
			urlNavegacao.add(dominio+"brasil/previa-da-inflacao-acelera-para-073-em-marco-1027957");
			urlNavegacao.add(dominio+"brasil/so-interessava-paulo-malhaes-falar-do-metodo-que-usou-na-casa-da-morte-diz-advogada-de-comissao-1027959");
			urlNavegacao.add(dominio+"brasil/brasileiros-aprenderam-com-ditadura-valor-da-liberdade-diz-dilma-1028981");
			urlNavegacao.add(dominio+"brasil/apos-marina-assumir-coordenador-de-campos-deixa-campanha-do-psb-1041011");

		}
		else {
			
			urlNavegacao.add(dominio+"");
 			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
		
		}

		return urlNavegacao;
	}

	public ArrayList<String> obterVinteUrls(String ambiente, String dominio) {
		
		ArrayList<String> urlNavegacao = new ArrayList<String>();
		
		if (ambiente.equals("PRD")) {
			urlNavegacao.add(dominio+"sociedade/tecnologia/pernambucanos-participam-de-copa-de-testagem-de-software-na-alemanha-14410957");
			urlNavegacao.add(dominio+"sociedade/tecnologia/policia-londrina-experimenta-software-que-prediz-violencia-de-gangues-14410107");
			urlNavegacao.add(dominio+"sociedade/tecnologia/nono-digito-no-celular-sera-implantado-em-453-municipios-partir-do-dia-2-14409342");
			urlNavegacao.add(dominio+"sociedade/tecnologia/lenovo-conclui-aquisicao-da-motorola-14408546");
			urlNavegacao.add(dominio+"sociedade/tecnologia/microsoft-lanca-sua-primeira-pulseira-inteligente-14407989");
			urlNavegacao.add(dominio+"sociedade/saude/ministerio-da-saude-lanca-campanha-de-vacinacao-contra-poliomielite-o-sarampo-14412317");
			urlNavegacao.add(dominio+"sociedade/saude/estudo-mostra-por-que-cocar-faz-voce-cocar-mais-14410781");
			urlNavegacao.add(dominio+"sociedade/saude/amostras-de-variola-com-previsao-de-imediata-destruicao-ainda-estao-intactas-14407333");
			urlNavegacao.add(dominio+"sociedade/ciencia/tartarugas-gigantes-de-galapagos-nao-estao-mais-em-extincao-14395073");
			urlNavegacao.add(dominio+"esportes/jules-bianchi-permanece-em-estado-critico-mas-estavel-14410696");
		}
		else if (ambiente.equals("STGTESTE")){

			urlNavegacao.add(dominio+"economia/imoveis/mergulhador-usa-escova-para-acariciar-tartaruga-em-aquario-alemao-1021459");
			urlNavegacao.add(dominio+"economia/imoveis/ciclista-paga-mico-no-podio-ao-ter-beijo-negado-por-modelo-na-franca-1-1021463");
			urlNavegacao.add(dominio+"economia/imoveis/chinesa-flagrada-equilibrando-os-filhos-dentro-de-cestas-em-moto-1021461");
			urlNavegacao.add(dominio+"economia/ex-operador-acusado-de-fraudes-de-49-bilhoes-preso-na-franca-1018983");
			urlNavegacao.add(dominio+"estilo/cineastas-aderem-abaixo-assinado-para-manter-cotas-de-tela-1017268");
			urlNavegacao.add(dominio+"cultura/morrissey-faz-parceria-para-video-em-defesa-dos-animais-1019806");
			urlNavegacao.add(dominio+"economia/para-acalmar-mercados-governo-planeja-fazer-corte-de-30-bi-no-orcamento-1015324");
			urlNavegacao.add(dominio+"economia/defesa-do-consumidor/cadela-chamada-por-engano-para-fazer-parte-de-juri-nos-eua-1015328");
			urlNavegacao.add(dominio+"cultura/sem-sintese-1023124");
			urlNavegacao.add(dominio+"cultura/prefeitura-de-sao-paulo-descarta-acabar-com-virada-cultural-1019815");

		}
		else if (ambiente.equals("STG")){
			
			urlNavegacao.add(dominio+"teste-jenkins/contas-externas-registram-deficit-de-us-57-bilhoes-em-marco-1056987");
			urlNavegacao.add(dominio+"teste-jenkins/apos-aversao-ao-risco-estrangeiros-voltam-apostar-em-acoes-de-empresas-brasileiras-1056988");
			urlNavegacao.add(dominio+"rio/mau-tempo-provoca-sete-acidentes-em-tres-horas-na-autoestrada-grajau-jacarepagua-1030942");
			urlNavegacao.add(dominio+"rio/transito/transito-ruim-na-presidente-vargas-1030499");
			urlNavegacao.add(dominio+"rio/tunel-de-25-km-promete-acabar-com-inundacoes-na-zona-norte-1030943");
			urlNavegacao.add(dominio+"rio/carvalho-condena-paralisacao-de-onibus-em-sp-movimentos-que-usam-copa-para-protestar-1030451");
			urlNavegacao.add(dominio+"rio/transito/transito-ruim-na-cardoso-de-morais-1030229");
			urlNavegacao.add(dominio+"teste-jenkins/acoes-da-petrobras-operam-em-queda-mas-vale-mantem-bolsa-em-alta-1056989");
			urlNavegacao.add(dominio+"teste-jenkins/as-acoes-da-petrobras-ate-iniciaram-pregao-em-alta-1056990");
			urlNavegacao.add(dominio+"economia/defesa-do-consumidor/bola-oficial-ou-replica-fabricantes-omitem-informacao-do-consumidor-indica-proteste-1031103");
			
		}
		
		else {
			
			urlNavegacao.add(dominio+"");
 			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
			urlNavegacao.add(dominio+"");
		
		}
		
		return urlNavegacao;
	}
	
	public ArrayList<String> obterOnzeUrlsSendoAUltimaComWhiteList(String ambiente, String dominio, String midiaSocialDesejada) {
		
		ArrayList<String> urlNavegacao = new ArrayList<String>();
		
		if (ambiente.equals("PRD")) {
			urlNavegacao.add(dominio+"sociedade/tecnologia/pernambucanos-participam-de-copa-de-testagem-de-software-na-alemanha-14410957");
			urlNavegacao.add(dominio+"sociedade/tecnologia/policia-londrina-experimenta-software-que-prediz-violencia-de-gangues-14410107");
			urlNavegacao.add(dominio+"sociedade/tecnologia/nono-digito-no-celular-sera-implantado-em-453-municipios-partir-do-dia-2-14409342");
			urlNavegacao.add(dominio+"sociedade/tecnologia/lenovo-conclui-aquisicao-da-motorola-14408546");
			urlNavegacao.add(dominio+"sociedade/tecnologia/microsoft-lanca-sua-primeira-pulseira-inteligente-14407989");
			urlNavegacao.add(dominio+"sociedade/saude/ministerio-da-saude-lanca-campanha-de-vacinacao-contra-poliomielite-o-sarampo-14412317");
			urlNavegacao.add(dominio+"sociedade/saude/estudo-mostra-por-que-cocar-faz-voce-cocar-mais-14410781");
			urlNavegacao.add(dominio+"sociedade/saude/amostras-de-variola-com-previsao-de-imediata-destruicao-ainda-estao-intactas-14407333");
			urlNavegacao.add(dominio+"sociedade/ciencia/tartarugas-gigantes-de-galapagos-nao-estao-mais-em-extincao-14395073");
			urlNavegacao.add(dominio+"esportes/jules-bianchi-permanece-em-estado-critico-mas-estavel-14410696");
		}
		else if (ambiente.equals("STGTESTE")){

			urlNavegacao.add(dominio+"economia/imoveis/mergulhador-usa-escova-para-acariciar-tartaruga-em-aquario-alemao-1021459");
			urlNavegacao.add(dominio+"economia/imoveis/ciclista-paga-mico-no-podio-ao-ter-beijo-negado-por-modelo-na-franca-1-1021463");
			urlNavegacao.add(dominio+"economia/imoveis/chinesa-flagrada-equilibrando-os-filhos-dentro-de-cestas-em-moto-1021461");
			urlNavegacao.add(dominio+"economia/ex-operador-acusado-de-fraudes-de-49-bilhoes-preso-na-franca-1018983");
			urlNavegacao.add(dominio+"estilo/cineastas-aderem-abaixo-assinado-para-manter-cotas-de-tela-1017268");
			urlNavegacao.add(dominio+"cultura/morrissey-faz-parceria-para-video-em-defesa-dos-animais-1019806");
			urlNavegacao.add(dominio+"economia/para-acalmar-mercados-governo-planeja-fazer-corte-de-30-bi-no-orcamento-1015324");
			urlNavegacao.add(dominio+"economia/defesa-do-consumidor/cadela-chamada-por-engano-para-fazer-parte-de-juri-nos-eua-1015328");
			urlNavegacao.add(dominio+"cultura/sem-sintese-1023124");
			urlNavegacao.add(dominio+"cultura/prefeitura-de-sao-paulo-descarta-acabar-com-virada-cultural-1019815");

		}
		else if (ambiente.equals("STG")){
			
			urlNavegacao.add(dominio+"teste-jenkins/contas-externas-registram-deficit-de-us-57-bilhoes-em-marco-1056987");
			urlNavegacao.add(dominio+"teste-jenkins/apos-aversao-ao-risco-estrangeiros-voltam-apostar-em-acoes-de-empresas-brasileiras-1056988");
			urlNavegacao.add(dominio+"rio/mau-tempo-provoca-sete-acidentes-em-tres-horas-na-autoestrada-grajau-jacarepagua-1030942");
			urlNavegacao.add(dominio+"rio/transito/transito-ruim-na-presidente-vargas-1030499");
			urlNavegacao.add(dominio+"rio/tunel-de-25-km-promete-acabar-com-inundacoes-na-zona-norte-1030943");
			urlNavegacao.add(dominio+"rio/carvalho-condena-paralisacao-de-onibus-em-sp-movimentos-que-usam-copa-para-protestar-1030451");
			urlNavegacao.add(dominio+"rio/transito/transito-ruim-na-cardoso-de-morais-1030229");
			urlNavegacao.add(dominio+"teste-jenkins/acoes-da-petrobras-operam-em-queda-mas-vale-mantem-bolsa-em-alta-1056989");
			urlNavegacao.add(dominio+"teste-jenkins/as-acoes-da-petrobras-ate-iniciaram-pregao-em-alta-1056990");
			urlNavegacao.add(dominio+"economia/defesa-do-consumidor/bola-oficial-ou-replica-fabricantes-omitem-informacao-do-consumidor-indica-proteste-1031103");
			urlNavegacao.add(dominio+"teste-jenkins/webdriver-menu-superior-sonhos-congelados-new-york-times-conta-com-destaque-drama-da-ginasta-lais-souza-1059425?utm_source="+midiaSocialDesejada+"&utm_medium=Social&utm_campaign=compartilhar");
		
		}
		
		else {
			
			urlNavegacao.add(dominio+"rio/materia-teste-alteradarss-29695");
 			urlNavegacao.add(dominio+"pais/misturar-tapioca-acai-pode-causar-indigestao-diz-discurso-de-falcao-para-evento-do-pt-25031");
			urlNavegacao.add(dominio+"pais/helicoptero-da-prf-cai-em-goias-25033");
			urlNavegacao.add(dominio+"economia/deputados-vetam-criacao-de-sistema-financeiro-para-comercio-de-maconha-no-colorado-eua-25005");
			urlNavegacao.add(dominio+"rio/relatorio-identifica-55-violacoes-liberdade-de-expressao-no-brasil-em-2014-30025");
			urlNavegacao.add(dominio+"esportes/sexo-na-copa-veja-as-selecoes-que-liberam-as-que-proibem-25619");
			urlNavegacao.add(dominio+"economia/rumores-de-nova-pesquisa-eleitoral-desemprego-nos-eua-impulsionam-bovespa-24998");
			urlNavegacao.add(dominio+"rio/vazamento-de-agua-alaga-principal-via-de-rio-das-pedras-1-24996");
			urlNavegacao.add(dominio+"economia/congresso-adia-para-quinta-feira-instalacao-de-comissoes-para-debater-ajuste-fiscal-29837");
			urlNavegacao.add(dominio+"mundo/vendido-us-15-mil-google-glass-custa-apenas-us-80-para-fabricar-25027");
		
		}
		
		return urlNavegacao;
	}
	
	public String obterCookie(String nomeCookie, WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		String cookie = driver.manage().getCookieNamed(nomeCookie).getValue(); 
		return cookie;
	}
	
	public Cookie obterNomeCookie(String nomeCookie, WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		Cookie cookie = driver.manage().getCookieNamed(nomeCookie); 
		return cookie;
	}
}