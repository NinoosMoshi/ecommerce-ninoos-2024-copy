package com.ninos.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.model.entity.State;
import com.ninos.service.state.StateService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/states")
public class StateController {

    private final StateService stateService;


    // http://localhost:8080/api/v1/states/countryCode?code=<country code>
    @GetMapping("/countryCode")
    public List<State> getAllStatesByCountryCode(@RequestParam String code){
        return stateService.findStateByCountryCode(code);
    }


}
