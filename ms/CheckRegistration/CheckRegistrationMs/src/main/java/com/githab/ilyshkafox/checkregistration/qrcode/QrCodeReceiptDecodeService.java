package com.githab.ilyshkafox.checkregistration.qrcode;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class QrCodeReceiptDecodeService {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd't'HHmmss");
    private static final String QR_TIME = "t";
    private static final String QR_SUM = "s";
    private static final String QR_FISCAL_NUMBER = "fn";
    private static final String QR_FISCAL_DOCUMENT = "i";
    private static final String QR_FISCAL_FEATURE = "fp";
    private static final String QR_TYPE = "n";

    public QrCodeReceipt decode(String qrString) {
        Map<String, String> params = parse(qrString);

        return new QrCodeReceipt(
                qrString,
                parseTime(params.get(QR_TIME)),
                new BigDecimal(params.get(QR_SUM)),
                Long.parseLong(params.get(QR_FISCAL_NUMBER)),
                Long.parseLong(params.get(QR_FISCAL_DOCUMENT)),
                Long.parseLong(params.get(QR_FISCAL_FEATURE)),
                Short.parseShort(params.get(QR_TYPE))
        );
    }

    private Map<String, String> parse(String qrString) {
        Map<String, String> values = new HashMap<>();

        Arrays.stream(qrString.split("&"))
                .map(s -> s.split("=", 2))
                .forEach(s -> values.put(s[0], s[1]));

        return values;
    }

    private LocalDateTime parseTime(String time) {
        StringBuilder timeBuilder = new StringBuilder(time.toLowerCase());
        while (timeBuilder.length() < 15) {
            timeBuilder.append("00");
        }
        timeBuilder.setLength(15);
        time = timeBuilder.toString();
        return LocalDateTime.parse(time, formatter);
    }

}
