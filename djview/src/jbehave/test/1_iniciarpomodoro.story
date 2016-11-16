Sample story

					 
Scenario:  dado el timer apagado, el usuario setea un valor en minutos y lo inicia desde el menu

Given GUI del PomodoroTimer
When el usuario ingresa un valor en minutos
When el usuario setea el valor pulsando el boton setTimer
When el usuario pulsa el boton iniciarTimer en el menu
Then PomodoroTimer corriendo con sonido

