package com.ninos.service.state;

import java.util.List;

import com.ninos.model.entity.State;

public interface StateService {

    List<State> findStateByCountryCode(String code);

}
