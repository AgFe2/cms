package com.AgFe2.cms.user.controller;

import com.AgFe2.cms.user.domain.customer.CustomerDto;
import com.AgFe2.cms.user.domain.model.Customer;
import com.AgFe2.cms.user.exception.CustomException;
import com.AgFe2.cms.user.exception.ErrorCode;
import com.AgFe2.cms.user.service.CustomerService;
import com.AgFe2.domain.config.JwtAuthenticationProvider;
import com.AgFe2.domain.domain.common.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.AgFe2.cms.user.exception.ErrorCode.NOT_FOUND_USER;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final JwtAuthenticationProvider provider;
    private final CustomerService customerService;

    @GetMapping("/getInfo")
    public ResponseEntity<CustomerDto> getInfo(@RequestHeader(name = "X-AUTH-TOKEN") String token) {
        UserVo vo = provider.getUserVo(token);
        Customer c = customerService.findByIdAndEmail(vo.getId(), vo.getEmail())
                .orElseThrow(() -> new CustomException(NOT_FOUND_USER));
        return ResponseEntity.ok(CustomerDto.from(c));
    }

}
