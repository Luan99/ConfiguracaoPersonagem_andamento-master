package com.confpers.luan78912.configuracaopersonagem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.AdapterView
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_personagem.*

class PersonagemActivity : AppCompatActivity() {

    fun trocaImagem() {

        var idImagem: Int

        val tipoPersonagem = TipoPersonagem.from(spClasse.selectedItemPosition)

        if (rgSexo.checkedRadioButtonId == R.id.rbMasculino) {

            idImagem = when (tipoPersonagem) {
                TipoPersonagem.ANAO -> R.drawable.anao
                TipoPersonagem.BARDO -> R.drawable.bardo
                TipoPersonagem.ARQUEIRO -> R.drawable.arqueiro
                TipoPersonagem.ELFO -> R.drawable.elfo
                TipoPersonagem.GUERREIRO -> R.drawable.guerreiro
                TipoPersonagem.MAGO -> R.drawable.mago
            }
        } else {
            idImagem = when (tipoPersonagem) {
                TipoPersonagem.ANAO -> R.drawable.anaofem
                TipoPersonagem.BARDO -> R.drawable.barda
                TipoPersonagem.ARQUEIRO -> R.drawable.arqueira
                TipoPersonagem.ELFO -> R.drawable.elfaa
                TipoPersonagem.GUERREIRO -> R.drawable.guerreira
                TipoPersonagem.MAGO -> R.drawable.maga
            }
        }

        ivClasse.setImageDrawable(
                ContextCompat.getDrawable(this, idImagem))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personagem)

        rgSexo.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbMasculino -> trocaImagem()
                R.id.rbFeminino -> trocaImagem()

            }
        }

        sbForca.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvForca.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })



        spClasse.onItemSelectedListener =
                (object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {}

                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        trocaImagem()
                    }
                })

        btCriar.setOnClickListener {

            Toast.makeText(
                    this, "Usuário criado", Toast.LENGTH_SHORT)
                    .show()


        }


    }
}
