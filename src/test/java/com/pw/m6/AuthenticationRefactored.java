package com.pw.m6;

import com.pw.AuthScriptBase;
import org.junit.jupiter.api.Test;

public class AuthenticationRefactored extends AuthScriptBase {

    @Test
    public void auth() {
        page.navigate("https://github.com");
        // verify things being already logged in
        page.click("//button[@aria-label=\"Open user account menu\"]");
        page.click("text=stanchevyordan");
    }


    @Test
    public void auth2() {
        page.navigate("https://github.com/stanchevyordan");
        // verify things being already logged in
        page.click("//button[@aria-label=\"Open user account menu\"]");
        page.click("text=stanchevyordan");
    }
}
