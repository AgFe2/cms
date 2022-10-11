package com.AgFe2.cms.user.service;

import com.AgFe2.cms.user.domain.SignUpForm;
import com.AgFe2.cms.user.domain.model.Customer;
import com.AgFe2.cms.user.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpCustomerService {

    private final CustomerRepository customerRepository;

    public Customer signUp(SignUpForm form) {
        return customerRepository.save(Customer.from(form));
    }
}
