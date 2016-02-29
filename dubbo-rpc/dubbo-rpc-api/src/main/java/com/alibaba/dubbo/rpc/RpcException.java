package com.alibaba.dubbo.rpc;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle1@jd.com>连乐</a>
 * @date 2016/2/29 9:35
 */
public final class RpcException extends RuntimeException{

    private static final long serialVersionUID = 743243243243L;

    public static final int UNKNOWN_EXCEPTION = 0;

    public static final int NETWORK_EXCEPTION = 1;

    public static final int TIMEOUT_EXCEPTION = 2;

    public static final int BIZ_EXCEPTION = 3;

    public static final int FORBIDDEN_EXCEPTION = 4;

    public static final int SERIALZATION_EXCEPTION = 5;

    private int code;//RPCException不能有子类，异常类型用ErrorCode表示，以便保持兼容

    public RpcException() {
        super();
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcException(String message) {
        super(message);
    }

    public RpcException(Throwable cause) {
        super(cause);
    }

    public RpcException(int code) {
        super();
        this.code = code;
    }

    public RpcException(int code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
    }

    public RpcException(int code, String message) {
        super(message);
        this.code = code;
    }

    public RpcException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public boolean isBiz(){
        return code == BIZ_EXCEPTION;
    }

    public boolean isForbidden() {
        return code == FORBIDDEN_EXCEPTION;
    }

    public boolean isTimeout() {
        return code == TIMEOUT_EXCEPTION;
    }

    public boolean isNetwork(){
        return code == NETWORK_EXCEPTION;
    }

    public boolean isSerialization() {
        return code == SERIALZATION_EXCEPTION;
    }

}
