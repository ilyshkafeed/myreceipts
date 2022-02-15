package com.githab.ilyshkafox.checkregistration.db.repo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@RequiredArgsConstructor
public final class ReceiptDao {
    private final Integer id;
    private final String qrString;
    private final LocalDateTime time;
    private final Integer sum;
    private final Long fiscalNumber;
    private final Long fiscalDocument;
    private final Long fiscalFeature;
    private final Short type;
    private final OffsetDateTime createAt;
}
