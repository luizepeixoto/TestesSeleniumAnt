package br.com.infoglobo.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfiguracoesTeste {
	
	private static final String diretorioResources = "src/test/resources/";

//	private static final String ARQUIVO_CONFIGURACAO_URL_PADRAO = diretorioResources + "Configuracoes-INT.properties";
	private static final String ARQUIVO_CONFIGURACAO_URL_PADRAO = diretorioResources + "Configuracoes-STG.properties";
//	private static final String ARQUIVO_CONFIGURACAO_URL_PADRAO = diretorioResources + "Configuracoes-PRD.properties";
	
	Properties propertiesConfiguracoes;
	
	private String getNomeArquivoConfiguracao() {
		String nomeArquivoConfiguracao = System.getProperty("propertyFile", ARQUIVO_CONFIGURACAO_URL_PADRAO);
		System.out.println("Arquivo de configuração utilizado: " + nomeArquivoConfiguracao);
		return nomeArquivoConfiguracao;
	}
	
	private void carregarArquivoConfiguracao() throws Exception {
		propertiesConfiguracoes = RepositorioInstancias.getConfiguracoes();
		if (propertiesConfiguracoes == null) {
			System.out.println("Carregando o arquivo de configurações...\n");
			propertiesConfiguracoes = new Properties();
			File file = new File(this.getNomeArquivoConfiguracao());
			propertiesConfiguracoes.load(new FileInputStream(file));
			RepositorioInstancias.setConfiguracoes(propertiesConfiguracoes);
			System.out.println("Finalizou a carga do arquivo de configurações.\n");
			return;
		}
	}
	
	public String getAmbiente() throws Exception {
		this.carregarArquivoConfiguracao();
		String ambiente = propertiesConfiguracoes.getProperty("ambiente");
		System.out.println("Ambiente testado: " + ambiente);
		return ambiente;
	}

	public String getUrlAmbiente() throws Exception {
		this.carregarArquivoConfiguracao();
		String urlAmbiente = propertiesConfiguracoes.getProperty("dominio");
		urlAmbiente = "http://" + (urlAmbiente + "/").replace("//", "/");
		System.out.println("Ambiente testado: " + urlAmbiente+"\n");
		return urlAmbiente;
	}

	public String getCaminhoPagina(String nomePagina) throws Exception {
		this.carregarArquivoConfiguracao();
		return propertiesConfiguracoes.getProperty(nomePagina + ".path");
	}

	public String get(String chaveconfiguracao) throws Exception {
		this.carregarArquivoConfiguracao();
		String valorChave = propertiesConfiguracoes.getProperty(chaveconfiguracao);
		if (valorChave == null){
			throw new Exception("Não localizou a chave no arquivo de configurações\n");
		}
		return valorChave;
	}	
}