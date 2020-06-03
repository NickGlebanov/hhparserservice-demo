package com.nglebanov.hhparserservicedemo.repositories

import com.nglebanov.hhparserservicedemo.domain.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface CompanyRepository : JpaRepository<Company, Int>