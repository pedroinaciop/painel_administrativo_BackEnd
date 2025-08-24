package com.administrative.painel.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class MaterialInput {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long material_input_id;

    @Column(nullable = false)
    private String invoiceNumber;

    @Column(nullable = false)
    private String series;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "input_date", updatable = false)
    private LocalDate inputDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    private BigDecimal invoiceTotalValue;
    private String observation;

    @OneToMany(mappedBy = "MaterialInput", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InputItem> items;
}
