package com.vanilla.vanillasns.repository;

import com.vanilla.vanillasns.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
}