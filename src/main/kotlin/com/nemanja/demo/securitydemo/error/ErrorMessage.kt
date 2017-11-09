package com.nemanja.demo.securitydemo.error

/**
 * Created by neman on 09/11/2017.
 */
class ErrorMessage {

	var errorCode: ErrorCode = ErrorCode.GENERAL_ERROR
	var errorMessage: String = "Something went wrong"

	constructor() {}

	constructor(errorCode: ErrorCode, errorMessage: String) {
		this.errorCode = errorCode
		this.errorMessage = errorMessage
	}

}