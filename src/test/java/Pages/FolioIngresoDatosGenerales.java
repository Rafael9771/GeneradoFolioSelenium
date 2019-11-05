package Pages;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.internal.junit.ArrayAsserts;

import helpers.Helpers;

public class FolioIngresoDatosGenerales {
	private WebDriver driver; 
	private WebElement idCliente,placas,valuacion,vin,Tvehiculo,Marca,Modelo,Version,anio,danio,origen,centroSubasta;
	


	public FolioIngresoDatosGenerales(WebDriver driver) {
		this.driver = driver; 
		

	}

	public void general(int cont) {
		boolean banSelect=false;
		Helpers h = new Helpers();
		h.retencion(10);
		String fecha = "";
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();
        
        int dia = c2.get(Calendar.DATE);
        int mes = c2.get(Calendar.MONTH);
        int annio = c2.get(Calendar.YEAR);
         if(dia<10) {
        	 fecha+="0"+dia;
         }else {
        	 fecha+=dia;
         }
         if(mes<10) {
        	 fecha += "0"+mes;
         }else {
        	 fecha += mes;
         }
         if(cont<10){
        	 fecha += annio+"000000"+cont;
         }else if(cont>9 && cont<100) {
        	 fecha += annio+"00000"+cont;
         }else if(cont<99 && cont<1000) {
        	 fecha += annio+"0000"+cont;
         }else if(cont<999 && cont<10000) {
        	 fecha += annio+"000"+cont;
         }else {
        	 JOptionPane.showMessageDialog(null, "Sorry solo se pueden hacer 9999 usuarios");
         }
         
		idCliente = driver.findElement(By.xpath("//*[@id=\"numsin\"]"));
		placas = driver.findElement(By.xpath("//*[@id=\"numpla\"]"));
		valuacion = driver.findElement(By.xpath("//*[@id=\"idvalu\"]"));
		vin= driver.findElement(By.xpath("//*[@id=\"numvin\"]"));
		
		
		
		
		
		
		
		
		
		idCliente.sendKeys(fecha);
		placas.sendKeys(fecha);
		valuacion.sendKeys(fecha);
		vin.sendKeys(fecha);
		Tvehiculo.click();
		
		
		
		
		
		
		
		
		
		
		if (driver instanceof JavascriptExecutor) {
		    ((JavascriptExecutor)driver).executeScript("confirm('El VIN ingresado no es valido'+ ' desea continuar?');");
		} else {
		    throw new IllegalStateException("This driver does not support JavaScript!");
		}
		do {
			banSelect=false;
		
			Tvehiculo = driver.findElement(By.id("cvtveh"));
			Select Svehiculo = new Select(Tvehiculo);
			 
			int n = Svehiculo.getAllSelectedOptions().size();
			if(n<=0) {
				banSelect=true;
			}
			if(banSelect) {
				
			}else {
				int numero = (int) (Math.random() * n);
				Svehiculo.selectByIndex(numero);
				
				Marca = driver.findElement(By.id("cvmarc"));
				Select Smarca = new Select(Marca);
				
				
				n = Smarca.getAllSelectedOptions().size();
				if(n<=0) {
					banSelect=true;
				}
				if(banSelect) {
					
				}else {
					numero = (int) (Math.random()*n);
					Smarca.selectByIndex(numero);
					
					Modelo = driver.findElement(By.id("cvmode"));
					Select Smodelo = new Select(Modelo);
					
					
					n = Smodelo.getAllSelectedOptions().size();
					if(n<=0) {
						banSelect=true;
					}
					if(banSelect) {
						
					}else {
						numero = (int) (Math.random()*n);
						Smodelo.selectByIndex(numero);
						
						Version = driver.findElement(By.id("cvveve"));
						Select Sversion = new Select(Version);
						
						
						n = Sversion.getAllSelectedOptions().size();
						if(n<=0) {
							banSelect=true;
						}
						if(banSelect) {
							
						}else {
							numero = (int) (Math.random()*n);
							Sversion.selectByIndex(numero);
							
							anio = driver.findElement(By.id("cvanio"));
							Select Sanio = new Select(anio);
							
							
							n = Sanio.getAllSelectedOptions().size();
							if(n<=0) {
								banSelect=true;
							}
							if(banSelect) {
								
							}else {
								numero = (int) (Math.random()*n);
								Sanio.selectByIndex(numero);
								
								danio = driver.findElement(By.id("cvtida"));
								Select Sdanio = new Select(danio);
								
								
								n = Sdanio.getAllSelectedOptions().size();
								if(n<=0) {
									banSelect=true;
								}
								if(banSelect) {
									
								}else {
									numero = (int) (Math.random()*n);
									Sdanio.selectByIndex(numero);
									
									origen = driver.findElement(By.id("cvticm"));
									Select Sorigen = new Select(origen);
									
									
									n = Sorigen.getAllSelectedOptions().size();
									if(n<=0) {
										banSelect=true;
									}
									if(banSelect) {
										
									}else {
										numero = (int) (Math.random()*n);
										Sorigen.selectByIndex(numero);
										
										centroSubasta = driver.findElement(By.id("cvcere"));
										Select ScentroSubasta = new Select(centroSubasta);
										
										
										n = ScentroSubasta.getAllSelectedOptions().size();
										if(n<=0) {
											banSelect=true;
										}
										if(banSelect) {
											
										}else {
											numero = (int) (Math.random()*n);
											ScentroSubasta.selectByIndex(numero);
											/*aqui agrega el final
										}
									}
								}
							}
						}
					}
				}
			}
		/*con size se hara la seleccion al azar de los selects y con un do while se reetira la seleccion si encuentra un select vacio*/
		}while(banSelect);
		
		
	}
}
