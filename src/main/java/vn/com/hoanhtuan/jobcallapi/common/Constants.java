package vn.com.hoanhtuan.jobcallapi.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String ERROR_JSON_TO_STRING = "Error Json to String: ";
    public static final String ERROR_FROM_JSON_STRING = "Error Json to object:  ";
    public static final String OUTGOING_REQUEST = "Outgoing Request: {}";
    public static final String OUTGOING_RESPONSE = "Outgoing Response: {}";
    public static final String LOG_RESULT = "Result Code: {}, Result Message: {}";
    public static final String REQUEST = "Request: {}";
    public static final String RESPONSE = "Response: {}";
    public static final String REQUEST_ID = "requestId";
}
