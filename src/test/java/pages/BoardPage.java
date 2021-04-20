package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class BoardPage {
    public BoardPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".list-card-stickers-area.js-stickers-area.hide")
    public List<WebElement> allCards;

    @FindBy(css = ".badge-text")
    public List<WebElement> comments;

    @FindBy(css = ".list-card-details.js-card-details")
    public List<WebElement> cardList;

    @FindBy(css=".comment-box-input.js-new-comment-input")
        public WebElement commentInput;

    @FindBy(css=".nch-button.nch-button--primary.confirm.mod-no-top-bottom-margin.js-add-comment")
    public WebElement saveComment;

    @FindBy(css = ".current-comment.js-friendly-links.js-open-card>p")
    public List<WebElement> commentList;


    @FindBy(xpath="(//*[@class='open-card-composer js-open-card-composer'])[4]")
    public WebElement listDone;

    @FindBy(xpath = "(//div[@class='list js-list-content'])[2]/div[2]/a")
    public List<WebElement> doneCardList;


    public boolean checkComment(){
        if(comments.size()>0){
            return true;
        }else{
            return false;
        }

    }


    public boolean getComment(String comment){

        for (String eachComment  : BrowserUtils.getElementsText(commentList)) {
            if(eachComment.equals(comment)){
                return true;
            }
        }

        return false;
    }




}
