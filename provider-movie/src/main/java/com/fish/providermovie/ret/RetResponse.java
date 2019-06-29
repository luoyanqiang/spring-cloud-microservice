package com.fish.providermovie.ret;

/**
 * @Description: 将结果转换为封装后的对象
 */
public class RetResponse {

    private final static String SUCCESS = "success";

    public static <T> RetResult<T> makeOKRsp() {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> RetResult<T> makeOKRsp(T data) {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> RetResult<T> makeErrRsp(String message) {
        return new RetResult<T>().setCode(RetCode.FAIL).setMsg(message);
    }

    public static <T> RetResult<T> makeErrRsp(RetCode retCode, String message) {
        return new RetResult<T>().setCode(retCode).setMsg(message);
    }

    public static <T> RetResult<T> makeRsp(int code, String msg) {
        return new RetResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> RetResult<T> makeRsp(int code, String msg, T data) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }

    public static <T> RetResult<T> makeRsp(boolean rs) {
        if(rs == true) {
            return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg("操作成功");
        } else {
            return new RetResult<T>().setCode(RetCode.FAIL).setMsg("操作失败");
        }
    }

    public static <T> RetResult<T> makeRsp(T data) {
        return new RetResult<T>().setCode(200).setMsg("success").setData(data);
    }
}