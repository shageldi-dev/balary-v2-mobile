package tm.com.balary.features.product.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import balary.composeapp.generated.resources.Res
import balary.composeapp.generated.resources.placeholder
import balary.composeapp.generated.resources.timer
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import tm.com.balary.core.loremIpsum
import tm.com.balary.features.product.presentation.ui.detail.ProductDetailScreen
import tm.com.balary.ui.ImageLoader

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    title: String = "Product Name"
) {
    val navigator = LocalNavigator.currentOrThrow
    val shape = RoundedCornerShape(4.dp)
    Column(modifier = modifier.clip(RoundedCornerShape(4.dp)).background(
        color = MaterialTheme.colorScheme.surface,
        RoundedCornerShape(4.dp)
    ).clickable {
        navigator.push(ProductDetailScreen())
    }) {
        Box(
            Modifier
                .size(176.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape
                )
        ) {
            ImageLoader(
                modifier = Modifier.fillMaxSize(),
                url = "",
                contentScale = ContentScale.Inside
            )

            Row(Modifier.align(Alignment.BottomEnd).background(
                color = Color(0xFF614FE0),
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    bottomStart = 20.dp
                )
            ).padding(horizontal = 7.dp, vertical = 2.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                Icon(
                    painter = painterResource(Res.drawable.timer),
                    contentDescription = "timer",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("3 gün", style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.W700
                    ), color = Color.White)
                    Spacer(Modifier.height(2.dp))
                    Text("09:55:59", style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 10.sp
                    ), color = Color.White)
                }
            }

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FavoriteButton(
                    modifier = Modifier,
                    isLiked = false
                )

                ProductTag(
                    modifier = Modifier,
                    text = "Arzanladyş"
                )
            }
        }



        Column(Modifier.fillMaxWidth().padding(4.dp)) {
            Spacer(Modifier.height(10.dp))
            ProductPrice(
                modifier = Modifier.fillMaxWidth(),
                price = 170.0,
                oldPrice = 190.0,
                discount = 5.0
            )
            Spacer(Modifier.height(10.dp))

            Text(
                title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.W900
                ),
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(8.dp))

            Text(
                loremIpsum,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.W700,
                    fontSize = 10.sp
                ),
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(6.dp))
            ProductCount(
                modifier = Modifier.fillMaxWidth(),
                star = 4.3,
                commentCount = 123
            )
            Spacer(Modifier.height(6.dp))
            ProductBasketButton(modifier = Modifier.fillMaxWidth())
        }
    }
}