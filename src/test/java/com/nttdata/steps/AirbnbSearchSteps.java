package com.nttdata.steps;

import com.nttdata.screens.LoginScreen;
import com.nttdata.screens.SearchDetailsScreen;
import com.nttdata.screens.SearchScreen;
import net.thucydides.core.annotations.Step;

public class AirbnbSearchSteps {

    LoginScreen loginScreen;
    SearchScreen searchScreen;
    SearchDetailsScreen searchDetailsScreen;


    @Step("Click en cerrar ventanas emergentes")
    public void clickClose(){
        loginScreen.clickClose();
        sleepMethod(5000);
        loginScreen.clickClose();

    }

    @Step("Búsqueda por texto {0}")
    public void searchByText(String place){
        sleepMethod(5000);
        searchScreen.clickSearchInput();
        sleepMethod(5000);
        searchDetailsScreen.enterSearchInput(place);
    }

    @Step("Click en boton skip")
    public void clickSkip(){
        searchDetailsScreen.clickSkip();
    }

    @Step("Click en boton search")
    public void clickSearch(){
        searchDetailsScreen.clickSearch();
    }

    @Step("Obtiene el texto del resultado")
    public String getResultText(){
        return searchScreen.getResultText();
    }

    public void sleepMethod(Integer time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
