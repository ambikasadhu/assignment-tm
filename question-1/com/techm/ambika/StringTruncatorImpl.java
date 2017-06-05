package com.techm.ambika;


public class StringTruncatorImpl implements StringTruncator{

    @Override
    public String truncate(String inputString, int totalNoOfCharacters) {

        if(totalNoOfCharacters < TRUNCATE_STR_CONST.length()){
            return inputString;
        }

        if(totalNoOfCharacters > inputString.length()){
            return inputString;
        }

        StringBuilder builder = new StringBuilder();
        int noOfCharsToBeIncluded = totalNoOfCharacters - TRUNCATE_STR_CONST.length();

        for(int i=0;i<noOfCharsToBeIncluded/2;i++){
            builder.append(inputString.charAt(i));
        }

        builder.append(TRUNCATE_STR_CONST);

        for(int i=inputString.length()-(noOfCharsToBeIncluded/2);i<inputString.length();i++){
            builder.append(inputString.charAt(i));
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        StringTruncator truncator = new StringTruncatorImpl();

        System.out.println(truncator.truncate("123456789012345678901234567890", 25));
        System.out.println(truncator.truncate("1234567890", 5));
        System.out.println(truncator.truncate("123456789012345678901234567890", 31));
        System.out.println(truncator.truncate("123456789012345678901234567890", 26));
        System.out.println(truncator.truncate("987636", 0));
    }
}
