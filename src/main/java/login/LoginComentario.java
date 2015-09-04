package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class LoginComentario extends AceitacaoAbstractTest {

	public LoginComentario() throws Exception {
		super();
	}

	public LoginComentario(WebDriver driver) {
		super(driver);
	}

	public void setUsuario(String usuario) {
		getDriver().findElement(By.id("login")).sendKeys(usuario);
	}

	public void setSenha(String senha) {
		WebElement campoSenha = getDriver().findElement(By.id("password"));
		super.preencherCampoTexto(campoSenha, senha);
	}

	public AceitacaoAbstractTest logar() throws InterruptedException {
		esperaCarregar(3);
		getDriver().findElement(By.className("button")).click();
		return (AceitacaoAbstractTest) this;
	}

	public AceitacaoAbstractTest efetuarLoginCadum() throws InterruptedException {
		esperaCarregar(3);
		this.setUsuario("testecadun@hotmail.com");
		this.setSenha("secret123");
		return this.logar();
	}
}