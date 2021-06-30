package com.tmb.driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.BrowserInvocationFailed;
import com.tmb.factories.DriverFactory;
import com.tmb.utils.JsonUtils;
import com.tmb.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Suraj
 *
 */

public final class Driver {

	private Driver() {

	}

	public static void initDriver(String browser) {

		// System.out.println(Thread.currentThread().getId() + ":" + Driver.driver);

//
		if (Objects.isNull(DriverManager.getDriver())) {

			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailed("Browser invoxation failed", e);
			}

			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));

		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
