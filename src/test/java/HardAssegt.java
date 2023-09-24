import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HardAssegt {
    public static void main(String[] args) throws InterruptedException {
        // static thats why dont need to creat object
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("https://it.microtechlimited.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.getTitle();
        System.out.println(driver.getTitle());

        Assert.assertTrue(driver.getTitle().equals("MicroTech NA"));

        //login
        driver.findElement(By.xpath("//a[@href='elogin.php']")).click();
        Thread.sleep(2000);
        //username
        driver.findElement(By.xpath("//input[@name='mailuid']")).sendKeys("testpilot@gmail.com");
        Thread.sleep(2000);
        //password
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("1234");
        Thread.sleep(2000);
        //login button
        driver.findElement(By.xpath("//input[@name='login-submit']")).click();

        //assertTrue(driver.getTitle().equals("MicroTech NA"));

        Thread.sleep(2000);




        driver.close();


    }
}
