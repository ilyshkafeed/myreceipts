package com.githab.ilyshkafox.checkregistration.oytlay.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public final class RegisterResponse {
    private final String id;
    private final Type type;
    private final String data;
    private final Long sum;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate date;

    public enum Type {
        MANUAL, QRCODE
    }
}
