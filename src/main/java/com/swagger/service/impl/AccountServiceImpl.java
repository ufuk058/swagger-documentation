package com.swagger.service.impl;

import com.swagger.util.MapperUtil;
import com.swagger.dto.AccountDTO;
import com.swagger.entity.Account;
import com.swagger.repository.AccountRepository;
import com.swagger.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final MapperUtil mapperUtil;

    public AccountServiceImpl(AccountRepository accountRepository, MapperUtil mapperUtil) {
        this.accountRepository = accountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AccountDTO> getAccounts() {

        List<Account> list= accountRepository.findAll();
       return list.stream().map(account -> mapperUtil.convert(account, new AccountDTO())).collect(Collectors.toList());
    }

    @Override
    public AccountDTO getById(Long id) throws Exception {

        return mapperUtil.convert(accountRepository.findById(id).orElseThrow(()-> new Exception("Account not found!")),new AccountDTO());
    }
}
