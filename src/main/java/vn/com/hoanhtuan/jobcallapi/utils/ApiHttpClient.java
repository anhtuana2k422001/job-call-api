package vn.com.hoanhtuan.jobcallapi.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import vn.com.hoanhtuan.jobcallapi.common.Constants;
import vn.com.hoanhtuan.jobcallapi.common.EnumResultCode;

import java.nio.charset.StandardCharsets;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiHttpClient {
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final EnumResultCode status = EnumResultCode.SYSTEM_ERROR;
    public static String executeGetRequest(String url) {

        try {
            HttpGet request = new HttpGet(url);
            /* To do log request */
            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity responseEntity = response.getEntity();
            if (responseEntity == null) {
                /* To do Log response */
                return StringUtils.EMPTY;
            }

            return EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);

        } catch (Exception ex) {
            LOGGER.info(Constants.LOG_RESULT, status.getCode(), status.getMessage());
            return StringUtils.EMPTY;
        }
    }
}
