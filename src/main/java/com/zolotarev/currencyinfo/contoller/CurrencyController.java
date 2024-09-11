package com.zolotarev.currencyinfo.contoller;

import com.zolotarev.currencyinfo.dto.CurrencyResponse;
import com.zolotarev.currencyinfo.mapper.CurrencyMapper;
import com.zolotarev.currencyinfo.model.Currency;
import com.zolotarev.currencyinfo.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.IIOException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/rate")
@Tag(name = "Контроллер валют", description = "Предназначен для получения данных ЦБ РФ по курсам валют на указанную дату")
public class CurrencyController {
    private final CurrencyService currencyService;
    private final CurrencyMapper currencyMapper;

    @Autowired
    public CurrencyController(CurrencyService currencyService, CurrencyMapper currencyMapper) {
        this.currencyService = currencyService;
        this.currencyMapper = currencyMapper;
    }

    @GetMapping("/{code}/{date}")
    @Operation(
            summary = "Получение курса валюты",
            description = "Позволяет получить курс конкретной валюты по буквенному коду в заданную дату"
    )
    ResponseEntity<?> getCurrencyRate(@PathVariable String code, @PathVariable LocalDate date) throws IOException {
        Currency response = currencyService.getCurrencyRate(code, date);
        return ResponseEntity.status(HttpStatus.OK).body(currencyMapper.toCurrencyResponse(response));
    }

    @GetMapping("/{code}")
    @Operation(
            summary = "Получение курса валюты",
            description = "Позволяет получить курс конкретной валюты по буквенному коду на текущую дату"
    )
    ResponseEntity<?> getCurrencyRate(@PathVariable String code) throws IOException {
        Currency response = currencyService.getCurrencyRate(code, LocalDate.now());
        return ResponseEntity.status(HttpStatus.OK).body(currencyMapper.toCurrencyResponse(response));
    }
}
