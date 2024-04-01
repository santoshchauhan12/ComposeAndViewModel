package com.android.composeandviewmodel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.composeandviewmodel.ui.theme.appTypography


@Composable
fun TravelCard() {

    var imageUrl = "https://images.pexels.com/photos/33109/fall-autumn-red-season.jpg?cs=srgb&dl=pexels-pixabay-33109.jpg&fm=jpg&_gl=1*1l13b11*_ga*MTA4MTQyNzU1Ni4xNzExNDcwNjQ3*_ga_8JE65Q40S6*MTcxMTQ3MDY0Ny4xLjAuMTcxMTQ3MDY0Ny4wLjAuMA.."
    Card {
        Column {
            AsyncImage(model = imageUrl,
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
                    .height(150.dp)
                    .size(150.dp)
                    .clip(MaterialTheme.shapes.medium))

            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = LocalContext.current.getString(R.string.title_trip),
                    style = appTypography.labelSmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.padding(8.dp))
                Text(text = LocalContext.current.getString(R.string.desc1),
                    style = appTypography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(8.dp))
                Text(text = LocalContext.current.getString(R.string.desc2),
                    style = appTypography.bodySmall,
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(8.dp))
            }


        }
    }
}