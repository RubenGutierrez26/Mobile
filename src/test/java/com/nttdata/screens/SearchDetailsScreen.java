package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchDetailsScreen extends PageObject {

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Search destinations\"]")
    private WebElement searchDetailInput;

    @AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.airbnb.android:id/input_bar_input\"]")
    private WebElement searchDetailInputText;

    @AndroidFindBy(xpath ="//android.widget.Button[@resource-id=\"com.airbnb.android:id/n2_simple_search_footer_link\"]")
    private WebElement skipButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.airbnb.android:id/n2_dls_action_footer_gradient_button\"]")
    private WebElement searchButton;



    public void enterSearchInput(String place){
        searchDetailInput.click();
        searchDetailInputText.sendKeys(place);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();

    }

    public void clickSkip(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(skipButton));
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        skipButton.click();

    }

    public void clickSearch(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        searchButton.click();
    }

}
