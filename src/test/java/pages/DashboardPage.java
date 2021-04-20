package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="//*[@class='_23NUW98LaZfBpQ']")
    public WebElement boardTitleInput;


    @FindBy(xpath="//li[@class='boards-page-board-section-list-item']/a/div/div")
    public List<WebElement> allBoards;

    public  WebElement getBoard (String boardName){
        WebElement myBoard=null;
        for (WebElement each : allBoards) {
            if(each.getAttribute("title").equalsIgnoreCase(boardName)){
                myBoard=each;
            }
        }
        return myBoard;
    }
}
