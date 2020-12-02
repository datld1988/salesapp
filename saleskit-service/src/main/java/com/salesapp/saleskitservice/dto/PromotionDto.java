package com.salesapp.saleskitservice.dto;

import com.salesapp.saleskitservice.domain.Promotion;
import com.salesapp.saleskitservice.util.StringUtil;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PromotionDto {
    private Integer id;
    private String title;
    private String shortContent;
    private String detailContent;
    private String image;
    private String image2;

    private String timeStart;
    private String timeEnd;
    private String createdDate;

    public static PromotionDto fromRoot(Promotion promotion) {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setId(promotion.getId());
        promotionDto.setTitle(promotion.getName());
        promotionDto.setImage(promotion.getImage1());
        promotionDto.setTimeStart(StringUtil.convertDateToString(promotion.getTimeStart()));
        promotionDto.setTimeEnd(StringUtil.convertDateToString(promotion.getTimeEnd()));
        return promotionDto;
    }

    public PromotionDto(Integer id, String title, String image, Date timeStart, Date timeEnd) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.timeStart = StringUtil.convertDateToString(timeStart);
        this.timeEnd = StringUtil.convertDateToString(timeEnd);
    }
    public PromotionDto(Integer id, String title, String shortContent, String image1, String image2, Date timeStart, Date timeEnd) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.image = image1;
        this.image2 = image2;
        this.timeStart = StringUtil.convertDateToString(timeStart);
        this.timeEnd = StringUtil.convertDateToString(timeEnd);
    }
    public PromotionDto(Integer id, String title, String content, String image1, String image2, Date timeStart, Date timeEnd, Date createdDate) {
        this.id = id;
        this.title = title;
        this.detailContent = content;
        this.image = image1;
        this.image2 = image2;
        this.timeStart = StringUtil.convertDateToString(timeStart);
        this.timeEnd = StringUtil.convertDateToString(timeEnd);
        this.createdDate = StringUtil.convertDateToString(createdDate);
    }

}
