package com.salesapp.saleskitservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewsDto {
    private Integer id;
    @NotNull(message = "Title {not.empty}")
    private String title;
    @NotNull(message = "Priority {not.empty}")
    private Integer priority;
    @NotNull(message = "PublishTime {not.empty}")
    private Date publishTime;
    @NotNull(message = "Content {not.empty}")
    private String content;
    @NotNull(message = "IDGroupProduct {not.empty}")
    private Integer idGroupProduct;
    @NotNull(message = "IDGroupCustomer {not.empty}")
    private Integer idGroupCustomer;
    private UserNewsViewDto userNewsViewDto;
    private String publisher;
    private Date createDate;
    private String createBy;
    private String modifyBy;
    private String image;
    private String filePath;
    private Date modifyDate;

    public NewsDto(Integer id, String title,  Date publishTime, String publisher,  String content,String image,
                   String filePath, Date createDate, String createBy, String modifyBy, Date modifyDate) {
        this.title = title;
        this.publishTime = publishTime;
        this.content = content;
        this.publisher = publisher;
        this.createDate = createDate;
        this.createBy = createBy;
        this.image = image;
        this.id = id;
        this.filePath= filePath;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }
}
