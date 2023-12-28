package com.example.demo.web.v1.controller.request;

import com.example.demo.enums.FlowEnum;
import lombok.Data;

@Data
public class TestRequest {

    private Boolean validUrl;

    private FlowEnum flowEnum;

}
