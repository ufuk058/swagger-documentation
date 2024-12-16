package com.swagger.service;

import com.swagger.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    List<AccountDTO> getAccounts();
    AccountDTO getById(Long id) throws Exception;
}
