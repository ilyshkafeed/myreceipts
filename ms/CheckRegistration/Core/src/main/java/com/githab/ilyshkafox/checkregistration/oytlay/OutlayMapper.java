package com.githab.ilyshkafox.checkregistration.oytlay;

import com.githab.ilyshkafox.checkregistration.oytlay.dto.RegisterResponse;
import com.githab.ilyshkafox.checkregistration.repo.ReceiptDao;
import com.githab.ilyshkafox.checkregistration.qrcode.QrCodeReceipt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface OutlayMapper {
    String CAST_SUM = "castSum";

    @Mapping(target = "id", expression = "java(\"R\"+registerEntity.getId())")
    @Mapping(target = "type", expression = "java(Type.QRCODE)")
    @Mapping(target = "date", source = "time")
    @Mapping(target = "data", source = "qrString")
    RegisterResponse mapResponse(ReceiptDao registerEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sum", qualifiedByName = CAST_SUM)
    ReceiptDao mapResponse(QrCodeReceipt registerEntity);


    @Named(CAST_SUM)
    default Integer castSum(BigDecimal sum) {
        return sum.multiply(java.math.BigDecimal.valueOf(100L)).intValue();
    }

}
