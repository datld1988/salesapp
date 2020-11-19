Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_TYPE
   (ID, CUSTOMER_TYPE, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('CUR.ACCT.INDIV', 'PER', 'CURRENT ACCT-INDIVIDUALS', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_TYPE
   (ID, CUSTOMER_TYPE, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('CUR.ACCT.COPR', 'ORG', 'CURRENT ACCT- CORPORATE', 2, 'A');
COMMIT;

Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_PRODUCT
   (PRODUCT_CODE, CATEGORY_CODE, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('1', '1001', 'CURRENT ACCT-INDIVIDUALS', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_PRODUCT
   (PRODUCT_CODE, CATEGORY_CODE, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('11', '1001', 'CURRENT ACCT- CORPORATE', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_PRODUCT
   (PRODUCT_CODE, CATEGORY_CODE, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('99', '4005', 'Other Account Products', 1, 'A');
COMMIT;


Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('AUD', 'Dola Uc', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('CAD', 'Dola Cannada', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('CHF', 'Frang Thuy Sy', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('CNY', 'Te Trung Quoc', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('CZK', 'Czech Koruna', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('EUR', 'Euro', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('GBP', 'Bang Anh', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('HKD', 'Dola Hong Kong', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('INR', 'Rupi An Do', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('JPY', 'Yen Nhat', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('KWD', 'Co oet', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('NOK', 'Curon Na Uy', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('NZD', 'New Zealand Dollars', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('SEK', 'Curon Thuy Dien', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('SGD', 'Dola Singapo', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('THB', 'Bat Thai', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('TWD', 'New Taiwan Dollar', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('USD', 'Dola My', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('VND', 'Dong Viet Nam', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('XAU', 'Chi Vang', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_CURRENCY
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('ZAR', 'Dong Nam Phi', 1, 'A');
COMMIT;


Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_OWN_TYPE
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('P', 'Tài khoản thanh toán cá nhân', 1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_OWN_TYPE
   (ID, NAME, DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('J', 'Tài khoản thanh toán chung', 1, 'A');
COMMIT;


Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('1', '1', ' Rút lãi', '1.1. Đối với STK/CCTG/KP/HĐTG ', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('2', '1', ' Rút một phần vốn', '1.1. Đối với STK/CCTG/KP/HĐTG ', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('3', '1', ' Tất toán', '1.1. Đối với STK/CCTG/KP/HĐTG ', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, PARENT_ID, GROUP_ID, NAME, NOTE, 
    DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('4', '1', '1', 'Theo định kỳ', '1.1. Đối với STK/CCTG/KP/HĐTG ', 
    1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, PARENT_ID, GROUP_ID, NAME, NOTE, 
    DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('5', '1', '1', 'Cuối kỳ', '1.1. Đối với STK/CCTG/KP/HĐTG ', 
    1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, PARENT_ID, GROUP_ID, NAME, NOTE, 
    DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('6', '2', '1', 'Trước hạn', '1.1. Đối với STK/CCTG/KP/HĐTG ', 
    1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, PARENT_ID, GROUP_ID, NAME, NOTE, 
    DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('7', '2', '1', 'Đúng hạn', '1.1. Đối với STK/CCTG/KP/HĐTG ', 
    1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, PARENT_ID, GROUP_ID, NAME, NOTE, 
    DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('8', '2', '1', 'Sau hạn', '1.1. Đối với STK/CCTG/KP/HĐTG ', 
    1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, PARENT_ID, GROUP_ID, NAME, NOTE, 
    DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('9', '3', '1', 'Trước hạn ', '1.1. Đối với STK/CCTG/KP/HĐTG ', 
    1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, PARENT_ID, GROUP_ID, NAME, NOTE, 
    DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('10', '3', '1', 'Đúng hạn', '1.1. Đối với STK/CCTG/KP/HĐTG ', 
    1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, PARENT_ID, GROUP_ID, NAME, NOTE, 
    DISPLAY_PRIORITY, STATUS_CODE)
 Values
   ('11', '3', '1', 'Sau hạn', '1.1. Đối với STK/CCTG/KP/HĐTG ', 
    1, 'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('12', '1', 'Theo hạn mức', '1.1. Đối với STK/CCTG/KP/HĐTG ', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('13', '1', 'Không giới hạn hạn mức', '1.1. Đối với STK/CCTG/KP/HĐTG ', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('14', '2', 'Rút theo hạn mức', '1.2.  Đối với tài khoản TGTT ', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('15', '2', ' Rút không giới hạn hạn mức', '1.2.  Đối với tài khoản TGTT ', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('16', '2', 'Được tất toán tài khoản TGTT', '1.2.  Đối với tài khoản TGTT ', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('17', '3', 'Ủy quyền một lần', '1.3 Các nội dung ủy quyền trên được phép thực hiện', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('18', '3', 'Ủy quyền nhiều lần', '1.3 Các nội dung ủy quyền trên được phép thực hiện', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('19', '4', ' Không được phép ', '1.4 Người được ủy quyền ', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('20', '5', 'Được phép', '1.5 Người được ủy quyền ', 1, 
    'A');
Insert into UNIFORM_ACCOUNT.CL_ACCOUNT_DELEGATE_TYPE
   (ID, GROUP_ID, NAME, NOTE, DISPLAY_PRIORITY, 
    STATUS_CODE)
 Values
   ('21', '5', ' Không được phép ', '1.5 Người được ủy quyền ', 1, 
    'A');
COMMIT;