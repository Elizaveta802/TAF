package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private List<UIElement> uiElement;

    public RadioButton(WebDriver driver, By by){
        uiElement = new ArrayList<>();

        for (WebElement element : driver.findElements(by)) {
            uiElement.add(new UIElement(driver,element));
        }
    }
    public void select(String value) throws Exception {
        for(UIElement uiElement: uiElement){
            if(uiElement.getDomAttribute("value").equals(value)){
                uiElement.click();
                return;
            }
        }

        throw new Exception("Value was not found");
    }
}
