package com.salesapp.saleskitservice.dto;

import com.salesapp.saleskitservice.domain.Product;
import com.salesapp.saleskitservice.util.StringUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductMenuDto {
    private Integer id;
    private String title;
    private String icon;
    private String image;
    private String timeStart;
    private String timeEnd;
    private Integer child;

    public static ProductMenuDto fromRoot(Product product) {
        ProductMenuDto menu = new ProductMenuDto();
        menu.setId(product.getId());
        menu.setIcon(product.getIcon());
        menu.setTitle(product.getTenSP());
        menu.setImage(product.getAnh_1());
        menu.setTimeStart(StringUtil.convertDateToString(product.getTgBatDau()));
        menu.setTimeEnd(StringUtil.convertDateToString(product.getTgKetThuc()));
        return menu;
    }

    public ProductMenuDto(Integer id, String title, String icon, String image, Date timeStart, Date timeEnd) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.image = image;
        this.timeStart = StringUtil.convertDateToString(timeStart);
        this.timeEnd = StringUtil.convertDateToString(timeEnd);
    }

    public ProductMenuDto(Integer id, String title, String icon, String image, Date timeStart, Date timeEnd, Long child) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.image = image;
        this.timeStart = StringUtil.convertDateToString(timeStart);
        this.timeEnd = StringUtil.convertDateToString(timeEnd);
        this.child = child.intValue();
    }

    public ProductMenuDto(Integer id, String title, String icon, String image, Date timeStart, Date timeEnd, Integer child) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.image = image;
        this.timeStart = StringUtil.convertDateToString(timeStart);
        this.timeEnd = StringUtil.convertDateToString(timeEnd);
        this.child = child.intValue();
    }

    public ProductMenuDto(Integer id, String title){
        this.id = id;
        this.title = title;
    }
}
