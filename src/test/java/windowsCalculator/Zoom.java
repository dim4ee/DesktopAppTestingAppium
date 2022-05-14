package windowsCalculator;


import com.winapp.utils.AppDriver;
import com.winapp.utils.DesktopDriver;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Zoom {




    @Test
    public void test1()  {
        AppDriver.getAppDriver().findElementByName("Start").click();

        DesktopDriver.getDesktopDriver().findElementByName("OK").click();

        AppDriver.getAppDriver().findElementByName("Close").click();



    }



}
