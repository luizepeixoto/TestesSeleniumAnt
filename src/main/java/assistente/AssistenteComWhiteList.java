package assistente;

import java.util.ArrayList;

public class AssistenteComWhiteList {

	public ArrayList<String> obterOnzeUrls(String ambiente, String dominio) {
		ArrayList<String> urlNavegacao = new ArrayList<String>();

		if (ambiente.equals("PRD")) {
			
			urlNavegacao.add(dominio+"sociedade/comissao-de-direitos-humanos-da-camara-vai-ouvir-nove-ex-homossexuais-15907796");
 			urlNavegacao.add(dominio+"brasil/cunhada-de-vaccari-se-entrega-pf-em-curitiba-15904166");
			urlNavegacao.add(dominio+"sociedade/tecnologia/mortal-kombat-tem-primeiro-personagem-gay-da-serie-15904916");
			urlNavegacao.add(dominio+"sociedade/tecnologia/emojis-que-respeitam-diversidade-sao-usados-em-publicacoes-racistas-15905100");
			urlNavegacao.add(dominio+"sociedade/ciencia/cientistas-encontram-evidencias-de-que-europeus-antigos-praticavam-canibalismo-15904613");
			urlNavegacao.add(dominio+"sociedade/ciencia/cientistas-anunciam-descoberta-do-mais-antigo-fossil-humano-da-historia-15501425");
			urlNavegacao.add(dominio+"sociedade/ciencia/neandertais-produziam-joias-usando-garras-de-aguias-mostra-estudo-15569864");
			urlNavegacao.add(dominio+"sociedade/ciencia/cachorros-ajudaram-humanos-erradicar-neandertais-da-europa-diz-antropologa-15476169");
			urlNavegacao.add(dominio+"sociedade/ciencia/fossil-de-45-mil-anos-de-humano-moderno-revela-mais-detalhes-sobre-sexo-com-neandertais-14329650");
			urlNavegacao.add(dominio+"sociedade/historia/arqueologos-descobrem-restos-mais-antigos-de-um-pre-neandertal-ja-encontrado-14208128");
			urlNavegacao.add(dominio+"esportes/descubra-os-segredos-de-quem-ama-correr-14236226");/*Matéria tipo Especial publicitário*/
		
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
			urlNavegacao.add(dominio+"teste-jenkins/nike/colecao-nike-pedro-lourenco-revoluciona-sport-fashion-1023638");
			
		}
		
		else if (ambiente.equals("STG")){
			
			urlNavegacao.add(dominio+"teste-jenkins/protestos-anti-dilma-reunem-mais-de-2-milhoes-de-pessoas-pelo-pais-1050548");
			urlNavegacao.add(dominio+"teste-jenkins/jaque-khury-mostra-abdome-sarado-em-roupa-fitness-revela-que-pretende-engravidar-novamente-1045843");
			urlNavegacao.add(dominio+"teste-jenkins/ex-bbb-jaque-khury-emagrece-tres-quilos-com-detox-de-um-dia-1045839");
			urlNavegacao.add(dominio+"teste-jenkins/namorada-de-roberto-justus-investe-na-musculacao-ganha-um-quilo-de-massa-magra-1045842");
			urlNavegacao.add(dominio+"teste-jenkins/webdriver-plantao-com-fotos-para-testes-1050556");
			urlNavegacao.add(dominio+"teste-jenkins/dolar-comercial-tem-sua-quarta-alta-seguida-cotacao-volta-encostar-nos-3-bolsa-sobe-1049836");
			urlNavegacao.add(dominio+"teste-jenkins/vitoria-polemica-da-beija-flor-ganha-repercussao-internacional-1047661");
			urlNavegacao.add(dominio+"teste-jenkins/faltou-tecnica-1049262");
			urlNavegacao.add(dominio+"teste-jenkins/relator-da-cpi-da-petrobras-recebeu-quase-1-milhao-de-empresas-investigadas-na-lava-jato-1049184");
			urlNavegacao.add(dominio+"teste-jenkins/caminho-de-pedras-buracos-muita-lama-na-estrada-do-capenha-em-jacarepagua-1046557");
			urlNavegacao.add(dominio+"teste-jenkins/informe-publicitario/caroline-bittencourt-diz-que-recebe-criticas-por-corpo-musculoso-1047399");/*Matéria tipo Especial publicitário*/
			
		}
		
		else{
			
			urlNavegacao.add(dominio+"rio/rio-2016/para-conquistar-inedito-ouro-no-futebol-29940");
 			urlNavegacao.add(dominio+"rio/rio-2016/obra-olimpica-no-engenhao-tem-prazo-de-360-dias-para-ficar-pronta-nem-comecou-29941");
			urlNavegacao.add(dominio+"rio/rio-2016/eduardo-paes-pede-um-esforco-olimpico-todos-os-cariocas-29935");
			urlNavegacao.add(dominio+"rio/rio-2016/nicolas-oliveira-consegue-indice-para-mundial-de-kazan-29934");
			urlNavegacao.add(dominio+"cultura/em-seu-perfil-no-facebook-homem-que-confessou-mais-de-40-assassinatos-curtia-filmes-de-morte-26687");
			urlNavegacao.add(dominio+"rio/sao-clemente-satira-critica-bom-humor-em-preto-amarelo-na-avenida-29657");
			urlNavegacao.add(dominio+"brasil/nova-materia-de-teste-29856");
			urlNavegacao.add(dominio+"tecnologia/chromecast-apple-tv-ou-nexus-player-confira-pros-contras-escolha-29901");
			urlNavegacao.add(dominio+"rio/filho-pede-oracoes-para-ex-tecnico-de-basquete-de-fla-flu-baleado-vamos-continuar-rezando-29910");
			urlNavegacao.add(dominio+"economia/ministro-do-planejamento-diz-que-nao-ha-descontrole-do-cambio-no-brasil-29836");
			urlNavegacao.add(dominio+"rio/testando-nova-materia-28416"); /*Matéria tipo Especial publicitário*/
		
		}

		return urlNavegacao;
	}
	
	public ArrayList<String> obterOnzeUrlsSendoAUltimaComWhiteList(String ambiente, String dominio, String compartilhamentoDesejado) {
		
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
			urlNavegacao.add(dominio+"esportes/em-primeiro-treino-no-flu-enderson-moreira-faz-mudancas-no-time-16225867?utm_source="+compartilhamentoDesejado+"&utm_medium=Social&utm_campaign=compartilhar");
		
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
			urlNavegacao.add(dominio+"teste-jenkins/a-vibracao-da-torcida-com-os-tubos-surfados-por-wiggolly-foi-um-aperitivo-para-que-estava-por-vir-1059318?utm_source="+compartilhamentoDesejado+"&utm_medium=Social&utm_campaign=compartilhar");
		
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
			urlNavegacao.add(dominio+"economia/deputados-vetam-criacao-de-sistema-financeiro-para-comercio-de-maconha-no-colorado-eua-25005?utm_source="+compartilhamentoDesejado+"&utm_medium=Social&utm_campaign=compartilhar");
		
		}
		
		return urlNavegacao;
	}
}