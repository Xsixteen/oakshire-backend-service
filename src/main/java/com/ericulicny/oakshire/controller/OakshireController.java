package com.ericulicny.oakshire.controller;

import com.ericulicny.oakshire.domain.GateStatusAudit;
import com.ericulicny.oakshire.domain.GateStatuses;
import com.ericulicny.oakshire.repo.GateStatusRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(path="/api/v1")
public class OakshireController {

    @Autowired
    private GateStatusRepository gateStatusRepo;

    @PostMapping(path="/gatestatus")
    public @ResponseBody String addGateStatusAudit(@RequestBody String gatestatus) {
        GateStatuses gateStatuses;
        if(gatestatus.equalsIgnoreCase("OPEN")) {
            gateStatuses = GateStatuses.OPEN;
        } else {
            gateStatuses = GateStatuses.CLOSE;
        }

        GateStatusAudit gateStatusAudit = new GateStatusAudit();
        gateStatusAudit.setGatestatus(gateStatuses);
        gateStatusAudit.setEventTime(System.currentTimeMillis());
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

    @GetMapping(path="/gatestatus/latest")
    public @ResponseBody String getLatestGateStatusAudit() {
        GateStatusAudit latestEvent = new GateStatusAudit();
        latestEvent.setEventTime(0L);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Iterable<GateStatusAudit> gateStatusAuditArrayList = gateStatusRepo.findAll();
            for(GateStatusAudit gateStatusAudit : gateStatusAuditArrayList) {
                if(gateStatusAudit.getEventTime() != null ) {
                    if (gateStatusAudit.getEventTime() > latestEvent.getEventTime()) {
                        latestEvent = gateStatusAudit;
                    }
                }
            }
            String result = objectMapper.writeValueAsString(latestEvent);
            return result;
        } catch (Exception e) {
            return "failure reason = " + e.getMessage();
        }
    }
}
