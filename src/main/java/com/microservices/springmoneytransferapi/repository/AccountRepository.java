package com.microservices.springmoneytransferapi.repository;

import com.safaricom.dxl.msmycountycounties.model.WhitelabelCounties;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<WhitelabelCounties, String> {
    Flux<WhitelabelCounties> findByActive(Boolean active);
}