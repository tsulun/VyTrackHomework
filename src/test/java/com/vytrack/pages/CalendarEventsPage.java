package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExcelUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[contains(text(),'Options')]")
    public WebElement pageSubtitleOptions;

    @FindBy(xpath = "//input[@tabindex='-1']")
    public WebElement checkboxes;

    @FindBy(xpath = "//button/input[1]")
    public WebElement topCheckBox;

    @FindBy(xpath = "//li/input[@type='number']")
    public WebElement pageNumberInput;

    @FindBy(xpath = "//div[contains(text(),'Options')]")
    public WebElement options;

    @FindBy(css = "input.input-widget")
    public WebElement pageNumber;

    @FindBy(xpath = "//*[contains(text(),'Next')]")
    public WebElement nextButton;

    @FindBy(xpath = "//label[contains(text(),'records')]")
    public WebElement totalRecords;

    @FindBy(xpath = "//tbody/tr")
    public WebElement totalRowsOnAPage;

    @FindBy(xpath = "(//label[@class='dib'])[2]")
    public WebElement totalPages;

    @FindBy(xpath = "//div[@class='btn-group']//button")
    public WebElement dropdownViewPerPage;

    @FindBy(xpath = "(//ul[@class='dropdown-menu pull-right']//li)[4]")
    public WebElement dropdownViewPerPage100;

    @FindBy(xpath = "//div[@class='btn-group dropdown']/button/input")
    public WebElement checkbox;

    @FindBy(xpath = "//tbody/tr/td/input")
    public WebElement allCheckBoxInAPage;

    @FindBy(xpath = "//tbody//tr//td[contains(text(),'Testers meeting')]")
    public WebElement testersMeeting;

    @FindBy(xpath = "//div[@class='controls']//div[starts-with(@class,'control-label')]")
    public List<WebElement> attributeRowDescription;

    @FindBy(xpath = "//div[@class='control-group attribute-row']//label")
    public List<WebElement> attributeRowTitles;



    /**
     * @return page number, for example: 1
     */
    public String getPageNumber(){
        waitUntilLoaderScreenDisappear();
       return pageNumberInput.getAttribute("value");
    }

    public int numberOfRowsPerPage;
    public void selectViewPerPage100(){
        BrowserUtils.clickWithTimeOut(dropdownViewPerPage, 5);

        BrowserUtils.waitForVisibility(dropdownViewPerPage100, 5);
        waitUntilLoaderScreenDisappear();

        String select100 = dropdownViewPerPage100.getText();
        numberOfRowsPerPage = Integer.parseInt(select100);

        BrowserUtils.clickWithTimeOut(dropdownViewPerPage100, 2);
    }

    public int totalPage;
    public void getTotalNumberOfPages(){
        BrowserUtils.waitForVisibility(totalPages, 2);
        String pages = totalPages.getText();
        String[] pagesSplit = pages.split(" ");
        String totalNumberPages = pagesSplit[1];
        totalPage = Integer.parseInt(totalNumberPages);
    }

    public int totalNumberRecords;
    public void getTotalNumberOfRecords(){
        BrowserUtils.waitForVisibility(totalRecords, 2);

        String records = totalRecords.getText();
        String[] recordsSplit = records.split(" ");
        totalNumberRecords = Integer.parseInt(recordsSplit[2]);
    }

    public List<WebElement> rows = new ArrayList<>();
    public void getTotalNumberOfRows(){
        for (int i = 1; i <= totalPage; i++) {
            for (int j = 1; j <= numberOfRowsPerPage; j++) {
                rows.add(totalRowsOnAPage);
            }
            BrowserUtils.clickWithTimeOut(nextButton, 2);
        }
    }

    public void findMeeting(WebElement meetingName){
        outer: for (int i = 1; i <= totalPage; i++) {
            for (int j = 1; j <= numberOfRowsPerPage; j++) {
                if (meetingName.isDisplayed()) {
                    BrowserUtils.clickWithTimeOut(meetingName, 3);
                    break outer;
                } else {
                    BrowserUtils.clickWithTimeOut(nextButton, 3);
                    break;
                }
            }
        }
    }

    public Map<String, String> actualTitleAndDescription;
    public void getMeetingDetails(){
        actualTitleAndDescription = new LinkedHashMap<>();

        int attributeRowTitle = attributeRowTitles.size();
        for (int i = 0; i < attributeRowTitle; i++) {
            waitUntilLoaderScreenDisappear();
            actualTitleAndDescription.put(attributeRowTitles.get(i).getText(), attributeRowDescription.get(i).getText());
        }
    }

    public  Map<String, String> expectedTitleAndDescription;
    public void getExcelDetails(String path, String sheetName){
        ExcelUtil data = new ExcelUtil(path, sheetName);

        expectedTitleAndDescription = new LinkedHashMap<>();

        String key = "";
        String value = "";

        for (int i = 0; i < data.columnCount(); i++) {
            for (int j = 0; j < 1; j++) {
                key = data.getCellData(j, i);
                value = data.getCellData((j + 1), i);
            }
            expectedTitleAndDescription.put(key, value);
        }
    }


}
