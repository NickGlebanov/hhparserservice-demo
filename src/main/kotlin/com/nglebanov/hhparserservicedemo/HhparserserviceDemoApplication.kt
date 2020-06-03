package com.nglebanov.hhparserservicedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class HhparserserviceDemoApplication

fun main(args: Array<String>) {
	runApplication<HhparserserviceDemoApplication>(*args)
}
