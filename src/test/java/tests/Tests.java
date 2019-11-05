package tests;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Ingreso;
import Pages.Login;
import Pages.MenuIngreso;
import Pages.DatosGenerales;
import helpers.Helpers;

public class Tests {

	private WebDriver driver;

	@BeforeMethod(description = "Inicio del test")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("file:///C:/Users/OmeghaX/Desktop/imagen%20con%20link/divlink.html");
	}

	@Test(description = "Parte del test donde mandas llamar todas las clases")

	public void Llamar() {
		/*Helpers h = new Helpers();
		h.retencion(3);
		Login pageLogin = new Login(driver);
		pageLogin.login("QUALI", "123");

		h.retencion(3);
		MenuIngreso menu = new MenuIngreso(driver);
		menu.menuI();

		h.retencion(3);
		Ingreso IngFol = new Ingreso(driver);
		IngFol.rIngreso();
		
		h.retencion(3);
		DatosGenerales Datos = new DatosGenerales(driver);
		Datos.general("cliente", "placasU", "valua", "vinn");
		//15,7,12,17*/
		
		WebElement op= driver.findElement(By.id("option"));
		Select s = new Select(op);
		s.selectByIndex(2);
		
		Helpers h = new Helpers();
		h.retencion(50);
	}

	@AfterMethod(description = "Cierre del test, toma foto al error si es que existe alguno")
	public void fin(ITestResult result) {

		if (!result.isSuccess()) {
			File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(foto, new File("Error" + System.currentTimeMillis() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.close();
	}
}
