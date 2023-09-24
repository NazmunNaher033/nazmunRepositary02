package browserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CrossBrowserTestingPropertiesFiles {
    public static void main(String[] args) throws IOException {
        //java class
        Properties prop = new Properties();
        //configure.properties static /whole path file
       //String path= "C:\\Java\\workspaceIntelliJ\\windowHandlingPractice\\configure.properties";
        //dynamic path used by .(dot)
        String path= ".\\configure.properties";

       // File file = new File("configure.properties");
            //for file read
       // FileInputStream fis = new FileInputStream(file);

        //streaming with the file
        FileInputStream fis = new FileInputStream(path);
        // loading the streaming file
         prop.load(fis);

        WebDriver driver;//public class interface and object
        driver = null;//instantiate ,we using null because of using driver like chrome,edge,firefox

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Provide a valid Browser Name");
        }
        driver.get("https://www.cnn.com/");
        //driver.get("https://it.microtechlimited.com/");
    }
}
