package com.mangxiao.finance.service.impl;

import com.mangxiao.common.model.Account;
import com.mangxiao.finance.mapper.AccountMapper;
import com.mangxiao.finance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Boolean addAccount(Account account) {
        if (accountMapper.addAccount(account) > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
