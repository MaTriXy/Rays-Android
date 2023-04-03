package com.skyd.rays.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.skyd.rays.R
import com.skyd.rays.ext.plus
import com.skyd.rays.ext.screenIsLand
import com.skyd.rays.ui.component.RaysTopBar
import com.skyd.rays.ui.component.RaysTopBarStyle
import com.skyd.rays.ui.local.LocalNavController
import com.skyd.rays.ui.screen.about.license.LICENSE_SCREEN_ROUTE
import com.skyd.rays.util.CommonUtil
import com.skyd.rays.util.CommonUtil.openBrowser

const val ABOUT_SCREEN_ROUTE = "aboutScreen"

@Composable
fun AboutScreen() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val context = LocalContext.current
    Scaffold(
        topBar = {
            RaysTopBar(
                style = RaysTopBarStyle.Large,
                scrollBehavior = scrollBehavior,
                title = { Text(text = stringResource(R.string.about)) },
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            contentPadding = paddingValues + PaddingValues(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (context.screenIsLand) {
                item {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconArea()
                            ButtonArea()
                        }
                        TextArea(modifier = Modifier.weight(1f))
                    }
                }
            } else {
                item {
                    IconArea()
                }
                item {
                    TextArea()
                }
                item {
                    ButtonArea()
                }
            }
        }
    }
}

@Composable
private fun IconArea() {
    Image(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(0.4f)
            .aspectRatio(1f),
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        painter = painterResource(id = R.drawable.ic_rays),
        contentDescription = null
    )
}

@Composable
private fun TextArea(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BadgedBox(
            badge = {
                Badge {
                    val badgeNumber = remember { CommonUtil.getAppVersionName() }
                    Text(
                        badgeNumber,
                        modifier = Modifier.semantics {
                            contentDescription = "$badgeNumber new notifications"
                        }
                    )
                }
            }
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
        }
        Text(
            text = stringResource(id = R.string.about_screen_app_full_name),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
        Card(
            modifier = Modifier.padding(top = 20.dp),
            shape = RoundedCornerShape(10)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.about_screen_description_1),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = stringResource(id = R.string.about_screen_description_2),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = stringResource(id = R.string.about_screen_description_3),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun ButtonArea() {
    val navController = LocalNavController.current

    Row(
        modifier = Modifier.fillMaxWidth(0.8f),
        horizontalArrangement = Arrangement.Center
    ) {
        val boxModifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp)
        Box(
            modifier = boxModifier.background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(30)
            ),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = { navController.navigate(LICENSE_SCREEN_ROUTE) }) {
                Icon(
                    imageVector = Icons.Default.Balance,
                    contentDescription = stringResource(id = R.string.license_screen_name)
                )
            }
        }
        Box(
            modifier = boxModifier.background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(30)
            ),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = { openBrowser("https://github.com/SkyD666/Rays-Android") }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_github_24),
                    contentDescription = stringResource(id = R.string.github)
                )
            }
        }
        Box(
            modifier = boxModifier.background(
                color = MaterialTheme.colorScheme.tertiaryContainer,
                shape = RoundedCornerShape(30)
            ),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = { openBrowser("https://discord.gg/pEWEjeJTa3") }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_discord_24),
                    contentDescription = stringResource(id = R.string.github)
                )
            }
        }
    }
}