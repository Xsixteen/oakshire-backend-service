package com.ericulicny.oakshire.repo;

import com.ericulicny.oakshire.domain.GateStatusAudit;
import org.springframework.data.repository.CrudRepository;

public interface GateStatusRepository extends CrudRepository<GateStatusAudit, Integer> {

}

