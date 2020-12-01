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
    private String image;
    private String timeStart;
    private String timeEnd;

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
}
