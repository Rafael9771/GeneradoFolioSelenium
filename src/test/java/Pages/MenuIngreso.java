package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuIngreso {
	private WebDriver driver;

	public MenuIngreso(WebDriver dvr){
		this.driver = dvr;
	}

	public void menuI() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement regla = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/div[3]/div[3]/div[1]")));
		regla.click();
	}
}
