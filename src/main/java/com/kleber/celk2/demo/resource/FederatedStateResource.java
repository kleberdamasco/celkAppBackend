package com.kleber.celk2.demo.resource;

import com.kleber.celk2.demo.model.FederatedState;
import com.kleber.celk2.demo.service.FederatedStateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FederatedStateResource {

    private final FederatedStateService federatedStateService;

    public FederatedStateResource(FederatedStateService federatedStateService) {
        this.federatedStateService = federatedStateService;
    }

    @PostMapping("/create")
    public ResponseEntity<FederatedState> create(@RequestBody FederatedState federatedState) {
        return ResponseEntity.created(URI.create("/fs/created")).body(federatedStateService.save(federatedState));
    }

    @GetMapping("/all")
    public ResponseEntity<List<FederatedState>> getAll(){
        return ResponseEntity.ok(federatedStateService.getAll());
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<FederatedState> deleteMovie(@PathVariable Long id) {
        federatedStateService.delete(id);
        return ResponseEntity.ok().build();
    }

}
