package uk.co.fogosoft.frameFlow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import uk.co.fogosoft.frameFlow.features.common.navigation.NavGraph
import uk.co.fogosoft.frameFlow.ui.theme.FrameFlowTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrameFlowTheme(
                activity = this
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier,
//        color = MaterialTheme.colorScheme.secondary
//    )
    
    Box(modifier = Modifier
        .background(MaterialTheme.colorScheme.primary)
        .size(100.dp)

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FrameFlowTheme(
        activity = LocalContext.current as PreviewActivity
    ) {
        Greeting("Android")
    }
}