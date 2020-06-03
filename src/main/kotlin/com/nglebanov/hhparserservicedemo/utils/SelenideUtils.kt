package com.nglebanov.hhparserservicedemo.utils

import com.codeborne.selenide.Selenide
import org.springframework.stereotype.Component

@Component
class SelenideUtils {

    fun isElementPresentsOnPage(xpath: String): Boolean {
        Selenide.sleep(1000)
        return Selenide.`$$x`(xpath).count() > 0
    }

}