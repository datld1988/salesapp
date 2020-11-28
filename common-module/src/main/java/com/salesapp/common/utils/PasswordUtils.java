//package com.salesapp.common.utils;
//
//import com.salesapp.common.exception.PasswordConstraintValidator;
//import org.passay.CharacterData;
//import org.passay.CharacterRule;
//import org.passay.EnglishCharacterData;
//import org.passay.PasswordGenerator;
//
//public class PasswordUtils {
//
//    public static String generateValidPassword() {
//        PasswordGenerator generator = new PasswordGenerator();
//        return generator.generatePassword(PasswordConstraintValidator.MIN_LENGTH,
//                new CharacterRule(EnglishCharacterData.LowerCase, PasswordConstraintValidator.NUM),
//                new CharacterRule(EnglishCharacterData.UpperCase, PasswordConstraintValidator.NUM),
//                new CharacterRule(EnglishCharacterData.Digit, PasswordConstraintValidator.NUM),
//                new CharacterRule(CustomCharacterData.Special, PasswordConstraintValidator.NUM));
//    }
//
//    /**
//     * Custom character data for Passay
//     */
//    public enum CustomCharacterData implements CharacterData {
//        /** Special characters. */
//        Special(
//                "INSUFFICIENT_SPECIAL",
//                // ASCII symbols
//                "!#$%&'()*+-./:;<=>?@[]^_`{|}~");
//
//
//        /** Error code. */
//        private final String errorCode;
//
//        /** Characters. */
//        private final String characters;
//
//
//        /**
//         * @param  code  Error code.
//         * @param  charString  Characters as string.
//         */
//        CustomCharacterData(final String code, final String charString)
//        {
//            errorCode = code;
//            characters = charString;
//        }
//
//        @Override
//        public String getErrorCode()
//        {
//            return errorCode;
//        }
//
//        @Override
//        public String getCharacters()
//        {
//            return characters;
//        }
//    }
//}
