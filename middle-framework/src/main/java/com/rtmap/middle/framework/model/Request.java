package com.rtmap.middle.framework.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Request<T> {

    private String tenantId;
    private String message;
    private T data;

}
