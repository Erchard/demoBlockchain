package com.example.demo.repository;

import com.example.demo.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;


// TODO: уязвизмость БД

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
