package com.syntxr.anohikari.presentation.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.syntxr.anohikari.R
import com.syntxr.anohikari.di.AppModule
import com.syntxr.anohikari.domain.utils.SortType
import com.syntxr.anohikari.presentation.home.jozz.JozzPage
import com.syntxr.anohikari.presentation.home.sora.SoraPage
import com.syntxr.anohikari.ui.theme.AnoHikariTheme
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

@RootNavGraph(start = true)
@Destination
@OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class,
)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel(),
) {

//    val state = viewModel.state
    val tester = viewModel._test
    val context = LocalContext.current

    val soras = viewModel.soras.toList()
    val jozzes = viewModel.jozzes.toList()
    val sorasJozz = viewModel.sorasJozz.toList()

    Log.d("QURAN1", soras.toString())

    var sortByDefault by remember {
        mutableStateOf(true)
    }

    var jozzNo by remember {
        mutableIntStateOf(1)
    }

    val tabItems = listOf(
        TabItem(
            title = "Surah",
            content = {
//                Text(text = "OMAAAAGEEEEEEAAAAA")
                SoraPage(soras = soras)
            }
        ),
        TabItem(
            title = "Juz",
            content = {
//                Text(text = "SPIDERMAN 2099")
                JozzPage(
                    jozzes = jozzes,
                    soraJozz = sorasJozz,
                    jozzNumber = { number ->
                        jozzNo = number
                    }
                )
            }
        )
    )

    val pagerState = rememberPagerState {
        tabItems.size
    }

    val selectedTab = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        val test = AppModule.provideDatabase(context).qoranDao.getSora()
        Log.d("QURAN2", test.toString())
        viewModel.onEvent(HomeEvent.GetJozz)
        viewModel.onEvent(HomeEvent.GetSora)
        viewModel.onEvent(HomeEvent.GetSoraJozz(jozzNo))
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Quran",
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                actions = {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "btn settings"
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "btn search"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxSize(),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(216.dp)
                    .paint(
                        painterResource(id = R.drawable.day_sky),
                        contentScale = ContentScale.FillWidth
                    )
                    .background(Color(0x33121212)),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Image(
                    painter = painterResource(
                        id = R.drawable.icon_quran_compose
                    ),
                    contentDescription = "App Image",
                    modifier = Modifier
                        .size(86.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Column(
                    Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Recently Read",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        letterSpacing = 2.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        content = {
                            items(8) {
                                ItemRecent()
                            }
                        }
                    )
                }
            }

            Card(
                modifier = Modifier.fillMaxSize(),
                colors = CardDefaults
                    .cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            ) {
                TabRow(
                    selectedTabIndex = selectedTab,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier.tabIndicatorOffset(tabPositions[selectedTab])
                        )
                    }
                ) {
                    tabItems.forEachIndexed { index, tabItem ->
                        Tab(
                            selected = index == selectedTab,
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            },
                            text = {
                                Text(
                                    text = tabItem.title,
                                )
                            }
                        )
                    }
                }

                Row(
                    Modifier
                        .align(alignment = Alignment.End)
                        .padding(vertical = 8.dp, horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Sort By: ",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    TextButton(
                        onClick = { sortByDefault = !sortByDefault }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            when (sortByDefault) {
                                true -> {
                                    Text(
                                        text = "Ascending",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.SemiBold,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        modifier = Modifier.padding(2.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Rounded.KeyboardArrowUp,
                                        contentDescription = "sort_arrow",
                                        tint = MaterialTheme.colorScheme.onSurface
                                    )
                                }

                                false -> {
                                    Text(
                                        text = "Descending",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.SemiBold,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        modifier = Modifier.padding(end = 2.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Rounded.KeyboardArrowDown,
                                        contentDescription = "sort_arrow",
                                        tint = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }
                }

                HorizontalPager(
                    state = pagerState
                ) {
                    tabItems[pagerState.currentPage].content()
                }

            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    AnoHikariTheme(
        darkTheme = true
    ) {
//        HomeScreen()
    }
}

data class TabItem(
    val title: String,
    val content: @Composable () -> Unit,
)