package com.dkbcodefactory.shorturl.repository

import com.dkbcodefactory.shorturl.entity.UrlEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UrlRepository : JpaRepository<UrlEntity, String> {
    fun findByHashUrl(hashCode: String) : Optional<UrlEntity>
}