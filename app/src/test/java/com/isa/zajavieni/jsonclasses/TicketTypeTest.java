package com.isa.zajavieni.jsonclasses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class TicketTypeTest {

    @Test
    void deserialize_testIfReturnFreeType() {
        // given (zalozenia)
        String input = "free";

        // when (akcja)
        TicketType type = TicketType.deserialize(input);

        // then (asercje)
        assertThat(type).isEqualTo(TicketType.FREE);
    }

    @Test
    void deserialize_testIfReturnUnknownType(){
        String input = "unknown";

        TicketType type =TicketType.deserialize(input);

        assertThat(type).isEqualTo(TicketType.UNKNOWN);
    }

    @Test
    void deserialize_testIfTypeIsNotNull(){
        String free = "free";
        String unknown = "unknown";

        TicketType freeType = TicketType.deserialize(free);
        TicketType unknownType = TicketType.deserialize(unknown);

        assertNotNull(freeType);
        assertNotNull(unknownType);
    }
}