package br.com.concrete.components.recyclerviewlazycolumn.recycleview


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.concrete.components.R


class RecycleViewPage () : AppCompatActivity()/*, Adapter.ItemClickListener*/{

    private val  pegaLista = geraLista(500)
    private val adapter = Adapter(pegaLista/*, this*/)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_scroll)

        val idDoMeuRecycleView = findViewById<RecyclerView>(R.id.recyclerview_id)

        idDoMeuRecycleView.adapter = adapter
        idDoMeuRecycleView.layoutManager = LinearLayoutManager(this)
        idDoMeuRecycleView.setHasFixedSize(true)
    }


    private fun geraLista(size:Int): List<ListaRecycleView>{
        val lista = ArrayList<ListaRecycleView>()

        for(i in 0 until size) {
            val drawable1 = when(i % 3){
                0 -> R.drawable.birds_of_prey
                else -> R.drawable.deadpool
            }
            val item = ListaRecycleView(
                drawable1,
                "Thor",
                "2020 ",
                "Como filho de Odin, rei dos deuses nórdicos, Thor logo herdará o trono de Asgard de seu idoso pai. Porém, no dia de sua coroação, Thor reage com brutalidade quando os inimigos dos deuses entram no palácio violando o tratado. Como punição, Odin manda Thor para a Terra. Enquanto seu irmão Loki conspira em Asgard, Thor, agora sem seus poderes, enfrenta sua maior ameaça." )
            lista += item
        }
        return lista
    }

   /* override fun ItemClick(position: Int) {
        TODO("Not yet implemented")
    }*/

}