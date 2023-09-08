package vn.com.hoanhtuan.jobcallapi.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import vn.com.hoanhtuan.jobcallapi.common.Constants;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static String toJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e){
            LOGGER.info(Constants.ERROR_JSON_TO_STRING, e);
            return StringUtils.EMPTY;
        }
    }

    public static <T> T fromJsonString(String jsonString, Class<T> valueType) {
        try {
            return objectMapper.readValue(jsonString, valueType);
        } catch (Exception e){
            LOGGER.info(Constants.ERROR_FROM_JSON_STRING, e);
            return null;
        }
    }
}
