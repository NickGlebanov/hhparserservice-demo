package com.nglebanov.hhparserservicedemo.repositories

import com.nglebanov.hhparserservicedemo.domain.CoreSkill
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface CoreSkillRepository : JpaRepository<CoreSkill, Int>