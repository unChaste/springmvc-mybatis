package com.ay.param;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;

public class ProductForm {
    @NotBlank(message = "名称不能为空")
    private String name;

    private String description;

    @NotBlank(message = "价格不能为空")
    @DecimalMin(value = "0", message = "价格不能小于等于零")
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
