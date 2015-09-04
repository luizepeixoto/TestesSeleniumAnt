package br.com.infoglobo.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ConfiguracoesProxy {

	public static DesiredCapabilities getDesiredCapabilitiesForProxy() {
//		String proxyName = "infoprx1:8080";
		String proxyName = "infoproxybkp:8080";
		String semProxy = "siteredesenho, globostg.globoi.com, sitetemporeal, apiqlt, siteoglobofrontend";
		
		DesiredCapabilities cap = new DesiredCapabilities();

		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyName).setFtpProxy(proxyName).setSslProxy(proxyName).setAutodetect(false).setNoProxy(semProxy);

		cap.setCapability(CapabilityType.PROXY, proxy);

		return cap;
	}

	public static DesiredCapabilities getDesiredCapabilitiesForAChrome() {
		//String proxyName = "infoprx1:8080";
		String proxyName = "infoproxybkp:8080";
		String semProxy = "siteredesenho, globostg.globoi.com, oglobo.globo.com, apiqlt, siteoglobofrontend";
				
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		System.setProperty("webdriver.chrome.driver", "C:\\web-drivers\\chromedriver.exe");
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyName).setFtpProxy(proxyName).setSslProxy(proxyName).setAutodetect(false).setNoProxy(semProxy);

		chromeCapabilities.setCapability(CapabilityType.PROXY, proxy);

		return chromeCapabilities;
	}
	
	public static DesiredCapabilities getDesiredCapabilitiesForAChromeEmulated(Device device) {
		DesiredCapabilities capabilities = getDesiredCapabilitiesForAChrome();
		
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", device.getNome());
		
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		return capabilities;
	}
	
	public static DesiredCapabilities getDesiredCapabilitiesForPhantom() {
//		String proxyName = "infoprx1:8080";
		String proxyName = "infoproxybkp:8080";
		String semProxy = "siteredesenho, globostg.globoi.com, oglobo.globo.com, sitetemporeal, apiqlt, siteoglobofrontend";
		
		DesiredCapabilities cap = new DesiredCapabilities();

		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyName).setFtpProxy(proxyName).setSslProxy(proxyName).setAutodetect(false).setNoProxy(semProxy);

		cap.setCapability(CapabilityType.PROXY, proxy);
		cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\web-drivers\\phantomjs.exe");

		return cap;
	}
}