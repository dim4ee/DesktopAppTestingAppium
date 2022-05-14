package com.winapp.step_definitions;


import com.winapp.utils.AppDriver;
import com.winapp.utils.DBUtils;
import com.winapp.utils.DesktopDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before("@db")
    public void dbHook() {
        System.out.println("creating database connection");
        DBUtils.createConnection();
    }

    @After("@db")
    public void afterDbHook() {
        System.out.println("closing database connection");
        DBUtils.destroyConnection();

    }

    @Before
    public void setUp() {
        // we put a logic that should apply to every scenario
        AppDriver.getAppDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void teardownScenario(Scenario scenario){


        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) AppDriver.getAppDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }




        AppDriver.closeAppDriver();
        DesktopDriver.closeAppDriver();


    }
}
