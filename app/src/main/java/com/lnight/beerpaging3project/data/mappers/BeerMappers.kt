package com.lnight.beerpaging3project.data.mappers

import com.lnight.beerpaging3project.data.local.BeerEntity
import com.lnight.beerpaging3project.data.remote.BeerDto
import com.lnight.beerpaging3project.domain.Beer

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        firstBrewed = first_brewed,
        description = description,
        imageUrl = image_url
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        firstBrewed = firstBrewed,
        description = description,
        imageUrl = imageUrl
    )
}