package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;

public class Base_PO {

    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateToURL(String url) {
        getDriver().get(url);
    }

    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void clickOnButton(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void clickOnButton(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void getTheMainTextOnProductsPage(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        By locator = By.cssSelector("span.title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String productsText = getDriver().findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(productsText, text);
    }

    public void getTheErrorMessage(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        By locator = By.xpath("//h3[@data-test='error']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String errorText = getDriver().findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorText, text);
    }

    public void userLocked(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        By locator = By.xpath("//h3[@data-test='error']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String errorText = getDriver().findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorText, text);
    }

    public void requiredInputFieldUsername(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        By locator = By.xpath("//h3[@data-test='error']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String requiredFieldsText = getDriver().findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(requiredFieldsText, text);
    }

    public void requiredInputFieldPassword(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        By locator = By.xpath("//h3[@data-test='error']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String requiredFieldsText = getDriver().findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(requiredFieldsText, text);
    }


}
