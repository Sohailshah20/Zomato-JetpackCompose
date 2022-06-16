package com.example.zomatoclone.presentation

enum class SearchChips(val category : String) {
    SORT("Sort"),
    FastDELIVERY("Fast Delivery"),
    GREATOFFERS("Great Offers"),
    RATING("Rating 4.0+"),
    NEWARRIVIALS("New Arrivals"),
    PUREVEG("Pure Veg"),
    CUISINES("Cuisines"),
    MAXSAFETY("Max Safety"),
    MORE("More")
}

fun getAllCategories() : List<SearchChips>{
    return listOf(
        SearchChips.SORT,
        SearchChips.FastDELIVERY,
        SearchChips.GREATOFFERS,
        SearchChips.RATING,
        SearchChips.NEWARRIVIALS,
        SearchChips.PUREVEG,
        SearchChips.CUISINES,
        SearchChips.MAXSAFETY,
        SearchChips.MORE,
    )
}

fun getCategory(category: String) : SearchChips? {
    val map = SearchChips.values().associateBy(SearchChips::category)
    return map[category]
}