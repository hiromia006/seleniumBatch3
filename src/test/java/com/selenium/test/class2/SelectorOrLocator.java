package com.selenium.test.class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectorOrLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        //Implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement webElement = driver.findElement(By.id("customer.firstName"));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));

        webElement.clear();
        webElement.sendKeys("Ali");
        Thread.sleep(3000);

        System.out.println(driver.findElement(By.className("title")).getText());
        Thread.sleep(3000);

        WebElement lastName = driver.findElement(By.name("customer.lastName"));
        lastName.clear();
        lastName.sendKeys("Ahsan");
        Thread.sleep(3000);


        driver.findElement(By.partialLinkText("gin info?")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.tagName("title")).getText());

        String xpath = driver.findElement(By.xpath("/html/body/div[2]/div/ul[1]/li[5]/a")).getText();

        System.out.println(xpath);

        driver.findElement(By.cssSelector("input[id='customer.ssn']")).sendKeys("asdsajadlk");
        Thread.sleep(3000);
        driver.quit();
    }
}
