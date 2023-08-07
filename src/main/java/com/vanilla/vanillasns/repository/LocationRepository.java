package com.vanilla.vanillasns.repository;

import com.vanilla.vanillasns.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}