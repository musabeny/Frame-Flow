package uk.co.fogosoft.frameFlow.features.newProject.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.Coil
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.features.newProject.domain.model.ImageResource
import uk.co.fogosoft.frameFlow.features.newProject.presentation.NewProjectEvent
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun AlbumSection(
    modifier: Modifier,
    imgList : List<ImageResource>,
    onEvent: (NewProjectEvent) -> Unit
){
   Column(
       modifier = modifier,
       verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small2)
   ) {
       ImageTitle(
           modifier = Modifier.clickable {
                onEvent(NewProjectEvent.GoToAlbum)
           },
           title = R.string.albums
       )
      LazyRow(
          horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
      ){
          items(imgList){images ->
            Screenshots(modifier = Modifier
                .width(136.dp)
                .height(120.dp)
               ,
                imageOne = images.firstImage,
                imageTwo = images.secondImage,
                imageThree = images.thirdImage
            )
          }
      }

   }
}

@Composable
fun Screenshots(
    modifier: Modifier,
    imageOne:Int,
    imageTwo:Int,
    imageThree:Int
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ){
        ImageBox(
            padding = 16.dp,
            alignment = Alignment.CenterEnd
        ){
            PersonImage(
                modifier = Modifier
                    .size(100.dp)
                    ,
                imageId = imageThree
            )
        }

        ImageBox(
            padding = 8.dp
        ){
            PersonImage(
                modifier = Modifier
                    .size(110.dp)
                ,
                imageId = imageTwo
            )
        }


        PersonImage(
            modifier = Modifier.size(120.dp),
            imageId = imageOne
        )
        Box(
            modifier = Modifier
            .width(120.dp)
            .fillMaxHeight(),
            contentAlignment = Alignment.BottomStart
        ){
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(
                            bottomStart = MaterialTheme.dimens.small3,
                            bottomEnd = MaterialTheme.dimens.small3
                        )
                    )
                ,
                text = "Screenshot",
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun ImageBox(
    padding:Dp,
    alignment: Alignment = Alignment.Center,
    image:@Composable () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = padding),
        contentAlignment = alignment
    ){
        image()
    }
}

@Composable
fun PersonImage(
    modifier: Modifier,
    imageId:Int
){
    //R.mipmap.female
    Image(
        modifier = modifier
//            .size(imgSize)
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(MaterialTheme.dimens.small3)
            ),
        painter = painterResource(id = imageId),
        contentDescription = null,
        contentScale = ContentScale.Fit
    )
//    Box(
//        modifier = modifier
//            .background(
//                color = Color.Transparent,
//                shape = RoundedCornerShape(MaterialTheme.dimens.small3)
//            ),
//    ) {
//
//    }
//    Surface(
//        modifier = modifier,
//        shape = RoundedCornerShape(MaterialTheme.dimens.small3)
//    ) {
//
//
//    }
}




@Preview(showBackground = true)
@Composable
fun PreviewAlbum(){
    AlbumSection(
        modifier = Modifier,
        imgList = emptyList(),
        onEvent = {}
    )
}
