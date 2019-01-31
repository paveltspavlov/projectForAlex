import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class mainTest {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void initBrowser(){
        System.setProperty("webdriver.chrome.driver","browser\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openZamunda(){
        driver.navigate().to("http://zamunda.net/");
        softAssert.assertEquals(driver.getCurrentUrl(),"http://zamunda.net/");
        softAssert.assertAll();
    }

    @Test (dependsOnMethods = "openZamunda")
    public void goToLogin() throws InterruptedException {
        WebElement butt = driver.findElement(By.id("foruicon"));
        butt.click();

    }

    @Test (dependsOnMethods = "goToLogin")
    public void login(){
       WebElement user = driver.findElement(By.name("username"));
       user.sendKeys("loisnkarafan");
       WebElement pass = driver.findElement(By.name("password"));
       pass.sendKeys("81650866");
       WebElement butt2 = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[1]/td/table/tbody/tr/td/form/table/tbody/tr[3]/td/input"));
       butt2.click();
    }

    @Test (dependsOnMethods = "login")

    public void goToTorrents(){
     WebElement banana = driver.findElement(By.id("software"));
     banana.click();

    }

    @Test (dependsOnMethods = "goToTorrents")

    public void moviesCategory (){
        WebElement movie = driver.findElement(By.xpath("//*[@id=\"browse_cats\"]/table/tbody/tr/td[1]/a[9]"));
        movie.click();

        WebElement checkBox = driver.findElement(By.id("check_browsemovies"));
        softAssert.assertTrue(checkBox.getText().equalsIgnoreCase("Филми"));
        softAssert.assertAll();
    }

    @Test (dependsOnMethods = "moviesCategory")

    public void firstTorrent (){
        WebElement firstOne = driver.findElement(By.xpath("//*[@id=\"zbtable\"]/tbody/tr[2]/td[2]"));
        firstOne.click();
    }


}
