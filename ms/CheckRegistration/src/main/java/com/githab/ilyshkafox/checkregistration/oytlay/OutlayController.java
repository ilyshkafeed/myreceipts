package com.githab.ilyshkafox.checkregistration.oytlay;

import com.githab.ilyshkafox.checkregistration.oytlay.dto.ManualRequest;
import com.githab.ilyshkafox.checkregistration.oytlay.dto.QrCodeRequest;
import com.githab.ilyshkafox.checkregistration.oytlay.dto.RegisterResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@Log4j2
@RequestMapping("/register")
public class OutlayController {

    private final OutlayService service;
    private final OutlayMapper mapper;


    @PostMapping(value = "/receipt", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RegisterResponse> receipt(@RequestBody QrCodeRequest qrcode) {
        log.info("Получен запрос на создание чека: " + qrcode);
        return service.createReceipt(qrcode.getData()).map(mapper::mapResponse);
    }

    @PostMapping(value = "/manual", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RegisterResponse> manual(@RequestBody ManualRequest request) {
//        return service.createManual(request.getSum(), request.getData(), request.getDate()).map(mapper::mapResponse);
        return Mono.empty();
    }
}
