package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

/**
 * unchecked 不用去处理，交给JVM去处理，继承 RuntimeException
 * checked，需要自己处理，继承 Exception
 */

public class MallException extends RuntimeException{

	public MallException(String error) {
		// TODO Auto-generated constructor stub
		super(error);
	}
	public MallException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }
}
