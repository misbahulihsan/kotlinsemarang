package com.misbahulihsan.kotlinsemarang

data class ManusiaContract(
    val id: Long?,
    val nama: String,
    val address: String
) {
    companion object {
        const val TABLE_HUMAN = "table_human"
        const val ID = "id"
        const val NAME = "name"
        const val ADDRESS = "address"
    }
}
