package com.example.nameservice;

import org.springframework.stereotype.Service;

import javax.naming.NameAlreadyBoundException;
import java.util.List;
import java.util.Optional;

@Service
public class NameService {
    private NameMapper nameMapper;

    public NameService(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    public List<Name> findNamesStringWith(String prefix) {
        return nameMapper.findByNameStartingWith(prefix);
    }

    public Name findName(int id) {
        Optional<Name> name = nameMapper.findByID(id);
        if (name.isPresent()) {
            return name.get();
        } else {
            throw new NameNotFoundException("name not found");
        }
    }
}
