package windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

public class multiApplicationHandle {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();



        //driver.get();
        driver.navigate().to("https://www.ebay.com/");
        String firstWindow = driver.getWindowHandle();
        System.out.println(firstWindow);
        System.out.println("Ebay");
        driver.switchTo().newWindow(WindowType.TAB);

        driver.navigate().to("https://www.amazon.com/");
        JavascriptExecutor js =( JavascriptExecutor)driver;
        System.out.println("Amazon");
        WebElement element = driver.findElement(By.cssSelector("a[id='icp-touch-link-country'] span[class='icp-color-base']"));
        js.executeScript("arguments[0].scrollIntoView();",element);
        element.click();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.walmart.com/");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        System.out.println("Walmart");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("http://www.gmail.com/");
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        System.out.println("Gmail");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("http://www.gmail.com/");
        JavascriptExecutor js3 = (JavascriptExecutor) driver;


    }
}
