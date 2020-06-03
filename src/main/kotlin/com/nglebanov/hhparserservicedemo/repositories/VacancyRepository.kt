package com.nglebanov.hhparserservicedemo.repositories

import com.nglebanov.hhparserservicedemo.domain.Vacancy
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface VacancyRepository : JpaRepository<Vacancy, Int>