package com.ieseljust.pmdm.comptador


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ieseljust.pmdm.comptador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var comptador=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.textViewComptador.text=comptador.toString()

        //Botones para sumar, restar y devolver el contador a 0
        binding.btAdd.setOnClickListener {
            comptador=0
            binding.textViewComptador.text=comptador.toString()
        }
       binding.btResta.setOnClickListener {
            //Control para que al restar el contar no pase a negativo
            if (comptador==0){
                comptador=0
            }else{
                comptador--
            }
           binding.textViewComptador.text=comptador.toString()
        }
        binding.btSuma.setOnClickListener {
            comptador++
            binding.textViewComptador.text=comptador.toString()
        }

    }
    override fun onSaveInstanceState(estat: Bundle) {
        super.onSaveInstanceState(estat)
        // Codi per a guardar l'estat
        estat.putInt("Comptador", comptador)
        binding.textViewComptador.text=comptador.toString()
    }

    override fun onRestoreInstanceState(estat: Bundle) {
        super.onRestoreInstanceState(estat)
        // Codi per a guardar l'estat
        comptador=estat.getInt("Comptador")
        binding.textViewComptador.text=comptador.toString()

    }
}