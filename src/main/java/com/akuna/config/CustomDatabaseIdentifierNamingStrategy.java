package com.akuna.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.io.Serializable;
import java.util.Locale;

public class CustomDatabaseIdentifierNamingStrategy extends SpringPhysicalNamingStrategy implements Serializable
{

    public static final long serialVersionUID = 1L;
    public static final CustomDatabaseIdentifierNamingStrategy INSTANCE = new CustomDatabaseIdentifierNamingStrategy();

    @Override
    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment)
    {
        if (isCaseInsensitive(jdbcEnvironment)) {
            name = name.toUpperCase(Locale.ROOT);
        }
        return new Identifier(name, quoted);
    }
}
