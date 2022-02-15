package com.githab.ilyshkafox.checkregistration.api.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
public class ReceiptNewMsq {
    private Integer id;
    private String qrString;
    private LocalDateTime time;
    private Integer sum;
    private Long fiscalNumber;
    private Long fiscalDocument;
    private Long fiscalFeature;
    private Short type;
    private OffsetDateTime createAt;
}
