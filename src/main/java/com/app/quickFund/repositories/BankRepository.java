package com.app.quickFund.repositories;

import com.app.quickFund.entities.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<BankEntity,Long> {

    Optional<BankEntity> findByIfsc(String ifsc);
}
