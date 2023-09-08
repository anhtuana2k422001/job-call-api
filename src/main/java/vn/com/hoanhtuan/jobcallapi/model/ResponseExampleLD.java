package vn.com.hoanhtuan.jobcallapi.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseExampleLD {
    private String resultCode;
    private String resultMessage;
    private List<ExampleLD> data;
}
