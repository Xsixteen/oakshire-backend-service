package com.ericulicny.oakshire.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GateStatusAudit {
    private long id;
    private GateStatuses gatestatus;
    private Long eventTime;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long uuid) {
        this.id = uuid;
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
