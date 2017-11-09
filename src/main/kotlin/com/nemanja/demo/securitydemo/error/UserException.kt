package com.nemanja.demo.securitydemo.error


/**
 * Created by neman on 09/11/2017.
 */
data class UserException( val errorCode: ErrorCode, val errorMessage: String) : Exception(errorMessage)