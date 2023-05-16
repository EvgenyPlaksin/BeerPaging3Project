package com.lnight.beerpaging3project.presentation.beer_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lnight.beerpaging3project.domain.Beer
import com.lnight.beerpaging3project.presentation.ui.theme.BeerPaging3ProjectTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ),
        onClick = {}
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = beer.imageUrl,
                contentDescription = beer.name,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(18.dp))
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = beer.name,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = beer.tagline,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beer.description,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "First brewed in ${beer.firstBrewed}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 8.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BeerItemPreview() {
    BeerPaging3ProjectTheme {
        BeerItem(
            beer =  Beer(
                id = 1,
                name = "Attention",
                tagline = "If you see this you have to leave a star on the repository",
                firstBrewed = "16/05/2023",
                description = "This is super important and shows that you like my work. \nI'll be thankful for this, so go and do it! ⭐",
                imageUrl = "https://avatars.githubusercontent.com/u/94696816?s=400&u=019889685968ca963c1b6cdb3a3bb454b47b5c01&v=4"
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
