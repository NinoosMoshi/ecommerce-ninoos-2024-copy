package com.ninos.service.state;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninos.model.entity.State;
import com.ninos.repository.StateRepository;

@RequiredArgsConstructor
@Service
public class StateServiceImpl implements StateService{

    private final StateRepository stateRepository;


    @Override
    public List<State> findStateByCountryCode(String code) {
        return stateRepository.findByCountryCode(code);
    }




}
