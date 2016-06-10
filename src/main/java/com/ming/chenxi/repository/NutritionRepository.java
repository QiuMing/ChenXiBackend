package com.ming.chenxi.repository;

import com.ming.chenxi.domain.Nutrition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ming on 2016/4/23.
 */
public interface NutritionRepository extends JpaRepository<Nutrition,Integer> {
    Page<Nutrition> findAll(Pageable pageable);

    Nutrition findByName(String name);
}
