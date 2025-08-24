package com.administrative.painel.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "input_items")
public class InputItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long input_item_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_input_id", nullable = false)
    private MaterialInput MaterialInput;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal unityValue;

    @Column(nullable = false)
    private BigDecimal totalValue;

    @Column(nullable = false)
    private String batch;

    @Column(nullable = false)
    private String validity;
}
