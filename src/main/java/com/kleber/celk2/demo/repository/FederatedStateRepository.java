package com.kleber.celk2.demo.repository;

import com.kleber.celk2.demo.model.FederatedState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FederatedStateRepository extends JpaRepository<FederatedState,Long>{
}
