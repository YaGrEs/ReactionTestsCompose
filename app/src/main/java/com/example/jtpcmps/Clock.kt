import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
private fun VectorPreview() {
    Image(Clock, null)
}

private var _Clock: ImageVector? = null

public val Clock: ImageVector
		get() {
			if (_Clock != null) {
				return _Clock!!
			}
_Clock = ImageVector.Builder(
                name = "Clock",
                defaultWidth = 85.dp,
                defaultHeight = 75.dp,
                viewportWidth = 85f,
                viewportHeight = 75f
            ).apply {
				group {
					path(
    					fill = SolidColor(Color(0xFF000000)),
    					fillAlpha = 1.0f,
    					stroke = null,
    					strokeAlpha = 1.0f,
    					strokeLineWidth = 1.0f,
    					strokeLineCap = StrokeCap.Butt,
    					strokeLineJoin = StrokeJoin.Miter,
    					strokeLineMiter = 1.0f,
    					pathFillType = PathFillType.NonZero
					) {
						moveTo(82f, 46.5f)
						arcTo(20.5f, 20.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 61.5f, 67f)
						arcTo(20.5f, 20.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 41f, 46.5f)
						arcTo(20.5f, 20.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 82f, 46.5f)
						close()
}
					path(
    					fill = SolidColor(Color(0xFFD9D9D9)),
    					fillAlpha = 1.0f,
    					stroke = null,
    					strokeAlpha = 1.0f,
    					strokeLineWidth = 1.0f,
    					strokeLineCap = StrokeCap.Butt,
    					strokeLineJoin = StrokeJoin.Miter,
    					strokeLineMiter = 1.0f,
    					pathFillType = PathFillType.NonZero
					) {
						moveTo(59.058f, 29f)
						horizontalLineTo(64.05799999999999f)
						verticalLineTo(46f)
						horizontalLineTo(59.058f)
						verticalLineTo(29f)
						close()
}
					path(
    					fill = SolidColor(Color(0xFF000000)),
    					fillAlpha = 1.0f,
    					stroke = null,
    					strokeAlpha = 1.0f,
    					strokeLineWidth = 1.0f,
    					strokeLineCap = StrokeCap.Butt,
    					strokeLineJoin = StrokeJoin.Miter,
    					strokeLineMiter = 1.0f,
    					pathFillType = PathFillType.NonZero
					) {
						moveTo(51f, 21f)
						arcTo(5f, 5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 46f, 26f)
						arcTo(5f, 5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 41f, 21f)
						arcTo(5f, 5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 51f, 21f)
						close()
}
					path(
    					fill = SolidColor(Color(0xFF000000)),
    					fillAlpha = 1.0f,
    					stroke = null,
    					strokeAlpha = 1.0f,
    					strokeLineWidth = 1.0f,
    					strokeLineCap = StrokeCap.Butt,
    					strokeLineJoin = StrokeJoin.Miter,
    					strokeLineMiter = 1.0f,
    					pathFillType = PathFillType.NonZero
					) {
						moveTo(82f, 21f)
						arcTo(5f, 5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 77f, 26f)
						arcTo(5f, 5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 72f, 21f)
						arcTo(5f, 5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 82f, 21f)
						close()
}
					path(
    					fill = null,
    					fillAlpha = 1.0f,
    					stroke = SolidColor(Color(0xFF000000)),
    					strokeAlpha = 1.0f,
    					strokeLineWidth = 1.0f,
    					strokeLineCap = StrokeCap.Butt,
    					strokeLineJoin = StrokeJoin.Miter,
    					strokeLineMiter = 1.0f,
    					pathFillType = PathFillType.NonZero
					) {
						moveTo(46f, 17f)
						curveTo(57.6f, 9.4f, 71.1667f, 13.8333f, 76.5f, 17f)
}
					path(
    					fill = SolidColor(Color(0xFF000000)),
    					fillAlpha = 1.0f,
    					stroke = null,
    					strokeAlpha = 1.0f,
    					strokeLineWidth = 1.0f,
    					strokeLineCap = StrokeCap.Butt,
    					strokeLineJoin = StrokeJoin.Miter,
    					strokeLineMiter = 1.0f,
    					pathFillType = PathFillType.NonZero
					) {
						moveTo(43.8228f, 70.6877f)
						lineTo(45.0883f, 58.1556f)
						lineTo(55.5686f, 66.1388f)
						lineTo(43.8228f, 70.6877f)
						close()
}
					path(
    					fill = SolidColor(Color(0xFF000000)),
    					fillAlpha = 1.0f,
    					stroke = null,
    					strokeAlpha = 1.0f,
    					strokeLineWidth = 1.0f,
    					strokeLineCap = StrokeCap.Butt,
    					strokeLineJoin = StrokeJoin.Miter,
    					strokeLineMiter = 1.0f,
    					pathFillType = PathFillType.NonZero
					) {
						moveTo(79.7252f, 69.9964f)
						lineTo(67.9793f, 65.4479f)
						lineTo(78.4592f, 57.4643f)
						lineTo(79.7252f, 69.9964f)
						close()
}
}
}.build()
return _Clock!!
		}

