import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTestFirst {

    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\Download\\chromedriver\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrouseLanguage = driver.findElement(
                By.xpath("//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']")
        );

        menuBrouseLanguage.click();
        //Thread.sleep(1000); zatrimka

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );

        menuStart.click();
        //Thread.sleep(2000);

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));

        String actualResult = h2.getText();
        //Thread.sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }
}
