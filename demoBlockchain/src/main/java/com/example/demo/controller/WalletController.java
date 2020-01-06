package com.example.demo.controller;

import com.example.demo.entity.Wallet;
import com.example.demo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WalletController {

    @Autowired
    WalletService walletService;


    @GetMapping("/create")
    @ResponseBody
    Wallet create(@RequestParam String secret) {
        return walletService.create(secret);
    }

    @GetMapping("/wallets")
    @ResponseBody
    List<Wallet> getAll() {
        return walletService.getAll();
    }

    @GetMapping("/transfer")
    @ResponseBody
    List<Wallet> transfer(@RequestParam Long from,
                          @RequestParam Long to,
                          @RequestParam double amount,
                          @RequestParam String secret) {
        return walletService.transfer(from, to, amount, secret);
    }

}
