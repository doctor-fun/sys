package com.cj.jtsys.sys.exception;

public class ServiceException extends RuntimeException {
//继承RuntimeException，编译阶段不处理这个异常

    private static final long serialVersionUID = 352155891698717066L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
