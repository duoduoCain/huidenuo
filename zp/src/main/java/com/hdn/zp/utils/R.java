package com.hdn.zp.utils;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author hdn
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class R<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	@Getter
	@Setter
	private String msg = "success";

	@Getter
	@Setter
	private int code=0;

    @Getter
	@Setter
	private T data;

	public R() {
		super();
	}

	public R(T data) {
		super();
		this.code = 200;
		this.data = data;
	}

	public R(T data, String msg) {
		super();
		this.code =200;
		this.data = data;
		this.msg = msg;
	}

	public R(Throwable e) {
		super();
		this.code = 500;
		this.msg = e.getMessage();
	}

    public static R ok() {
        return new R();
    }

    public static <T> R ok(T data) {
        return new R(data);
    }
	public static R error() {
		return error(500, "未知异常，请联系管理员",null);
	}

	public static <T> R error(String msg) {
		return error(500, msg,null);
	}
	public static <T> R error(String msg,T t) {
		return error(500, msg,null);
	}

	public static <T> R error(int code, String msg,T data) {
		R r = new R();
		r.msg = msg;
		r.code = code;
		r.data = data;
		return r;
	}

}
