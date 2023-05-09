package com.br.aspli.alexandresiqueirabackend.services.authentication;

public interface IAutheticationService {
    AuthenticateResponse authenticate(AuthenticateRequest request) throws Exception;
}