package com.pw.m6;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

public class Authentication {

    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    public void auth() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://github.com/login");

        // sign in
        // set your login and password
        page.fill("#login_field", "stanchevyordan");
        page.fill("#password", "Maltese_warrior975");
        page.click("'Sign in'");
        Assertions.assertEquals(page.url(), "https://github.com/");

        // verify sign in
        page.click("//button[@aria-label=\"Open user account menu\"]");
        page.click("text=stanchevyordan");

        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));
    }




    @Test
    public void auth2() {

        context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json")));

        page = context.newPage();
        page.navigate("https://github.com");
        // verify already logged in
        page.click("//button[@aria-label=\"Open user account menu\"]");
        page.click("text=stanchevyordan");
    }
}
