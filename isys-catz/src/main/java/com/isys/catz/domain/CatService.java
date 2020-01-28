package com.isys.catz.domain;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CatService {

    private static final Map<String, Cat> CATS = Map.of(
            "Snooze", new Cat().setColor(Color.REDHEAD).setName("Snooze"),
            "Swinger", new Cat().setColor(Color.BLACK_AND_WHITE).setName("Swinger"));
    
    public Collection<Cat> findAll() {
        return CATS.values();
    }

    public Optional<Cat> findByName(String name) {
        try {
            Thread.sleep(8_000);
        } 
        catch (InterruptedException e) {
            log.warn("Naptime interrupted!", e);
        }
        return Optional.ofNullable(CATS.get(name));
    }
}
