package com.salesapp.common.utils;


//import com.salesapp.common.exception.SalesException;
import org.apache.commons.lang3.StringUtils;
//import org.hibernate.SQLQuery;
//import org.hibernate.transform.Transformers;
//import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {
    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    private static final String VIETNAMESE_D = "đ";
    private static final String ENGLISH_D = "d";

    public static boolean isNullOrEmpty(Object string) {
        return string != null && !"".equals(string);
    }

    public static boolean isNumberic(String number) {
        try {
            Integer isNumber = Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String number) {
        try {
            double isNumber = Double.parseDouble(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String genCodeTypeCard(String prefix, int val) {
        String formatNumber = String.format("%06d", val);
        return prefix.concat(formatNumber);
    }

//    public static String generateCode(String prefix, String maxCode) {
//        if (null == maxCode) {
//            return Utils.genCodeTypeCard(prefix, 1);
//        }
//
//        maxCode = maxCode.replace(prefix, "");
//        int val = Converters.castToInterger(maxCode) + 1;
//        return Utils.genCodeTypeCard(prefix, val);
//    }

    /**
     * date time utils class
     */
    public static final class DateTimeUtils {
        public static final String UTC_TIMEZONE_NAME = "Etc/UTC";
        public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
        public static final String ISO_DATE_FORMAT_ZERO_OFFSET = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

        public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

        private DateTimeUtils() {
        }

        /**
         * get current Timestamp by local date
         *
         * @return Timestamp
         */
        public static Timestamp getCurrentTimestamp() {
            return convertToTimestampWithTimeZone(new Date());
        }

        private static String convertDateToStringDate(Date date) {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            // get the String representation
            return new SimpleDateFormat(DateTimeUtils.DATE_FORMAT).format(cal.getTime());
        }

        private static String convertDateToStringDate(long miliseconDate) {
            final Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(miliseconDate);
            // get the String representation
            return new SimpleDateFormat(DateTimeUtils.DATE_FORMAT).format(cal.getTime());
        }

        /**
         * convert millisecond to timestamp without time zone
         *
         * @param millisecondDate millisecondDate
         * @return Timestamp
         */
        public static Timestamp convertToTimestampWithLocalDate(long millisecondDate) {
            Date date = new Date(millisecondDate);
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            String formatted = format.format(date);
            return Timestamp.valueOf(formatted);
        }

        /**
         * convert millisecond to timestamp with time zone
         *
         * @param millisecondDate millisecondDate
         * @return Timestamp
         */
        public static Timestamp convertToTimestampWithTimeZone(long millisecondDate) {
            String timeString = convertDateToStringDate(millisecondDate);

            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            format.setTimeZone(TimeZone.getTimeZone(UTC_TIMEZONE_NAME));

            Timestamp timestamp = null;
            try {
                timestamp = new Timestamp(format.parse(timeString).getTime());
            } catch (ParseException e) {
                e.getLocalizedMessage();
            }

            return timestamp;
        }

        /**
         * convert local date to timestamp with time zone
         *
         * @param date date
         * @return Timestamp
         */
        public static Timestamp convertToTimestampWithTimeZone(Date date) {
            String timeString = convertDateToStringDate(date);

            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            format.setTimeZone(TimeZone.getTimeZone(UTC_TIMEZONE_NAME));

            Timestamp timestamp = null;
            try {
                timestamp = new Timestamp(format.parse(timeString).getTime());
            } catch (ParseException e) {
                e.getLocalizedMessage();
            }

            return timestamp;
        }

//        /**
//         * convert to timestamp with UTC
//         *
//         * @param dateStrTimestamp dateStrTimestamp
//         * @return Timestamp
//         */
//        public static Timestamp convertToTimestampWithTimeZone(String dateStrTimestamp) {
//            Timestamp timestamp;
//            try {
//                DateFormat dateFormat = new SimpleDateFormat(ISO_DATE_FORMAT_ZERO_OFFSET);
//                dateFormat.setTimeZone(TimeZone.getTimeZone(UTC_TIMEZONE_NAME));
//                timestamp = new Timestamp(dateFormat.parse(dateStrTimestamp).getTime());
//            } catch (ParseException e) {
//                throw new SalesException(ErrorCode.SERVICE_ERROR, "Dữ liệu không đúng");
//            }
//
//            return timestamp;
//        }
//
//        /**
//         * convert to timstamp with local date
//         *
//         * @param dateStrTimestamp dateStrTimestamp
//         * @return Timestamp
//         */
//        public static Timestamp convertToTimestampWithLocalDate(String dateStrTimestamp) {
//            Timestamp timestamp;
//            try {
//                DateFormat simpleDateFormat = new SimpleDateFormat(ISO_DATE_FORMAT);
//                timestamp = new Timestamp(simpleDateFormat.parse(dateStrTimestamp).getTime());
//            } catch (ParseException e) {
//                throw new SalesException(ErrorCode.SERVICE_ERROR, "Dữ liệu không đúng");
//            }
//
//            return timestamp;
//        }
//    }
//
//    private static void addSclarIgnoreAnyField(SQLQuery sqlQuery, Field[] fields, List<String> fieldsInput) {
//        for (Field field : fields) {
//            if (!CollectionUtils.isEmpty(fieldsInput) && fieldsInput.contains(field.getName())) {
//                fieldsInput.remove(field.getName());
//                continue;
//            }
//
//            if (field.getType() == BigDecimal.class) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.BIG_DECIMAL);
//            } else if ((field.getType() == long.class) || (field.getType() == Long.class)) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.LONG);
//            } else if ((field.getType() == int.class) || (field.getType() == Integer.class)) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.INTEGER);
//            } else if ((field.getType() == char.class) || (field.getType() == Character.class)) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.CHARACTER);
//            } else if ((field.getType() == short.class) || (field.getType() == Short.class)) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.SHORT);
//            } else if ((field.getType() == double.class) || (field.getType() == Double.class)) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.DOUBLE);
//            } else if ((field.getType() == float.class) || (field.getType() == Float.class)) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.FLOAT);
//            } else if ((field.getType() == boolean.class) || (field.getType() == Boolean.class)) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.BOOLEAN);
//            } else if (field.getType() == String.class) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.STRING);
//            } else if (field.getType() == Date.class) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.TIMESTAMP);
//            } else if (field.getType() == Timestamp.class) {
//                sqlQuery.addScalar(field.getName(), StandardBasicTypes.TIMESTAMP);
//            }
//        }
//    }
//
//    private static void addSclarHasAnyField(SQLQuery sqlQuery, Field[] fields, List<String> fieldsInput) {
//        for (Field field : fields) {
//            if (fieldsInput.contains(field.getName())) {
//                if (field.getType() == BigDecimal.class) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.BIG_DECIMAL);
//                } else if ((field.getType() == long.class) || (field.getType() == Long.class)) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.LONG);
//                } else if ((field.getType() == int.class) || (field.getType() == Integer.class)) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.INTEGER);
//                } else if ((field.getType() == char.class) || (field.getType() == Character.class)) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.CHARACTER);
//                } else if ((field.getType() == short.class) || (field.getType() == Short.class)) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.SHORT);
//                } else if ((field.getType() == double.class) || (field.getType() == Double.class)) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.DOUBLE);
//                } else if ((field.getType() == float.class) || (field.getType() == Float.class)) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.FLOAT);
//                } else if ((field.getType() == boolean.class) || (field.getType() == Boolean.class)) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.BOOLEAN);
//                } else if (field.getType() == String.class) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.STRING);
//                } else if (field.getType() == Date.class) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.TIMESTAMP);
//                } else if (field.getType() == Timestamp.class) {
//                    sqlQuery.addScalar(field.getName(), StandardBasicTypes.TIMESTAMP);
//                }
//            }
//        }
//    }
//
//    /**
//     * addSclar
//     *
//     * @param sqlQuery    sqlQuery
//     * @param clazz       clazz
//     * @param fieldsInput fields
//     * @param ignoreFlag  ignore flag
//     * @param <T>         T
//     */
//    public static <T> void addSclar(SQLQuery sqlQuery, Class<T> clazz, List<String> fieldsInput, boolean ignoreFlag) {
//        if (clazz == null) {
//            throw new NullPointerException("[clazz] could not be null!");
//        }
//        if (null == fieldsInput) {
//            fieldsInput = new ArrayList<>();
//        }
//
//        Field[] fields = clazz.getDeclaredFields();
//
//        if (ignoreFlag) {
//            addSclarIgnoreAnyField(sqlQuery, fields, fieldsInput);
//        } else {
//            addSclarHasAnyField(sqlQuery, fields, fieldsInput);
//        }
//
//        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
//    }

    private static String removeSpecialCharacter(String name) {
        if (StringUtils.isEmpty(name))
            return name;

        StringBuilder sb = new StringBuilder();
        String[] array = name.split("");
        for (String s : array) {
            if (s.matches("^[a-z0-9]*$")) {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    /**
     * Utility interface that trims all String fields of the implementing class
     */
    public interface Trimmable {
        /**
         * Trim all Strings
         */
        default void trim() {
            for (Field field : this.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(this);
                    if (!(value instanceof String)) {
                        continue;
                    }
                    String trimmed = (String) value;
                    field.set(this, trimmed.trim());
                } catch (Exception e) {
                    log.error(e.getLocalizedMessage());
                }
            }
        }
    }


    /**
     * <p>format a text file</p>
     * <p>eg: content file is "message ${param1} is ${params2}";
     * <i>param1</i> and <i>param2</i> is the keys of the params</p>
     * <p>the result is a string has been replaced by the param value in the map</p>
     *
     * @param in     input stream
     * @param params Map<param, value>
     * @return the string after format
     */
//    public static String format(InputStream in, Map<String, Object> params) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//        StringBuilder content = new StringBuilder();
//        int characterInt;
//        char character;
//        boolean isEscape = false;
//        try {
//            while ((characterInt = reader.read()) != -1) {
//                character = (char) characterInt;
//
//                // when escape character, just append next character into the content
//                if (isEscape) {
//                    content.append(character);
//                    isEscape = false;
//                    continue;
//                }
//
//                // if escape character, set flag isEscape = tre
//                if (character == '\\') {
//                    isEscape = true;
//                    continue;
//                }
//
//                // check if has expression
//                if (character == '$') {
//                    char nextChar = (char) reader.read();
//                    if (nextChar == '{') {
//                        // when has expression
//                        String paramName = getParamName(reader);
//                        content.append(params.get(paramName));
//                    } else {
//                        //if has no expression, just continues append into the content
//                        content.append(character).append(nextChar);
//                    }
//                    continue;
//                }
//
//                // else
//                content.append(character);
//            }
//        } catch (IOException e) {
//            e.getLocalizedMessage();
//        }
//        return content.toString();
//    }

    /**
     * get param name if the string start with '${' and end with '}'
     * <p>eg: ${param1} will be return "param1" </p>
     *
     * @param reader reader
     * @return the param name
     * @throws IOException IOException
     */
//    private static String getParamName(BufferedReader reader) throws IOException {
//        StringBuilder paramName = new StringBuilder();
//
//        boolean endExpression = false;
//        int characterInt;
//        char character;
//        while ((characterInt = reader.read()) != -1) {
//            character = (char) characterInt;
//
//            if (character == '}') {
//                endExpression = true;
//                break;
//            }
//
//            paramName.append(character);
//        }
//
//        if (endExpression && paramName.length() != 0) {
//            return paramName.toString();
//        } else {
//            throw new SalesException(ErrorCode.SERVICE_ERROR, "wrong expression syntax");
//        }
//    }
    }
}
