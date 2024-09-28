package tm.com.balary.features.product.presentation.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.lyricist.LocalStrings

@Composable
fun ProductDetailPrice(
    modifier: Modifier = Modifier,
    price: Double? = 0.0,
    discountPrice: Double? = 0.0,
    discount: Double? = 0.0
) {
    val strings = LocalStrings.current
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            "$discountPrice ${strings.money}",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.W900,
                fontSize = 18.sp
            ),
            color = MaterialTheme.colorScheme.onSurface
        )

        discount?.let {
            if(discount>0) {
                Text(
                    "$price ${strings.money}",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.W700
                    ),
                    color = MaterialTheme.colorScheme.outline,
                    textDecoration = TextDecoration.LineThrough
                )
            }
        }
    }
}