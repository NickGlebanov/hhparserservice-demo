package com.nglebanov.hhparserservicedemo.domain

import javax.persistence.*

@Entity
data class RawLink(

        @Column(nullable = false)
        val link: String?
){
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null
}