package com.example.randomquote

data class QuotesList(
    var count         : Int?               = null,
    var totalCount    : Int?               = null,
    var page          : Int?               = null,
    var totalPages    : Int?               = null,
    var lastItemIndex : Int?               = null,
    var results       : List<Results> = arrayListOf()
)
