package com.syntxr.anohikari.presentation.home.sora

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.syntxr.anohikari.domain.model.Sora
import com.syntxr.anohikari.presentation.home.sora.component.SoraItem
import com.syntxr.anohikari.ui.theme.AnoHikariTheme

@Composable
fun SoraPage(
    soras : List<Sora>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        content = {

            items(soras){ sora ->
                SoraItem( sora = sora)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SoraPagePreview() {
    AnoHikariTheme(
    ) {
//        SoraPage()
    }
}