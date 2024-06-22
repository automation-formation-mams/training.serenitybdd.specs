package FwkLibrary;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

public class DataLibrary {
    private static String dateCode = null;

    public static String getGlobalPropertieByKey(String propertyName) {
        String property = "";
        try {
            Configurations configurations = new Configurations();
            Configuration config = configurations.properties(new File("global.properties"));
            property = config.getString(propertyName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return property;
    }

    public static void generateCodeDate() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyHHmm");
        dateCode = time.format(formatter);
        System.out.println(dateCode);
    }

    public String getCodeDate() {
        if (dateCode == null) {
            generateCodeDate();
        }
        return dateCode;
    }

    public static void storeTempData(String key, String value) {
        try {
            Files.write(Paths.get("./TempData/" + key + ".txt"), value.getBytes());
            System.out.println("## DATA -- The Data is Set by Key : " + key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fetchTempData(String key) {
        try {
            String data = new String(Files.readAllBytes(Paths.get("./TempData/" + key + ".txt")));
            System.out.println("## DATA -- The Data is get from file [" + key + "] ====> " + data);
            return data;
        } catch (IOException e) {
            System.out.println("## DATA -- Fetch Error ===> File not found");
            return "";
        }
    }

    public static String getEnvironmentData(String data) {
        System.out.println("## DATA -- GET ENV DATA --> " + data);
        return System.getenv(data);
    }

    public static String getRunData(String data) {
        System.out.println("## DATA -- GET RUN DATA --> " + data);
        return fetchTempData(data);
    }

    public static List<String> getAllMatchesByPattern(String text, String pattern) {
        List<String> matches = new ArrayList<>();
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    public static String cleanVariable(String variable) {
        return variable.replaceAll("[\\$\\{\\}\\[\\]]", "");
    }

    public static String getDataPrepared(String textToPrepare) {
        String patternVariable = "\\$\\{[a-zA-Z0-9._-]+\\}";
        String patternSettings = "\\$\\[[a-zA-Z0-9._-]+\\]";

        for (String variable : getAllMatchesByPattern(textToPrepare, patternVariable)) {
            System.out.println("## DATA -- PREPARE DATA --> " + textToPrepare);
            String value = getRunData(cleanVariable(variable));
            textToPrepare = textToPrepare.replace(variable, value);
            System.out.println("## DATA -- DATA PREPARED --> " + textToPrepare);
        }

        for (String variable : getAllMatchesByPattern(textToPrepare, patternSettings)) {
            System.out.println("## DATA -- PREPARE DATA --> " + textToPrepare);
            String value = getEnvironmentData(cleanVariable(variable));
            textToPrepare = textToPrepare.replace(variable, value);
            System.out.println("## DATA -- DATA PREPARED --> " + textToPrepare);
        }

        return textToPrepare;
    }

//    public String getOtpCode(String otpKey) {
//        // Implementation depends on the TOTP library used. Example uses 'com.eatthepath:otp-java'
//        com.eatthepath.otp.TimeBasedOneTimePasswordGenerator totp = new com.eatthepath.otp.TimeBasedOneTimePasswordGenerator();
//        long time = System.currentTimeMillis() / 1000 / 30; // 30-second time steps
//        String code = totp.generateOneTimePasswordString(otpKey, time);
//        System.out.println("## DATA --  Code Authenticator: " + code);
//        return code;
//    }

    public static String generateRandom(String characters, int length) {
        Random random = new Random();
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    public static String generateLetters(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        return generateRandom(characters, length);
    }

    public static String generateNumbers(int length) {
        String characters = "0123456789";
        return generateRandom(characters, length);
    }

    public static String generateAlphanumeric(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        return generateRandom(characters, length);
    }

    public static String generateSpecialCharacters(int length) {
        String characters = "+.-_";
        return generateRandom(characters, length);
    }

    public static String generateStringSpecial(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz+.-_";
        return generateRandom(characters, length);
    }

    public static String generateSpecificDate(String datePattern, int daysToAdd) {
        LocalDateTime now = LocalDateTime.now().plusDays(daysToAdd);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        String formattedDate = now.format(formatter);
        System.out.println("DATA >> DATE GENERATED : " + formattedDate);
        return formattedDate;
    }

    public static String generateRandomValue(String valueType, int length, String pattern) {
        int valueLength = pattern.equals("NA") ? length : length - pattern.replace("$Random", "").length();
        String randomValue = "";

        switch (valueType) {
            case "Number":
                randomValue = generateNumbers(valueLength);
                break;
            case "string+":
                randomValue = generateStringSpecial(valueLength);
                break;
            case "string":
                randomValue = generateLetters(valueLength);
                break;
            case "AlphaNumeric":
                randomValue = generateAlphanumeric(valueLength);
                break;
        }

        return pattern.equals("NA") ? randomValue : pattern.replace("$Random", randomValue);
    }

}
