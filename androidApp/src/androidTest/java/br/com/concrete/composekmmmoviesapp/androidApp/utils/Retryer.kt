package br.com.concrete.composekmmmoviesapp.androidApp.utils

fun retryer(times: Int = 3,action: () -> Unit){
    //da delay de 3segundos, tenta 3 loopings, tenta chamar 1 vez ou no catch pega as excecoes,
    // da delay de mais 3 segundos, após 3 loopings se nao chamar irá quebrar
    Thread.sleep(300)
    for (i in 0 until times){
        try {
            action.invoke()
            return
        }catch (ex: Throwable){
            if(i == times -1){
                throw ex
            }
            Thread.sleep(300)
        }
    }
}