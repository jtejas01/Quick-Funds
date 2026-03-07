package com.app.quickFund.repositories;

import com.app.quickFund.entities.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccountEntity,Long> {

}
