package com.nglebanov.hhparserservicedemo.repositories

import com.nglebanov.hhparserservicedemo.domain.RawLink
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface RawLinksRepository : JpaRepository<RawLink, Int>