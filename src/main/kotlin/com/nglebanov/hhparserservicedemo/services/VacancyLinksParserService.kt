package com.nglebanov.hhparserservicedemo.services

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.nglebanov.hhparserservicedemo.domain.RawLink
import com.nglebanov.hhparserservicedemo.repositories.RawLinksRepository
import com.nglebanov.hhparserservicedemo.utils.SelenideUtils
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service


@Service
class VacancyLinksParserService(
        private val rawLinksRepository: RawLinksRepository,
        private val selenideUtils: SelenideUtils
) {

    private val NEXT_BUTTON_XPATH = "//a[text()='дальше']"

    fun openHHWithSearchParameter(vacancyName: String) {
        Selenide.open("https://hh.ru/search/vacancy?area=1&st=searchVacancy&text=$vacancyName&fromSearch=true")
    }

    fun saveLinks(links: ElementsCollection) {
        rawLinksRepository.saveAll(
                links.map {
                    RawLink(it.getAttribute("href"))
                }
        )
        rawLinksRepository.flush()
    }

    fun findVacanciesAtPage() = Selenide.`$$x`("//a[@data-qa='vacancy-serp__vacancy-title']")


    fun closeDriver() {
        Selenide.closeWebDriver()
    }

    @Scheduled(fixedRate = 60000)
    fun schedulingParser() {
        openHHWithSearchParameter("qa")
        while (selenideUtils.isElementPresentsOnPage(NEXT_BUTTON_XPATH)) {
            saveLinks(findVacanciesAtPage())
            rawLinksRepository.findAll().forEach { println("$it ${it.id}") }
            Selenide.`$x`(NEXT_BUTTON_XPATH).click()
        }
        closeDriver()
    }
}