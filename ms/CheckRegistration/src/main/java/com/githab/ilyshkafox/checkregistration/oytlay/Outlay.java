package com.githab.ilyshkafox.checkregistration.oytlay;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public final class Outlay {
    private final Long id;
    private final Type type;
    private final String data;
    private final Long sum;
    private final LocalDateTime date;
    private final OffsetDateTime createAt;

    public enum Type {
        MANUAL, QRCODE
    }
}
