package com.br.aspli.alexandresiqueirabackend.api;

import com.br.aspli.alexandresiqueirabackend.services.authentication.AuthenticateResponse;
import com.br.aspli.alexandresiqueirabackend.services.authentication.AuthenticateRequest;
import com.br.aspli.alexandresiqueirabackend.services.authentication.IAutheticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/authentication")
public class AuthenticationController {

    @Autowired
    private IAutheticationService _autheticationService;

    @PostMapping()
    public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest request) {
        try {
            return ResponseEntity.ok().body(_autheticationService.authenticate(request));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
