package com.demo.account.repository;

import com.demo.account.entity.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AccountRepository extends CrudRepository<Accounts, Integer> {
}
