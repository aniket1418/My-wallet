package com.project.walletapp.Service;

import com.project.walletapp.Entity.Wallet;
import com.project.walletapp.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;
    //create or update method
    public Wallet createOrUpdate(Wallet wallet){
        if(wallet.getId()==null){
            walletRepository.save(wallet);
        }
        else{
            walletRepository.save(wallet);
        }
        return wallet;
    }
    //delete the wallet
    public boolean delete(Long id){
        Optional<Wallet> wallet = walletRepository.findById(id);
        if(wallet.isPresent()){
            walletRepository.delete(wallet.get());
            return true;
        }
        //Todo
    }
}
