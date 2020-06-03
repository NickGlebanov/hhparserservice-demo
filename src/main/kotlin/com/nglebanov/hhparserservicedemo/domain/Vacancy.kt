package com.nglebanov.hhparserservicedemo.domain

import javax.persistence.*

@Entity
data class Vacancy(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @ManyToOne
        @JoinColumn(name = "vacancies", nullable = true)
        val company: Company,

        @Column(nullable = false)
        val vacancyText: String,

        @Column(nullable = false)
        val experience: String,

        @OneToMany(mappedBy = "vacancy", cascade = [CascadeType.ALL])
        val coreSkills: MutableSet<CoreSkill>
)