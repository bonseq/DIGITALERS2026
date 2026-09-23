import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver ;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Laboratorio1 { 
	
	@Test
	void lab_test(){
		System.out.println("hola soy un test :D");
	
	}
	
	@Test 
	void lab_e2_test() {
		//tipoVar Name = new CosaAconstruir()
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.get("https://automationexercise.com/products");
			driver.manage().window().maximize();
			
		}  
		finally {
			
			driver.quit();
		}
	}
	
	@Test 
	void lab_3e_test() {
		WebDriver fox = new FirefoxDriver();
		
		try {
			fox.get("https://automationexercise.com/");
			fox.manage().window().maximize();
		}  
		finally {
			fox.quit();
		}
	}
	@Test
	void lab_e4_test() {
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try { 
			driver.get("https://automationexercise.com/products"); //acceder a la url
			WebElement Lupita= driver.findElement(By.id("search_product")); //encontrar la seccion o elemento donde buscar
			Lupita.sendKeys("Blue Top");
			//sendKeys completa campos
			
			/*si hubiera varias campos, habria que hacer campo.sendKeys("completar"); campo2...etc*/
			WebElement botonBuscar = driver.findElement(By.id("submit_search"));
			botonBuscar.click();

		} finally {
			driver.quit();
		}
	}
	@Test
	void lab1_E4() {
	WebDriver driver = new ChromeDriver();
	try {
	driver.get("https://automationexercise.com/products");
	
	WebElement buscador = driver.findElement(By.id("search_product"));
	buscador.sendKeys("Blue Top");
	buscador.sendKeys(Keys.ENTER);
	

	} finally {
	driver.quit();
	}
	}
}





