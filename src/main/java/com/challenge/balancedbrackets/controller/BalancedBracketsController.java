package com.challenge.balancedbrackets.controller;

import com.challenge.balancedbrackets.controller.form.BalancedBracketsForm;
import com.challenge.balancedbrackets.service.BalancedBracketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balanced_brackets")
public class BalancedBracketsController {

    @Autowired
    private BalancedBracketsService balancedBracketsService;

    @PostMapping
    public ResponseEntity<Boolean> balancedBrackets(@RequestBody BalancedBracketsForm balancedBracketsForm) {
        return ResponseEntity.ok(balancedBracketsService.isBalanced(balancedBracketsForm));
    }

}