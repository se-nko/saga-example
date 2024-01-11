package ru.senko.robotshop.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/products")
class ProductListController {

    @GetMapping
    @Operation(summary = "Получить список доступных товаров")
    fun findProductsList() : ArrayList<Any> {
        return ArrayList()
    }

}