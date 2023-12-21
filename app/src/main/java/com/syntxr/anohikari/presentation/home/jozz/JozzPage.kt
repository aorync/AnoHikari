package com.syntxr.anohikari.presentation.home.jozz

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.syntxr.anohikari.domain.model.Jozz
import com.syntxr.anohikari.domain.model.Sora
import com.syntxr.anohikari.presentation.home.jozz.component.JozzItem
import com.syntxr.anohikari.ui.theme.AnoHikariTheme

@Composable
fun JozzPage(
    jozzes: List<Jozz>,
    soraJozz : List<Sora>,
    modifier: Modifier = Modifier,
    jozzNumber: (number : Int) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        content = {
            items(jozzes){ jozz ->
                jozzNumber(jozz.jozz)
                JozzItem(
                    jozz = jozz,
                    soras = soraJozz,
                )
            }
        }
    )
}

@Preview
@Composable
fun JozzPagePreview(){
    AnoHikariTheme {
//        JozzPage()
    }
}