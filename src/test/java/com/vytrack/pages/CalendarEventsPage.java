package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//li/input[@type='number']")
    public WebElement pageNumberInput;


    /**
     * @return page number, for example: 1
     */
    public String getPageNumber(){
        waitUntilLoaderScreenDisappear();
       return pageNumberInput.getText();
    }

}
