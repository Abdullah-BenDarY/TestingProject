package com.example.domain.handleState

class ServerError (
    serverMessage:String? = "Something went wrong") : Throwable(serverMessage)