package com.salesapp.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable logins
    public static final String ADMIN_LOGIN_REGEX = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$";
    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";
    public static final String PHONE_REGEX = "(^$)|((09|0[3|5|7|8|9][0|1|2|3|4|5|6|7|8|9])+([0-9]{7}))";
    public static final String EMAIL_REGEX = "^$|^([\\w\\d\\-\\.]+)@{1}(([\\w\\d\\-]{1,67})|([\\w\\d\\-]+\\.[\\w\\d\\-]{1,67}))\\.(([a-zA-Z\\d]{2,4})(\\.[a-zA-Z\\d]{2})?)$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String ANONYMOUS_USER = "anonymoususer";
    public static final String DEFAULT_PASSWORD = "123456a@";

    public static final String LOGIN_SUCCESS = "login success";
    public static final String LOGOUT_SUCCESS = "logout success";
    public static final String INCORRECT_CURRENT_PASSWORD = "Mật khẩu hiện tại không đúng !";
    public static final String REGEX_PATTERN = "^[a-zA-Z0-9.]{5,20}$";
    public static final String ROLE_NAME_PATTERN = "^[ a-zA-Z0-9]{4,50}$";

    public static final String VIETNAMESE = "ếềểễệéèẻẽẹêữứừửựưúùủụũíìỉịĩớờởợỡơốồổộỗôóòỏõọắằẳặẵăấầẩẫâậáàảạãỷýỳỹỵđ";
    public static final String ENGLISH = "eeeeeeeeeeeuuuuuuuuuuuiiiiioooooooooooooooooaaaaaaaaaaaaaaaaayyyyyd";

    public static final Boolean FLAG_TRUE = Boolean.TRUE;
    public static final Boolean FLAG_FALSE = Boolean.FALSE;

    public static final String REQUEST_SERVICE = "00";

    public static final String REQUEST_TYPE_CREATE = "01";

    public static final String REQUEST_STATUS_WAITING = "01";

    public static final Integer MB_5 = 5 * 1024 * 1024;

    public static final class PrefixCode {
        private PrefixCode() {
        }

        public static final String CODE_TCD = "TCD";

        public static final String CODE_TRV = "TRV";

        public static final String CODE_TGX = "TGX";

        public static final String CODE_B = "B";

        public static final String CODE_ADMIN = "NV";
    }


    public static final class Status {
        private Status() {
        }

        // Chưa xử lý
        public static final String STATUS_00 = "00";
        // Đang xử lý
        public static final String STATUS_01 = "01";
        // Đã xử lý
        public static final String STATUS_02 = "02";
        // Từ chối
        public static final String STATUS_03 = "03";
        // Đã hủy
        public static final String STATUS_04 = "04";
    }

    public static final class ResidentCode {
        private ResidentCode() {
        }
        //không phải chủ hộ
        public static final String STATUS_00 = "00";
        // Chủ hộ
        public static final String STATUS_01 = "01";
        // Vợ/Chồng
        public static final String STATUS_02 = "02";
        // Con
        public static final String STATUS_03 = "03";
        // Ông/Bà
        public static final String STATUS_04 = "04";
        // Bố/Mẹ
        public static final String STATUS_05 = "05";
        // Anh/Chị
        public static final String STATUS_06 = "06";
        // Người thân khác
        public static final String STATUS_07 = "07";
        // Người thuê nhà
        public static final String STATUS_08 = "08";
    }

    public static final class BuildingCode {
        private BuildingCode() {
        }

        // Chưa sử dụng
        public static final String STATUS_00 = "00";
        // Đang sử dụng
        public static final String STATUS_01 = "01";
    }

    public static final class ResidentGroup {
        private ResidentGroup() {
        }

        // Người thuê nhà của chủ đầu tư
        public static final String STATUS_00 = "00";
        // Chủ hộ
        public static final String STATUS_01 = "01";
        // Người thân của chủ hộ
        public static final String STATUS_02 = "02";
        // Người thuê nhà của chủ hộ
        public static final String STATUS_03 = "03";
    }

    public static final class ResidentCardType {
        private ResidentCardType() {
        }

        // Thẻ cư dân
        public static final String STATUS_01 = "01";
        // Thẻ ra vào
        public static final String STATUS_02 = "02";
    }

    public static final class FlatStatus {
        private FlatStatus() {
        }

        // Chưa sử dụng
        public static final String STATUS_00 = "00";
        // Đã sử dụng
        public static final String STATUS_01 = "01";
    }

    public static final class FlatType {
        private FlatType() {
        }

        // Cho thuê
        public static final String TYPE_01 = "01";
        // Bán, để ở
        public static final String TYPE_02 = "02";
        //mặt bằng cho thuê
        public static final String TYPE_03 = "03";
    }

    public static final class RequestType {
        private RequestType() {
        }

        // Đăng ký
        public static final String STATUS_01 = "01";
        // Hủy
        public static final String STATUS_02 = "02";
        // Gia hạn
        public static final String STATUS_03 = "03";
        // Cấp lại
        public static final String STATUS_04 = "04";
    }

    public static final class MoveFurnitureType {
        private MoveFurnitureType() {
        }

        // chuyển vào
        public static final String STATUS_01 = "01";
        // chuyển ra
        public static final String STATUS_02 = "02";
    }

    public static final class ServiceCategory {
        private ServiceCategory() {
        }

        // Thẻ cư dân
        public static final String SERVICE_CATEGORY_01 = "01";
        // Thẻ ra vào
        public static final String SERVICE_CATEGORY_02 = "02";
        // Thẻ gửi xe ô tô
        public static final String SERVICE_CATEGORY_03 = "03";
        // Thẻ gửi xe máy
        public static final String SERVICE_CATEGORY_04 = "04";
        // Thẻ gửi xe máy điện
        public static final String SERVICE_CATEGORY_05 = "05";
        // Thẻ gửi xe đạp điện
        public static final String SERVICE_CATEGORY_06 = "06";
        // Thẻ gửi xe đạp
        public static final String SERVICE_CATEGORY_07 = "07";
        // Chuyển đồ ra
        public static final String SERVICE_CATEGORY_08 = "08";
        // Chuyển đồ vào
        public static final String SERVICE_CATEGORY_09 = "09";
        // Thẻ bơi
        public static final String SERVICE_CATEGORY_10 = "10";
        // Thẻ bơi (cao cấp)
        public static final String SERVICE_CATEGORY_11 = "11";
        // Thẻ chơi golf
        public static final String SERVICE_CATEGORY_12 = "12";
        // Thẻ chơi golf (cao cấp)
        public static final String SERVICE_CATEGORY_13 = "13";
        // Thẻ chơi tenis
        public static final String SERVICE_CATEGORY_14 = "14";
        // Thẻ chơi tenis (cao cấp)
        public static final String SERVICE_CATEGORY_15 = "15";
    }

    public static final class BillCategory {
        private BillCategory() {
        }

        // Thẻ cư dân
        public static final String BILL_CATEGORY_01 = "01";
        // Thẻ ra vào
        public static final String BILL_CATEGORY_02 = "02";
        // Thẻ gửi xe ô tô
        public static final String BILL_CATEGORY_03 = "03";
        // Thẻ gửi xe máy
        public static final String BILL_CATEGORY_04 = "04";
        // Thẻ gửi xe máy điện
        public static final String BILL_CATEGORY_05 = "05";
        // Thẻ gửi xe đạp điện
        public static final String BILL_CATEGORY_06 = "06";
        // Thẻ gửi xe đạp
        public static final String BILL_CATEGORY_07 = "07";
        // Chuyển đồ ra
        public static final String BILL_CATEGORY_08 = "08";
        // Chuyển đồ vào
        public static final String BILL_CATEGORY_09 = "09";
        // Thẻ bơi
        public static final String BILL_CATEGORY_10 = "10";
        // Thẻ bơi (cao cấp)
        public static final String BILL_CATEGORY_11 = "11";
        // Thẻ chơi golf
        public static final String BILL_CATEGORY_12 = "12";
        // Thẻ chơi golf (cao cấp)
        public static final String BILL_CATEGORY_13 = "13";
        // Thẻ chơi tenis
        public static final String BILL_CATEGORY_14 = "14";
        // Thẻ chơi tenis (cao cấp)
        public static final String BILL_CATEGORY_15 = "15";
        //Tiền điện
        public static final String BILL_CATEGORY_16 = "16";
        //Tiền nước
        public static final String BILL_CATEGORY_17 = "17";
        //Tiền Gas
        public static final String BILL_CATEGORY_18 = "18";
        //Phí quản lý
        public static final String BILL_CATEGORY_19 = "19";
        //Phí vệ sinh
        public static final String BILL_CATEGORY_20 = "20";
    }

    public static final class ServiceGroup {
        private ServiceGroup() {
        }

        // Thẻ cư dân
        public static final String SERVICE_CATEGORY_01 = "01";
        // Thẻ ra vào
        public static final String SERVICE_CATEGORY_02 = "02";
        // Thẻ gửi xe
        public static final String SERVICE_CATEGORY_03 = "03";
        // Chuyển đồ
        public static final String SERVICE_CATEGORY_08 = "04";
        // Thẻ bơi
        public static final String SERVICE_CATEGORY_11 = "05";
        // Thẻ chơi golf
        public static final String SERVICE_CATEGORY_12 = "06";
        // Thẻ chơi tenis
        public static final String SERVICE_CATEGORY_14 = "07";
    }

    public static final class CommunicationStatus {
        private CommunicationStatus() {
        }

        // chờ xử lý
        public static final String STATUS_WAITING = "01";
        // đang xử lý
        public static final String STATUS_PROCESSING = "02";
        // đã xử lý
        public static final String STATUS_HANDLED = "03";
        // Từ chối
        public static final String STATUS_REFUSE = "04";
        //đã hủy
        public static final String STATUS_CANCEL = "05";
    }

    public static final class CommunicationType {
        private CommunicationType() {
        }

        //thac mac
        public static final String TYPE_01 = "01";
        //gop y
        public static final String TYPE_02 = "02";
        //sua chua
        public static final String TYPE_03 = "03";
    }

    public static final class CommunicationAllocationStatus {
        private CommunicationAllocationStatus() {
        }

        // đang xử lý
        public static final String STATUS_PROCESSING = "01";
        // hoàn thành
        public static final String STATUS_FINISH = "02";
        // trả lại
        public static final String STATUS_RETURN = "03";
    }

    public static final class SortType {
        private SortType() {
        }

        public static final String DESC = "DESC";
        public static final String ASC = "ASC";
    }


    public static final class StatusProcessing {
        private StatusProcessing() {
        }

        //Thanh toán
        public static final String PAY = "01";
        //cấp thẻ
        public static final String PURVEY_CARD = "02";
        //trả thẻ
        public static final String PAY_CARD = "03";
    }

    public static final class FilterType {
        public enum BUILDING {
            ALL,
            BUILDING_FLOOR,
            BUILDING_NAME,
            BUILDING_STATUS
        }

        public enum FLAT {
            ALL,
            BUILDING_IDS,
            FLAT_NAME,
            FLAT_FLOOR,
            FLAT_ACREAGE_USE,
            FLAT_ACREAGE_SALE,
            SLEEP_ROOM,
            WC_ROOM,
            DIRECTION,
            FLAT_STATUS,
            FLAT_ID
        }

        public enum RESIDENT_CARD {
            RESIDENT_CARD_ID,
            RESIDENT_CARD_TYPE
        }

        public enum FLAT_RESIDENT {
            USER_TO_DATE
        }

        public enum SERVICE_RESIDENT {
            SERVICE_RESIDENT_ID,
            DESCRIPTION
        }
    }

    public static final class NewsType {
        private NewsType() {
        }

        // thông báo chung
        public static final String NEWS_TYPE_01 = "01";
        // thông báo phí
        public static final String NEWS_TYPE_02 = "02";
    }

    public static final class BillType {
        private BillType() {
        }

        //service do ban quản lý cung cấp
        public static final String BILL_TYPE_01 = "01";
        //phí phải đóng
        public static final String BILL_TYPE_02 = "02";
        //tiện ích
        public static final String BILL_TYPE_03 = "03";
    }


    public enum IdentityCardType {
        //cmnd
        CMND("01"),
        //căn cước công dân
        CCCD("02"),
        //hộ chiếu
        HC("03");

        String value;

        IdentityCardType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static final class Pagination {
        private Pagination() {
        }

        public static final int MAX_RESULT = 10;
        public static final int MAX_NAVIGATION_PAGE = 10;
    }

    public static void main(String[] args) {
        System.out.println(FiltersType.BUILDING.getValue("BUILDING_NAME"));
    }

    public enum FiltersType {
        BUILDING("ALL", "BUILDING_NAME", "BUILDING_STATUS"),
        FLAT("ALL", "FLAT_NAME", "FLAT_FLOOR", "FLAT_ACREAGE", "SLEEP_ROOM", "WC_ROOM", "DIRECTION", "FLAT_STATUS");

        private final List<String> args;

        public List<String> getValues() {
            return new ArrayList<>(args);
        }

        public String getValue(String value) {
            if (getValues().contains(value)) {
                return value;
            }

            return "";
        }

        FiltersType(String... args) {
            this.args = Arrays.asList(args);
        }
    }

    public static final class UtilityStatus {
        private UtilityStatus() {
        }

        //đang cung cấp dịch vụ
        public static final String STATUS_00 = "00";

        //đang không cung cấp dịch vụ
        public static final String STATUS_01 = "01";
    }

    public static final class FileCategory {
        private FileCategory() {
        }

        //file thông báo chung
        public static final String STATUS_01 = "01";
        //phan anh
        public static final String STATUS_02 = "02";
    }

    public static final class BillServiceName {
        private BillServiceName(){
        }
        public static final String TIEN_NUOC = "Tiền nước";
        public static final String TIEN_DIEN = "Tiền điện";
        public static final String TIEN_RAC = "Phí vận chuyển rác";
        public static final String TIEN_DICH_VU = "Phí dịch vụ";
        public static final String TIEN_O_TO_HAM = "Phí gửi xe ô tô hầm";
        public static final String TIEN_O_TO_SANH = "Phí gửi xe ô tô sảnh";
        public static final String TIEN_XE_MAY_HAM = "Phí gửi xe máy hầm";
        public static final String TIEN_XE_MAY_SANH = "Phí gửi xe máy sảnh";
        public static final String TIEN_XE_DAP = "Phí gửi xe đạp";
    }

    public static final class FileRole {
        public enum IdentityCardType {
            FLAT("01", "", ""),
            BUILDING("01", "", ""),
            RESIDENT("01", "", ""),
            VEHICLE("01", "", ""),
            ADMIN_ROLE("01", "", ""),
            ADMIN_PERMISSION("01", "", ""),
            ADMIN("01", "", ""),
            SERVICE("01", "", ""),
            UTILITY("01", "", ""),
            MOVE_FURNITURE("01", "", ""),
            COMMUNICATION("01", "", "");

            private String code;
            private String name;
            private String action;

            IdentityCardType(String value) {
                this.code = value;
            }

            IdentityCardType(String value, String name) {
                this.code = value;
                this.name = name;
            }

            IdentityCardType(String value, String name, String action) {
                this.code = value;
                this.name = name;
                this.action = action;
            }

            public String getValue() {
                return code;
            }
        }

        public enum ENTITY {
            FLAT,
            BUILDING,
            RESIDENT,
            VEHICLE,
            ADMIN_ROLE,
            ADMIN_PERMISSION,
            ADMIN,
            SERVICE,
            UTILITY,
            MOVE_FURNITURE,
            COMMUNICATION
        }

        public enum ACTION {
            CREATE,
            UPDATE,
            DELETE,
            VIEW,
            UPLOAD,
            DOWNLOAD,
            RECEIVED,
            PROCESSING,
            APPROVED
        }
    }

    private Constants() {
    }

}
