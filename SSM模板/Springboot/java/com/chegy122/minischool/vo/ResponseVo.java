package com.chegy122.minischool.vo;

public class ResponseVo<T> {
	private Integer code;
	private String message;
	private T data;

	public static <T> ResponseVo<T> success(T data) {
		ResponseVo vo = new ResponseVo();
		vo.setCode(200);
		vo.setMessage("登录成功");
		vo.setData(data);

		return vo;
	}

	public static <T> ResponseVo<T> error(int code, String massage) {
		ResponseVo vo = new ResponseVo();
		vo.setCode(code);
		vo.setMessage(massage);

		return vo;
	}

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseVo [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

	
}
