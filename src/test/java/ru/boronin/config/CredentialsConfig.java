package ru.boronin.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:credential.properties"})
public interface CredentialsConfig extends Config {
    @Key ("user")
    String user();
    @Key ("password")
    String password();

}
