package vn.com.hoanhtuan.jobcallapi.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumResultCode {
    SUCCESS("000", "Success"),
    API_ERROR("001", "Call API Error"),
    SYSTEM_ERROR("999", "System Error");
    private final String code;
    private final String message;
}
