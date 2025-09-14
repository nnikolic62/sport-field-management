package com.springboot.sport_field_management.dto.user;

import com.springboot.sport_field_management.dto.reservation.ReservationBasicDTO;

import java.util.List;

public record UserReservationsDTO(
        String username,
        List<ReservationBasicDTO> reservations
) {
}
