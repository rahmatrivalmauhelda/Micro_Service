package com.rahmat.order.vo;

import com.rahmat.order.model.Order;

import lombok.Data;

@Data
public class ResponseTemplate {
    Order order;
    Produk produk;
}
