package com.project.walletapp.Controller;

import com.project.walletapp.Entity.Wallet;
import com.project.walletapp.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Wallet wallet, BindingResult result){
        if (result.hasErrors()){
            Map<String, String> errorsMap = new HashMap<String, String>();
            for (FieldError error: result.getFieldErrors()){
                errorsMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorsMap, HttpStatus.BAD_REQUEST);
        }
        Wallet walletSaved = walletService.createOrUpdate(wallet);
        return new ResponseEntity<Wallet>(walletSaved, HttpStatus.CREATED);
    }
}
