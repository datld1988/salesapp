package com.salesapp.adminservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_BRANCH_VW")
public class UserBranchVw implements Serializable {
    
    public static String MetaPropId = "id";
    public static String MetaPropBranchName = "branchName";
    public static String MetaPropStatusCode = "statusCode";
    public static String MetaPropUserId = "userId";

    @Id
    @Column(name = "ID")
    // Mã PK chi nhánh
    private String id;
    
    @Column(name = "BRANCH_NAME")
    // Tên chi nhánh
    private String branchName;
    
    @Column(name = "STATUS_CODE")
    // Trạng thái sử dụng A, I, L, D
    private String statusCode;
    
    @Column(name = "USER_ID")
    // Mã PK Người dùng
    private String userId;
    

}