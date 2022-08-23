package com.co.beepers.jpa.config;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DBSecret {
    private String url;
    private String username;
    private String password;

}
