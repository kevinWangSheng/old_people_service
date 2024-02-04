package cn.kevinwang.old_people_service.common;

/**
 * @author wang
 * @create 2024-01-30-12:08
 */
public class Result<T> {
    private int code;

    private String message;

    private T data;

    public static<T> Result success(T data){
        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static Result fail(String message){
        Result result = new Result();
        result.setCode(400);
        result.setMessage(message);
        return result;
    }

    public static Result fail(int code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result fail(Exception e){
        Result result = new Result();
        result.setCode(500);
        result.setMessage(e.getMessage());
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
