package com.ericulicny.oakshire.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GateStatusAudit {
    private String uuid;
    private GateStatuses gatestatus;
    private Long eventTime;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public GateStatuses getGatestatus() {
        return gatestatus;
    }

    public void setGatestatus(GateStatuses gatestatus) {
        this.gatestatus = gatestatus;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }
}
