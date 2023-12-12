package com.pw.m5;

import com.microsoft.playwright.Page;
import com.pw.ScriptBase;
import org.junit.jupiter.api.Test;

public class ClickFillOptions extends ScriptBase {

    @Test
    public void fillOptions () {
        page.navigate(home);
        page.fill("id=exampleMessage", "Planche is a great way to build strength.",
                                                    new Page.FillOptions().setForce(true));
    }
}
