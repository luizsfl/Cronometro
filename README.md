# Cronometro
### O cronometro foi dividido entre iniciar, pausar e zerar.
![Cronometro](https://user-images.githubusercontent.com/70184804/151734041-a4cad241-80de-4337-846e-5946f1a3bcac.PNG)

### Função para iniciar o cronometro
```
    private fun IniciarCronometro(){
        if(!running){
            binding.cronometro.base = SystemClock.elapsedRealtime() - pause
            binding.cronometro.start()
            running = true
        }
    }
```

### Função para parar o cronometro
```
    private fun PausarCronometro(){
        if (running){

            binding.cronometro.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro.base
            running = false
        }
    }
```
### Função para zerar o cronometro
```
    private fun ZerarCronometro(){
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pause = 0
    }
```

