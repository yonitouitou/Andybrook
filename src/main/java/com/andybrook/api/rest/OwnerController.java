package com.andybrook.api.rest;

import com.andybrook.manager.owner.IOwnerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/owner")
public class OwnerController {

    private static System.Logger LOGGER = System.getLogger(OwnerController.class.getSimpleName());

    @Autowired
    private IOwnerManager ownerManager;

    @GetMapping(path = "/allOwnerIdsAndNames")
    public List<Pair<Long, String>> getAllOwnerIdsAndNames() {
        LOGGER.log(System.Logger.Level.INFO, "Get all owners ids and names request");
        return ownerManager.getAll()
                .values()
                .stream()
                .map(owner -> Pair.of(owner.getId(), owner.getCompagnyName()))
                .collect(Collectors.toList());
    }
}
