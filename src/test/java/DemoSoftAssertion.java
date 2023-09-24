import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class DemoSoftAssertion {
    public static void main(String[] args) throws InterruptedException, IOException {

        //non static thats why need to creat object

        SoftAssert soft = new SoftAssert();
        // soft.assertAll();
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        // SoftAssert soft = new SoftAssert();
        //soft.assertAll();

        driver.get("https://it.microtechlimited.com/");

        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        DemoSoftAssertion.screenShotWithName(driver, "Landing Page of Application");

        String x = driver.findElement(By.xpath("//h1[text()='Welcome to MicroTech NA.']")).getText();
        soft.assertEquals(x, "Welcome to MicroTech NA---");

        // driver.getTitle();
        System.out.println(driver.getTitle());
        //Asert.assertTrue(driver.getTitle().equals("MicroTech NA"));//Junit Assertion
        soft.assertTrue(driver.getTitle().equals("MicroTech NA"));
        Thread.sleep(1000);
        System.out.println("zzzzz");

        Assert.assertTrue(driver.getTitle().equals("MicroTech NA"));
        //not done yet cheack xpath
        driver.findElement(By.xpath("//a[@href='elogin.php']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='mailuid']")).sendKeys("testpilot@gmail.com");
        Thread.sleep(1000);
        //  soft.assertAll();

        DemoSoftAssertion.screenShotWithName(driver, "Employee Login Page");
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("1234");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='login-submit']")).click();
        //show  where is mistake

        Thread.sleep(2000);
        DemoSoftAssertion.screenShotWithName(driver, "Employee Home Page");
        System.out.println("HAHAHA-----$$$$");

        //soft.assertAll();
        driver.close();
        soft.assertAll();

    }

    public static void screenShotWithName(WebDriver driver, String name) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(source, new File("C:\\Users\\nazmu\\Downloads\\screenShot\\capture\\" + name + ".png"));
//        FileUtils.copyFile(source, new File("C:\\Java\\capture\\Customer\\" + name + ".png"));
        FileUtils.copyFile(source,new File("C:\\Java\\workspaceIntelliJ\\windowHandlingPractice\\screenShot\\"+name+".png"));
    }
}


