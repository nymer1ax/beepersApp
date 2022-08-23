package com.co.beepers.config;

import co.com.bancolombia.secretsmanager.api.GenericManager;
import co.com.bancolombia.secretsmanager.connector.AWSSecretManagerConnector;
import co.com.bancolombia.secretsmanager.api.exceptions.SecretException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretsConfig {


  @Bean
  public GenericManager getSecretManager(@Value("${aws.region}") String region) {
    return new AWSSecretManagerConnector(region);
  }
}
