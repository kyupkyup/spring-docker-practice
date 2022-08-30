package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class GetController {

    @RequestMapping(value = "/hello/{variable}", method= RequestMethod.GET)
    public String getHello(@PathVariable String variable) {
        return "Hello real word" + variable;
    }

    @GetMapping("/request-by-param")
    public String getRequestByParam(
            @RequestParam Map<String, String> param,
            @RequestParam String email
    ) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + ": " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }
}
