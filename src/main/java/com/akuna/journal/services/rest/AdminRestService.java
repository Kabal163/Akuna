package com.akuna.journal.services.rest;

import com.akuna.journal.dto.impls.AdministratorDtoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface AdminRestService
{
    public ResponseEntity<Boolean> create(AdministratorDtoModel model, UriComponentsBuilder ucBuilder);
}
