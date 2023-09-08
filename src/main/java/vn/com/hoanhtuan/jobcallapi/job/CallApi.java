package vn.com.hoanhtuan.jobcallapi.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.MDC;
import vn.com.hoanhtuan.jobcallapi.common.ApiUrls;
import vn.com.hoanhtuan.jobcallapi.common.Constants;
import vn.com.hoanhtuan.jobcallapi.common.EnumResultCode;
import vn.com.hoanhtuan.jobcallapi.model.ResponseExampleLD;
import vn.com.hoanhtuan.jobcallapi.utils.ApiHttpClient;
import vn.com.hoanhtuan.jobcallapi.utils.JsonUtils;

import java.util.UUID;

@Slf4j
public class CallApi implements Job {
    private static final EnumResultCode status = EnumResultCode.SYSTEM_ERROR;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String requestId = UUID.randomUUID().toString();
        MDC.put(Constants.REQUEST_ID, requestId);

        LOGGER.info(Constants.REQUEST, "Begin call api: " + ApiUrls.URL_LIST_EXAMPLE_CSLD);
        String listLDResponse = ApiHttpClient.executeGetRequest(ApiUrls.URL_LIST_EXAMPLE_CSLD);

        if (StringUtils.isEmpty(listLDResponse)) {
            LOGGER.info(Constants.LOG_RESULT, status.getCode(), status.getMessage());
        } else {
            ResponseExampleLD responseExampleLD = JsonUtils.fromJsonString(listLDResponse, ResponseExampleLD.class);
            if (responseExampleLD == null) {
                LOGGER.info("End call api error");
            } else {
                LOGGER.info(Constants.LOG_RESULT, responseExampleLD.getResultCode(), responseExampleLD.getResultMessage());
                LOGGER.info("End call api " + Constants.RESPONSE, responseExampleLD.getResultMessage());
            }
        }

    }
}
