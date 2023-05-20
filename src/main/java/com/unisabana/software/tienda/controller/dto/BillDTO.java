package com.unisabana.software.tienda.controller.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class BillDTO {
    private List<String> names;

    private List<Integer> quantities;

    private int finalPrice;

    @NonNull
    private String message;
}
