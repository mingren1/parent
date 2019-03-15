package com.rtmap.middle.framework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String Id;
    private String username;
    private String password;
    private String tream;
}