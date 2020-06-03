package com.nglebanov.hhparserservicedemo

import com.nglebanov.hhparserservicedemo.domain.Company
import com.nglebanov.hhparserservicedemo.domain.CoreSkill
import com.nglebanov.hhparserservicedemo.domain.Vacancy
import com.nglebanov.hhparserservicedemo.repositories.CompanyRepository
import com.nglebanov.hhparserservicedemo.repositories.CoreSkillRepository
import com.nglebanov.hhparserservicedemo.repositories.VacancyRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import org.assertj.core.api.Assertions.*


@SpringBootTest
class RepositoriesTest {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var coreSkillRepository: CoreSkillRepository

    @Autowired
    lateinit var vacancyRepository: VacancyRepository

    fun prepareDB() {
        companyRepository.saveAndFlush(
                Company(
                        1,
                        "Test Company",
                        null
                )
        )
        coreSkillRepository.saveAndFlush(
                CoreSkill(1, "skill1", null)
        )
        coreSkillRepository.saveAndFlush(
                CoreSkill(2, "skill2", null)
        )
    }

    @Test
    fun saveTest() {
        prepareDB()
        assertThat(companyRepository.count()).isEqualTo(1)
    }

    @Test
    fun getTest() {
        prepareDB()
        assertThat(companyRepository.getOne(1)).isNotNull
    }
}