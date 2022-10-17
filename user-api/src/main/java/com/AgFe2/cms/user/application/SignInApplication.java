package com.AgFe2.cms.user.application;

import com.AgFe2.cms.user.domain.SignInForm;
import com.AgFe2.cms.user.domain.model.Customer;
import com.AgFe2.cms.user.exception.CustomException;
import com.AgFe2.cms.user.service.CustomerService;
import com.AgFe2.domain.config.JwtAuthenticationProvider;
import com.AgFe2.domain.domain.common.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.AgFe2.cms.user.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class SignInApplication {

    private final CustomerService customerService;
    private final JwtAuthenticationProvider provider;

    public String customerLoginToken(SignInForm form) {
        // 1. 로그인 가능 여부
        Customer c = customerService.findValidCustomer(form.getEmail(), form.getPassword())
                .orElseThrow(() -> new CustomException(LOGIN_CHECK_FAIL));
        // 2. 토큰 발행
        // 3. 토큰을 response
        return provider.createToken(c.getEmail(), c.getId(), UserType.CUSTOMER);
    }
}
