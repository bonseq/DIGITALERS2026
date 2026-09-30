import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class laboratorio3_ejercicio1 {
	WebDriver juli;  //variables globales papu
	WebDriverWait wait;
	
	@BeforeSuite
	public void setUp() {
		juli = new ChromeDriver();
		wait = new WebDriverWait(juli, Duration.ofSeconds(10));
		
	}
	
	@BeforeTest
	public void irURL() {
		juli.get("https://automationexercise.com/login");
	}
	
	@BeforeClass
	public void macVentana() {
		juli.manage().window().maximize();
		juli.manage().deleteAllCookies();
	}
	
	@BeforeMethod
	public void mensajeInicio() {
		System.out.println("antes del metodo :D");
	}
	
	@Test
	public void loginUser() {
		System.out.println("esta es la prueba 2 papu");
		WebElement nombre = juli.findElement(By.name("name"));
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='signup-email']")));
		WebElement botonRegistro = juli.findElement(By.xpath("//button[@data-qa='signup-button']"));
		
		nombre.sendKeys("taima");
		email.sendKeys("taimahotmail");
		String urlAntes = juli.getCurrentUrl();
		botonRegistro.click();
		
		//ASSERTS
		Assert.assertTrue(nombre.isDisplayed());  //verificar q decuelva verdadero
		String estoEsUnTexto = null;
		Assert.assertNotNull(estoEsUnTexto); //verificar que algo no sea null
		Assert.assertEquals(juli.getCurrentUrl(), urlAntes); //o en vez de ejemplo poner juli.getCurrentUrl() para comparar
	}
	@Test
	public void loginUser3() {
		System.out.println("esta es la prueba 3");
	}
	
	@Test
	public void escribirYLeerTexto() throws IOException { //ioe maneja escepciones
		//1
	    File carpeta = new File("Evidencias");  //Creamos un nuevo objeto, contruye un archivo que refiere al recurso llamado evidencia
	    if (!carpeta.exists() && !carpeta.mkdirs()) {  //aca abajo crea la carpeta y se fija si esta creada y si puede escribir en ella
	        throw new IOException("No se pudo crear Evidencias");//sino lo puede hacer lanza error
	    }
	    //2
	    File archivo = new File(carpeta, "nota.txt"); // esta creando la ruta a donde deberia crear el documento
	    try (FileWriter escritor = new FileWriter(archivo)) {
	        escritor.write("Evidencia de la unidad 22");
	    }
	    //3
	    try (FileReader lector = new FileReader(archivo)) {
	        int caracter;
	        while ((caracter = lector.read()) != -1) {
	            System.out.print((char) caracter);
	        }
	    }
	}
	
	@AfterMethod 
	public void screenshot() throws IOException {
	    if (juli == null) {
	        return;
	    }

	    File screen = ((TakesScreenshot) juli).getScreenshotAs(OutputType.FILE);
	    
	    File imageFile = new File("Evidencias/Test.png");
	    
	    FileUtils.copyFile(screen, imageFile);

	    System.out.println(imageFile.getAbsolutePath());

	}
	
	
	@AfterMethod
	public void mensajeFin() {
		System.out.println("despues del metodo :D");
	}
	
	@AfterClass
	public void finPrueba() {
		System.out.println("moshi moshi, termino tu prueba");
	}
	
	@AfterTest
	public void cerrarNav() {
		if(juli !=null) {
			juli.quit();
		}
	}
	
	@AfterSuite
	public void finSuite() {
		System.out.println("termino la suite papu");
	};
	
};
/*	@BeforeSuite
	void ejemplo_suite_test(){	
		
		@BeforeSuite    → Se ejecuta UNA vez antes de TODO
		  @BeforeTest   → Antes de cada grupo de tests
		    @BeforeClass  → Antes de la clase en el testing.xml
		    	@BeforeMethod despues de cada metodo del test
		        @Test        → 👈 Tu caso de prueba
		        @Test2		→ Se ejecuta AfterClass
		    @AfterClass   → Después de la clase
		  @AfterTest    → Después del grupo
		@AfterSuite     → Al final de TODO 
	
};*/
