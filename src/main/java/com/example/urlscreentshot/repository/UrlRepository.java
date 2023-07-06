package com.example.urlscreentshot.repository;

import com.example.urlscreentshot.model.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
    UrlEntity findByUrlId(String urlId);
}
