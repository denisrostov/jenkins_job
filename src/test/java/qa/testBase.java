package qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

import static config.Credentials.credentials;
import static java.lang.String.format;

public class testBase {
    @BeforeAll
    static void setup() throws MalformedURLException {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "91.0");

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
      Configuration.remote = "http://localhost:4444/wd/hub/";
        Configuration.remote = "http://35.246.17.73:4444/wd/hub/";
//        Configuration.remote = format(
//                "https://%s:%s@%s/wd/hub/",
//                credentials.login(),
//                credentials.password(),
//                System.getProperty("URL")
//        );

    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}


//java -DprojectName=local -Denv=test -DreportLink="ya.ru" -Dconfig.file=./telegram.json -jar -jar allure-notifications-3.1.1.jar