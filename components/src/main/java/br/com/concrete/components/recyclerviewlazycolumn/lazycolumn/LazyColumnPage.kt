package br.com.concrete.components.recyclerviewlazycolumn

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.concrete.components.recyclerviewlazycolumn.lazycolumn.LazyCard
import br.com.concrete.components.recyclerviewlazycolumn.lazycolumn.ListLazy



@Preview
@Composable
fun SetLazyColumnList(){
    LazyColumn{
        items(ListLazy.getListLazy().size){
                index ->
            SetLazyView(datalist = ListLazy.getListLazy()[index])

        }
    }
}

@Composable
fun  SetLazyView(datalist: ListLazy){
    Card() {
        LazyCard(lazyCardList = datalist, onClick = { /*TODO*/ })
    }
}