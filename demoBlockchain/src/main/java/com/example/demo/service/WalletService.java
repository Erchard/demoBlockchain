package com.example.demo.service;

import com.example.demo.entity.Wallet;
import com.example.demo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    public Wallet create(String secret) {
        Wallet wallet = new Wallet();
        // TODO: Справедливая эмиссия
        wallet.setBallance(100);
        wallet.setSecret(secret);

        walletRepository.save(wallet);
        return wallet;
    }

    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    public List<Wallet> transfer(Long from, Long to, double amount, String secret) {

        List<Wallet> result = new ArrayList<>();

        Wallet fromWallet = walletRepository.findById(from).orElse(null);
        Wallet toWallet = walletRepository.findById(to).orElse(null);



        if(fromWallet == null || toWallet == null){
            return result;
        }

        if(!fromWallet.getSecret().equals(secret)){
            return result;
        }

        if (fromWallet.getBallance() < amount) {
            return result;
        }


        fromWallet.setBallance(
                fromWallet.getBallance() - amount
        );

        toWallet.setBallance(
                toWallet.getBallance() + amount
        );

        result.add(fromWallet);
        result.add(toWallet);

        walletRepository.saveAll(result);

        return result;
    }
}
