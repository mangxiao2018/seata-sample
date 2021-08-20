package com.mangxiao.seata.purchase.sample.factory;

import java.io.Serializable;

/**
 * 异常信息包装
 */
public class ErrorEntry implements Serializable {
    /** 错误码 */
    private Integer code;
    /** 错误信息 */
    private String message;
    /** 发生错误时的时间 */
    private long timestamp = System.currentTimeMillis();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorEntry{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
