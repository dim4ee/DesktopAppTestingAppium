package com.winapp.utils;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppDriver {

    private AppDriver(){}

    private static WindowsDriver appDriver;


    public static WindowsDriver getAppDriver(){

        if (appDriver == null){

            String appPath = ConfigurationReader.getProperty("path");
            String url = ConfigurationReader.getProperty("url");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", appPath);

            try {
                appDriver = new WindowsDriver(new URL(url), capabilities);
                appDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }

    return appDriver;

    }

    public static void closeAppDriver() {
        if (appDriver != null) {
            appDriver.quit();
            appDriver = null;
        }
    }


}
