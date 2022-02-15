package com.githab.ilyshkafox.checkregistration.db.repo;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Records;
import org.jooq.generated.tables.Receipt;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ReceiptRepository {
    Receipt RECEIPT = Receipt.RECEIPT;
    private final DSLContext dsl;

    public Mono<ReceiptDao> save(ReceiptDao receipt) {
        return Mono.from(dsl.insertInto(RECEIPT)
                .set(RECEIPT.QR_STRING, receipt.getQrString())
                .set(RECEIPT.TIME, receipt.getTime())
                .set(RECEIPT.SUM, receipt.getSum())
                .set(RECEIPT.FISCAL_NUMBER, receipt.getFiscalNumber())
                .set(RECEIPT.FISCAL_DOCUMENT, receipt.getFiscalDocument())
                .set(RECEIPT.FISCAL_FEATURE, receipt.getFiscalFeature())
                .set(RECEIPT.TYPE, receipt.getType())
                .set(RECEIPT.CREATE_AT, OffsetDateTime.now())
                .returning()
        ).map(integer -> );
    }

    public Mono<Integer> getIdByQrString(String qrcode) {
        return Mono.from(dsl.select(RECEIPT.ID)
                .from(RECEIPT)
                .where(RECEIPT.QR_STRING.eq(qrcode))
        ).map(Record1::value1);
    }
}
