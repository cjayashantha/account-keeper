package com.nxtappz.accountkeeper.dto

data class Account(
    val id: Int,
    val account: String,
    val username: String,
    val password: String,
    val image: Int
) {
}