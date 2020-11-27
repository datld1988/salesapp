package com.salesapp.saleskitservice.dto;

import com.salesapp.saleskitservice.domain.Business;
import com.salesapp.saleskitservice.domain.Product;
import com.salesapp.saleskitservice.util.StringUtil;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BusinessDto {
    private Integer id;
    private String title;
    private String icon;
    private String image;
    private String timeStart;
    private String timeEnd;

    public static BusinessDto fromRoot(Business business) {
        BusinessDto businessDto = new BusinessDto();
        businessDto.setId(business.getId());
        businessDto.setIcon(business.getIcon());
        businessDto.setTitle(business.getName());
        businessDto.setImage(business.getImage1());
        businessDto.setTimeStart(StringUtil.convertDateToString(business.getTimeStart()));
        businessDto.setTimeEnd(StringUtil.convertDateToString(business.getTimeEnd()));
        return businessDto;
    }

    public BusinessDto(Integer id, String title, String icon, String image, Date timeStart, Date timeEnd) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.image = image;
        this.timeStart = StringUtil.convertDateToString(timeStart);
        this.timeEnd = StringUtil.convertDateToString(timeEnd);
    }
}
