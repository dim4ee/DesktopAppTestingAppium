package com.winapp.step_definitions;
import com.winapp.utils.AppDriver;
import com.winapp.utils.DesktopDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class OpenDroidCam_StepDefinitions {

    @When("user press start")
    public void user_press_start() {
        WebElement start = AppDriver.getAppDriver().findElementByName("Start");
        start.click();

    }
    @When("user press ok")
    public void user_press_ok() {
        DesktopDriver.getDesktopDriver().findElementByName("OK").click();

    }
    @Then("user close the program")
    public void user_close_the_program() {
        AppDriver.getAppDriver().findElementByName("Close").click();
    }
}
