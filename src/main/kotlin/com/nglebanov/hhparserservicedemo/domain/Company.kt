package com.nglebanov.hhparserservicedemo.domain

import javax.persistence.*

@Entity
data class Company(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val companyName: String,

        @OneToMany(mappedBy = "company", cascade = [CascadeType.ALL])
        val vacancies: MutableList<Vacancy>?
)