package com.spoonofcode.core.designsystem.components.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.spoonofcode.core.designsystem.components.Spacers
import com.spoonofcode.core.designsystem.components.text.Texts

object Sliders {

    @Preview
    @Composable
    fun Slider(
        labelPrefix: String = "",
        labelPostfix: String = "",
        minValue: Float,
        maxValue: Float,
        steps: Int,
        selectedPosition: Float,
        onPositionChange: (Int) -> Unit,
    ) {
        var sliderPosition by remember { mutableStateOf(selectedPosition) }
        Column {
            Texts.BLB(text = "$labelPrefix ${sliderPosition.toInt()} $labelPostfix")

            androidx.compose.material3.Slider(
                value = sliderPosition,
                onValueChange = {
                    sliderPosition = it
                    onPositionChange(sliderPosition.toInt())
                },
                valueRange = minValue..maxValue,
                steps = steps,
            )
            Spacers.VerticalBetweenFields()
        }
    }

    @Preview
    @Composable
    fun RangeSlider(
        label: String,
        minValue: Float,
        maxValue: Float,
        steps: Int,
        selectedStartPosition: Float,
        selectedEndPosition: Float,
        onStartPositionChange: (Int) -> Unit,
        onEndPositionChange: (Int) -> Unit,
    ) {
        var sliderPosition by remember { mutableStateOf(selectedStartPosition..selectedEndPosition) }
        Column {
            Texts.BLB(text = label + " ${sliderPosition.start.toInt()} - ${sliderPosition.endInclusive.toInt()}")

            androidx.compose.material3.RangeSlider(
                value = sliderPosition,
                steps = steps,
                onValueChange = {
                    sliderPosition = it
                    onStartPositionChange(sliderPosition.start.toInt())
                    onEndPositionChange(sliderPosition.endInclusive.toInt())
                },
                valueRange = minValue..maxValue
            )

            Spacers.VerticalBetweenFields()
        }
    }
}