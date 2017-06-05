package com.techm.ambika;


public interface StringTruncator {
    String TRUNCATE_STR_CONST = " ... (truncated) ... ";
    String truncate(String inputString, int totalNoOfCharacters);
}
