package br.com.infoglobo.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class RepositorioInstancias {
	private static WebDriver driver;
	private static Properties propertiesConfiguracoes;
	
	public static void setWebDriver(WebDriver instancia) {
		driver = instancia;
	}
	
	public static WebDriver getWebDriver() {
		return driver;
	}

	public static void setConfiguracoes(Properties configuracoes) {
		propertiesConfiguracoes = configuracoes;
	}

	public static Properties getConfiguracoes() {
		return propertiesConfiguracoes;
	}
}