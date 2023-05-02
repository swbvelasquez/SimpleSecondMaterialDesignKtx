package com.swbvelasquez.simplesecondmaterialdesignktx.utils

data class Data(
    val name:String,
    val photoRes:Int,
    val type:Int
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Data

        if (name != other.name) return false
        if (photoRes != other.photoRes) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + photoRes
        result = 31 * result + type
        return result
    }
}