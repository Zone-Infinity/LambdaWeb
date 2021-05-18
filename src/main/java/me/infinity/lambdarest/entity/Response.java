package me.infinity.lambdarest.entity;

public class Response {
    private final boolean success;
    private final int code;
    private final String message;

    public Response(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
