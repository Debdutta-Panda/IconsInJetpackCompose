package com.debduttapanda.iconsinjetpackcompose

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.debduttapanda.iconsinjetpackcompose.ui.theme.IconsInJetpackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IconsInJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Icon(imageVector = Icons.Filled.Mail, contentDescription = "")
                        Icon(imageVector = Icons.Outlined.Mail, contentDescription = "")
                        Icon(imageVector = Icons.Outlined.Mail, contentDescription = "", tint = Color.Red)
                        Icon(painter = painterResource(id = R.drawable.phone), contentDescription = "", tint = Color.Green)
                        Icon(bitmap = createBitmap().asImageBitmap(), contentDescription = "", modifier = Modifier.size(100.dp))
                        Icon(imageVector = createImageVector(), contentDescription = "")
                    }
                }
            }
        }
    }

    fun createImageVector(): ImageVector{
        return ImageVector.Builder(
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f,
        ).run {
            addPath(
                pathData = addPathNodes("M20,10C22,13 17,22 15,22C13,22 13,21 12,21C11,21 11,22 9,22C7,22 2,13 4,10C6,7 9,7 11,8V5C5.38,8.07 4.11,3.78 4.11,3.78C4.11,3.78 6.77,0.19 11,5V3H13V8C15,7 18,7 20,10Z"),
                name = "",
                fill = SolidColor(Color.White),
                stroke = SolidColor(Color.Black),
            )
            build()
        }
    }

    fun createBitmap(): Bitmap{
        val width = 200
        val height = 200
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        val paint = Paint()
        paint.setColor(android.graphics.Color.BLACK)
        paint.setStyle(Paint.Style.FILL)
        //canvas.drawPaint(paint)

        paint.setColor(android.graphics.Color.WHITE)
        paint.setAntiAlias(true)
        paint.setTextSize(100f)
        paint.setTextAlign(Paint.Align.CENTER)
        canvas.drawText("H", width / 2f, height / 2f, paint)
        return bitmap
    }

}
