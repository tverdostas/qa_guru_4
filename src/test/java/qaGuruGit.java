import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class qaGuruGit {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 40000;
    }

    @AfterAll
    public static void AfterAll(){
        WebDriverRunner.closeWebDriver();
    }

    @Test
    void qaGuruGitTest(){
        open("https://github.com/");
         $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("[href='/selenide/selenide']").click();
        $("[data-content='Wiki']").click();

        $(byText("Show 3 more pages…")).click();
        $(byText("SoftAssertions")).shouldBe(visible);

        $(byText("SoftAssertions")).click();

        $(byText("3. Using JUnit5 extend test class:")).shouldBe(visible);

        $("#wiki-body").shouldHave(text(
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
    }
}
