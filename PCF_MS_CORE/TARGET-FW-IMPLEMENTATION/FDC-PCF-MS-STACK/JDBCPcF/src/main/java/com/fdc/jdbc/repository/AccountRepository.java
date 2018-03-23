package com.fdc.jdbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fdc.jdbc.dao.Account;

@Repository("springManagedServerRepository")
public interface  AccountRepository extends  JpaRepository<Account, String> {

}
