package com.krukun.repository;

import com.krukun.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Eugeniy Krukun on 26.04.2016.
 */
public interface MenuRepository extends JpaRepository<Menu,Long> {
}
