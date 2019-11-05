package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	private WebDriver driver; 
	private By userField;
	private By passField;
	private By LoginButton;

	public Login(WebDriver driver) {
		this.driver = driver; 
		
		userField = By.xpath("//*[@id=\"Login_usuarioVO_cvusus\"]");
		passField = By.xpath("//*[@id=\"Login_usuarioVO_pasusu\"]");
		LoginButton = By.xpath("/html/body/form/div/div[4]/input[3]");
	}

	public void login(String user, String pass) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(LoginButton).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}
}
