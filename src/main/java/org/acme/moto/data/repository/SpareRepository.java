package org.acme.moto.data.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.moto.data.Spare;


@ApplicationScoped
public interface SpareRepository extends PanacheRepository<Spare> {
}