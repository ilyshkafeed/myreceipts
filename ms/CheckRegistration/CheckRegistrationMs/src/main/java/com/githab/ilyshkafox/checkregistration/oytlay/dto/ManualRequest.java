package com.githab.ilyshkafox.checkregistration.oytlay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public final class ManualRequest {
    private final String data;
    private final Long sum;
    private final LocalDate date;
}
