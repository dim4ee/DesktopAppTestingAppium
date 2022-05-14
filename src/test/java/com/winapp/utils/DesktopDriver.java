package com.winapp.utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DesktopDriver {

    private DesktopDriver(){
    }

    private static WindowsDriver desktopDriver;


    public static WindowsDriver getDesktopDriver(){

        if (desktopDriver == null){

            String url = ConfigurationReader.getProperty("url");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Root");

            try {
                desktopDriver = new WindowsDriver(new URL(url), capabilities);
                desktopDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }

        return desktopDriver;

    }

    public static void closeAppDriver() {
        if (desktopDriver != null) {
            desktopDriver.quit();
            desktopDriver = null;
        }
    }
}
