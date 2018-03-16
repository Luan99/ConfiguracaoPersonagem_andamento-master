package com.confpers.luan78912.configuracaopersonagem

import android.content.ContentValues

enum class TipoPersonagem(val id: Int) {
    ANAO(0),
    BARDO(1),
    ARQUEIRO(2),
    ELFO(3),
    GUERREIRO(4),
    MAGO(5);


    companion object {

        fun from(findValue: Int): TipoPersonagem =
                TipoPersonagem.values().first { it.id == findValue }

    }
}