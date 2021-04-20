package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BoardPage;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class BoardDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @Given("the user enters with valid credentials")
    public void the_user_enters_with_valid_credentials() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        BrowserUtils.waitFor(2);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @When("the user is on Board Page")
    public void the_user_is_on_Board_Page() {
        BrowserUtils.waitFor(3);
        DashboardPage boardPage = new DashboardPage();
        boardPage.getBoard("BoardTest").click();
    }

    @Then("Verify there are {int} cards on the board")
    public void verify_there_are_cards_on_the_board(Integer cardNumber) {
        BrowserUtils.waitFor(3);
        Assert.assertEquals(2, new BoardPage().allCards.size());
    }


    @Then("verify there is a card with comment")
    public void verify_there_is_a_card_with_comment() {
        Assert.assertTrue(new BoardPage().checkComment());
    }


    @When("clicks on the card")
    public void clicks_on_the_card() {
        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(3);
        new BoardPage().cardList.get(0).click();
    }

    @When("writes a comment inside the card as {string}")
    public void writes_a_comment_inside_the_card_as(String comment) {
        new BoardPage().commentInput.sendKeys(comment);
    }

    @When("clicks the save button")
    public void clicks_the_save_button() {
        new BoardPage().saveComment.click();
    }

    @Then("Should be seen added comment as {string}")
    public void should_be_seen_added_comment(String comment) {
        Driver.get().navigate().refresh();
        Assert.assertTrue(new BoardPage().getComment(comment));
    }


    @When("drag and drop the card to Done")
    public void drag_and_drop_the_card_to_Done() {
        Actions action = new Actions(Driver.get());
        Driver.get().navigate().refresh();
        action.moveToElement(new BoardPage().cardList.get(0)).pause(1).dragAndDrop(new BoardPage().cardList.get(0), new BoardPage().listDone).perform();
    }

    @Then("the card should be seen in Done")
    public void the_card_should_be_seen_in_Done() {
        Driver.get().navigate().refresh();
        for (WebElement each : new BoardPage().doneCardList ) {
            Assert.assertTrue(each.getAttribute("href").contains("card1"));
        }

    }


}
