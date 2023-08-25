package edu.timurmakhmutov.bookhelper.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String? = null,
    @ColumnInfo(name = "progressList")
    var progressList: Int? = null,
    @ColumnInfo(name = "maxList")
    var maxList: Int? = null,
    @ColumnInfo(name = "review")
    var review: String? = null
)
