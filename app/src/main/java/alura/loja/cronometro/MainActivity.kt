package alura.loja.cronometro

import alura.loja.cronometro.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    var running     = false
    var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        binding.iniciar.setOnClickListener{
            IniciarCronometro()
        }

        binding.pausar.setOnClickListener{
            PausarCronometro()
        }

        binding.zerar.setOnClickListener{
            ZerarCronometro()
        }

    }

    private fun IniciarCronometro(){
        if(!running){
            binding.cronometro.base = SystemClock.elapsedRealtime() - pause
            binding.cronometro.start()
            running = true
        }
    }

    private fun PausarCronometro(){
        if (running){

            binding.cronometro.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro.base
            running = false
        }
    }

    private fun ZerarCronometro(){
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pause = 0

    }
}