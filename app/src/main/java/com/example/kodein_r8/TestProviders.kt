package com.example.kodein_r8

interface Provider {
    val value: Int
}

interface ManagedProvider {
    var value: Int
}

class ProviderImpl : Provider, ManagedProvider {
    override var value = 0
}