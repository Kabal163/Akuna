package com.akuna.security.providers;

import com.akuna.journal.dto.PersonDto;

public interface RegistrationProvider<T extends PersonDto>
{
    void register(T person);
}
