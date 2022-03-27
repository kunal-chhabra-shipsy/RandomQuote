package com.example.randomquote

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotesTable")
data class Results(
    @PrimaryKey(autoGenerate = true)
    var id : Int ,
    var author       : String?           = null,
    var content      : String?           = null,
    var authorSlug   : String?           = null,
    var length       : Int?              = null,
    var dateAdded    : String?           = null,
    var dateModified : String?           = null

)