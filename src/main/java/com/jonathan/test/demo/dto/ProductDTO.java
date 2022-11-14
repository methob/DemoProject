package com.jonathan.test.demo.dto;

import com.jonathan.test.demo.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
@ApiModel
public class ProductDTO {
    @ApiModelProperty
    private Long code;
    @ApiModelProperty
    private String description;
    @ApiModelProperty
    private Integer amount;
    @ApiModelProperty
    private BigDecimal priceCost;
    @ApiModelProperty
    private BigDecimal priceSale;
    @ApiModelProperty
    private String observation;
    @ApiModelProperty
    private Category category;

    public ProductDTO(Long code, String description, Integer amount, BigDecimal priceCost, BigDecimal priceSale, String observation, Category category) {
        this.code = code;
        this.description = description;
        this.amount = amount;
        this.priceCost = priceCost;
        this.priceSale = priceSale;
        this.observation = observation;
        this.category = category;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPriceCost() {
        return priceCost;
    }

    public void setPriceCost(BigDecimal priceCost) {
        this.priceCost = priceCost;
    }

    public BigDecimal getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(BigDecimal priceSale) {
        this.priceSale = priceSale;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
