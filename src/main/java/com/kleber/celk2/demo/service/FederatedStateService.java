package com.kleber.celk2.demo.service;

import com.kleber.celk2.demo.model.FederatedState;
import com.kleber.celk2.demo.repository.FederatedStateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FederatedStateService {

    private final FederatedStateRepository federatedStateRepository;

    public FederatedStateService(FederatedStateRepository federatedStateRepository) {
        this.federatedStateRepository = federatedStateRepository;
    }

    public FederatedState save(FederatedState federatedState) {
        return federatedStateRepository.save(federatedState);
    }

    public List<FederatedState> getAll(){
        return federatedStateRepository.findAll();
    }

    public void delete(Long id) {
        FederatedState federatedState = new FederatedState();
        federatedState.setId(id);
        federatedStateRepository.delete(federatedState);
    }

    public FederatedState getById(Long id) {
        return federatedStateRepository.findById(id).get();
    }

    public FederatedState update(FederatedState federatedState) {
        return federatedStateRepository.save(federatedState);
    }
}
