package com.dkbcodefactory.shorturl.entity

import org.springframework.data.annotation.CreatedDate
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class UrlEntity(
    @Id val hashUrl: String,
    val originalUrl: String,
    @CreatedDate val insertDate: Instant?,
) {
    constructor() : this("", "", null) {

    }
}