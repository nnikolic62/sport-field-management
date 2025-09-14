package com.springboot.sport_field_management.dto.reservation;

import java.util.Date;

public record ReservationBasicDTO(
        Long id,
        String name,
        String phoneNumber,
        String email,
        Date dateHour
) {
}
