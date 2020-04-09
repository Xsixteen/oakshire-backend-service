package com.ericulicny.oakshire.controller;

import com.ericulicny.oakshire.domain.GateStatusAudit;
import com.ericulicny.oakshire.domain.GateStatuses;
import com.ericulicny.oakshire.repo.GateStatusRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/v1")
public class OakshireController {

    @Autowired
    private GateStatusRepository gateStatusRepo;

    @PostMapping(path="/gatestatus")
    public @ResponseBody String addGateStatusAudit(@RequestParam String gatestatus) {
        GateStatuses gateStatuses;
        if(gatestatus.equalsIgnoreCase("OPEN")) {
            gateStatuses = GateStatuses.OPEN;
        } else {
            gateStatuses = GateStatuses.CLOSE;
        }

        GateStatusAudit gateStatusAudit = new GateStatusAudit();
        gateStatusAudit.setGatestatus(gateStatuses);
        gateStatusRepo.save(gateStatusAudit);
        return "OK";
    }

    @GetMapping(path="/gatestatus")
    public @ResponseBody String getGateStatusAudit() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String result = objectMapper.writeValueAsString(gateStatusRepo.findAll());
            return result;
        } catch (Exception e) {
            return "failure reason = " + e.getMessage();
        }
    }
}
