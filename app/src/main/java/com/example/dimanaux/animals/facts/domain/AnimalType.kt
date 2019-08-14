package com.example.dimanaux.animals.facts.domain

enum class AnimalType {
    CAT, DOG, SNAIL, HORSE;

    override fun toString() = name.toLowerCase()
}
