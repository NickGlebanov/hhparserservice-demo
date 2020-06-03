package com.nglebanov.hhparserservicedemo.domain

import javax.persistence.*

@Entity
data class CoreSkill(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val skillName: String,

        @ManyToOne
        @JoinColumn(name = "coreSkills", nullable = true)
        val vacancy: Vacancy?
)