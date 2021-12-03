package com.example.s205348_lykkehjulet.data.model


enum class WheelItems (val value: Int){
    GET100(100),
    GET200(200),
    GET500(500),
    GET1000(1000),
    EXTRATURN(0),
    BANKRUPT(0),
    MISSTURN(0);

    companion object {
        fun fromInt(value: Int) = WheelItems.values().first { it.value == value }
    }
}