package com.uniform.common.utils;


import com.uniform.common.exception.SalesException;

import java.math.BigInteger;
import java.sql.Timestamp;

public class Converters {
    private Converters() {
    }

    public static Integer castToInterger(Object input) {
        try {
            if (input instanceof BigInteger) {
                return ((BigInteger) input).intValue();
            }
            if (input instanceof Long) {
                return ((Long) input).intValue();
            }
            if (input instanceof Integer) {
                return (Integer) input;
            }
            if (input instanceof String) {
                String in = (String) input;
                return Integer.valueOf(in);
            }

            return 0;
        } catch (SalesException e) {
            throw new SalesException(com.uniform.common.utils.ErrorCode.BAD_REQUEST, "Kiểu dữ liệu không thể cast sang Integer");
        }
    }

    public static Double castToDouble(Object input) {
        try {
            if (input instanceof Float) {
                return ((Float) input).doubleValue();
            }
            else if (input instanceof Double) {
                return (Double) input;
            }

            return 0D;
        } catch (SalesException e) {
            throw new SalesException(com.uniform.common.utils.ErrorCode.BAD_REQUEST, "Kiểu dữ liệu không thể cast sang Double");
        }
    }

    public static Float castToFloat(Object input) {
        try {
            if (input instanceof Float) {
                return (Float) input;
            }
            else if (input instanceof Double) {
                return ((Double) input).floatValue();
            }
            else if (input instanceof Integer) {
                Integer val = (Integer) input;
                return val.floatValue();
            }

            return 0F;
        } catch (SalesException e) {
            throw new SalesException(com.uniform.common.utils.ErrorCode.BAD_REQUEST, "Kiểu dữ liệu không thể cast sang Float");
        }
    }

    public static Boolean castToBoolean(Object input) {
        try {
            if (null == input) {
                return false;
            }
            return (Boolean) input;
        } catch (Exception e) {
            throw new SalesException(com.uniform.common.utils.ErrorCode.BAD_REQUEST, "Kiểu dữ liệu không phải là Boolean");
        }
    }

    public static String castToString(Object input) {
        if (null == input) {
            return null;
        }
        return input.toString().trim();
    }

    public static Timestamp castToTimestamp(Object input) {
        if (null == input) {
            return null;
        }

        try {
            if (input instanceof String) {
                if (((String) input).contains("Z")) {
                    return com.uniform.common.utils.Utils.DateTimeUtils.convertToTimestampWithTimeZone((String) input);
                } else {
                    return com.uniform.common.utils.Utils.DateTimeUtils.convertToTimestampWithLocalDate((String) input);
                }
            } else if (input instanceof Long) {
                return com.uniform.common.utils.Utils.DateTimeUtils.convertToTimestampWithTimeZone((Long) input);
            }
            return (Timestamp) input;
        } catch (SalesException e) {
            throw new SalesException(com.uniform.common.utils.ErrorCode.BAD_REQUEST, "Kiểu dữ liệu không phải là Timestamp");
        }
    }

}
