package windowsCalculator;


import io.appium.java_client.windows.WindowsDriver;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Zoom {

    public static WindowsDriver driver;
    public static WindowsDriver desktop;


    @BeforeClass
    public static void setup() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Program Files (x86)\\DroidCam\\DroidCamApp.exe");
        try {

            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        DesiredCapabilities desktopCapabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Root");
        try {

            desktop = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            desktop.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void test1() throws InterruptedException {
        driver.findElementByName("Start").click();

        desktop.findElementByName("OK").click();

        driver.findElementByName("Close").click();



    }

}
