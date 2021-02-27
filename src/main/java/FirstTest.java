
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test
    public void checkUrl() {


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        By commentText = By.xpath(".//div[@data-qa-node='detalis']");
        By receiverAmount = By.xpath(".//span[@data-qa-node='amound']");
        By receiverAmountCommission = By.xpath(".//span[@data-qa-node='commission']");
        By receiverAmountCommissionCurrency = By.xpath(".//span[@data-qa-node='commission-currency']");
        By payerCard = By.xpath(".//span[@data-qa-node='card']");
        By receiverCard = By.xpath(".//span[@data-qa-node='card']");
        By cardNumber = By.xpath(".//input[@maxlength='19']");



        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(By.xpath(".//input [@data-qa-node='phone-number']")).sendKeys("957699610");
        driver.findElement(By.xpath(".//input [@inputmode='decimal']")).clear();
        driver.findElement(By.xpath(".//input [@inputmode='decimal']")).sendKeys("50");
        driver.findElement(By.xpath(".//input[@maxlength='19']")).sendKeys("4567739561253907");
        driver.findElement(By.xpath(". //input[@data-qa-node='expiredebitSource']")).sendKeys("09/24");
        driver.findElement(By.xpath(".//input[@data-qa-node='cvvdebitSource']")).sendKeys("528");
        driver.findElement(By.xpath(".//button [@data-qa-node='submit']")).click();



        Assert.assertEquals("Пополнение телефона. На номер +380957699610", driver.findElement(commentText).getText());
        Assert.assertEquals("50 UAH", driver.findElement(receiverAmount).getText());
        Assert.assertEquals("* 3907", driver.findElement(payerCard).getText());
        Assert.assertEquals("2 ", driver.findElement(receiverAmountCommission).getText());
        Assert.assertEquals("UAH", driver.findElement(receiverAmountCommissionCurrency).getText());



        // -------------- После проверки экрана прогноза платежа, переходим к оплате в Корзину

        driver.findElement(By.xpath(".//button[contains(text(), 'Подтвердить')]")).click();

    }
}