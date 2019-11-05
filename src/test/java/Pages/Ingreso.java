package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ingreso {
	private WebDriver driver;

	public Ingreso(WebDriver dvr){
		this.driver = dvr;
	}

	public void rIngreso() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String[] folio = new String[3];
		folio[0]="/html/body/div[2]/div/div[1]/div[1]";
		folio[1]="/html/body/div[2]/div/div[1]/div[2]";
		folio[2]="/html/body/div[2]/div/div[1]/div[3]";
		WebElement regla = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div[1]")));
		regla.click();
	}
}
