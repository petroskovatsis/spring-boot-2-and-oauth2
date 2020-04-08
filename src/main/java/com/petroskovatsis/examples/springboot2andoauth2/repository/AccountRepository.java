package com.petroskovatsis.examples.springboot2andoauth2.repository;

import com.petroskovatsis.examples.springboot2andoauth2.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);
}
