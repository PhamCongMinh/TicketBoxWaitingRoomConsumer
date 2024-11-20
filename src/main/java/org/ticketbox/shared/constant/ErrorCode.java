package org.ticketbox.shared.constant;

public enum ErrorCode {
    USER_NOT_FOUND("102"),
    INVALID_USER("103");


    // Mapping Error String with ErrorCode
    private String code;
    ErrorCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
