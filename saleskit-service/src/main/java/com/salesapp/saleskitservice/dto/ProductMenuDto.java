package com.salesapp.saleskitservice.dto;

import com.salesapp.saleskitservice.domain.Product;
import lombok.Data;

@Data
public class ProductMenuDto {
    private Integer id;
    private String title;
    private String icon;

    public static ProductMenuDto fromRoot(Product product) {
        ProductMenuDto menu = new ProductMenuDto();
        menu.setId(product.getId());
        menu.setIcon(product.getIcon());
        menu.setTitle(product.getLoaiSP());
        return menu;
    }
}
