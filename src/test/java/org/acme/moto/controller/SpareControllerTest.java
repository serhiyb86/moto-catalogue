package org.acme.moto.controller;

import org.acme.moto.data.Availability;
import org.acme.moto.data.SpareType;
import org.mockito.Mock;
import org.acme.moto.data.Spare;
import org.acme.moto.data.repository.SpareRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpareControllerTest {

    @Mock
    SpareRepository spareRepository;
    @InjectMocks
    SpareController spareController;

    @Test
    void list_emptyList_EmptyListReturns() {
        when(spareRepository.listAll()).thenReturn(Collections.emptyList());
        List<Spare> list = spareController.list();
        assertThat(list).isEqualTo(Collections.emptyList());
    }

    @Test
    void list_listOfSpares_listReturns() {
        Spare spare = new Spare(new SpareType("Motor"),
                "shaft",
                "desription of the spare",
                "tech desc",
                2,
                Availability.ABROAD
                );
        when(spareRepository.listAll()).thenReturn(Collections.singletonList(spare));
        List<Spare> list = spareController.list();
        assertThat(list).isEqualTo(Collections.singletonList(spare));
    }
}