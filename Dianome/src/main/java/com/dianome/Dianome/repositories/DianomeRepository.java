package com.dianome.Dianome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dianome.Dianome.models.DianomeModel;

@Repository
public interface DianomeRepository extends JpaRepository<DianomeModel, Integer>{

	
}