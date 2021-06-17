package com.cajusoftware.apps.android.lottieapplication.commons.enums

enum class Errors(val message: String) {
    CONNECTION_ERROR("Ops! Parece que você está sem conexão com a internet."),
    SERVER_ERROR("Tivemos um problema de comunicação com o servidor. Por favor, tente novamente mais tarde."),
    BAD_REQUEST("Ops! Ocorreu uma falha ao tentar realizar comunicação."),
    NOT_FOUND("Ops! Não foi possível encontrar o registro."),
}