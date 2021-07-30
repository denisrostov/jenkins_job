package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class properties {
    @BeforeAll
    static void setup() {
        Configuration.remote = System.getProperty("url");
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        Configuration.startMaximized = true;
    }

    @Tag("properties")
    @Test
    void testOpen() {
        open("https://yandex.ru");
    }
}
//    void test (){
//        System.out.println("[BROWSER]" + System.getProperty("url"));
//    }
//}
 