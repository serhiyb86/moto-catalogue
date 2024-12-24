package org.acme.moto.controller;

import io.quarkus.test.Mock;
import org.acme.moto.data.repository.SpareRepository;
import org.junit.jupiter.api.Test;


class SpareControllerTest {

    @Mock
    SpareRepository spareRepository;
    @Test
    void list() {
        System.out.println("Hello world");
            }
}