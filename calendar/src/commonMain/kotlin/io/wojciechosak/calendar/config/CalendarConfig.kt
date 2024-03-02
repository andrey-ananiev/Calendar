package io.wojciechosak.calendar.config

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.wojciechosak.calendar.utils.today
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.plus


@Stable
class CalendarConfig(
    val minDate: LocalDate,
    val maxDate: LocalDate,
    val focusDate: LocalDate,
    val dayOfWeekOffset: Int,
    val showNextMonthDays: Boolean,
    val showPreviousMonthDays: Boolean,
    val showHeader: Boolean,
    val showWeekdays: Boolean
)

@Composable
fun rememberCalendarState(
    minDate: LocalDate = LocalDate(1971, 1, 1),
    maxDate: LocalDate = LocalDate.today().plus(15, DateTimeUnit.YEAR),
    focusDate: LocalDate = LocalDate.today(),
    dayOfWeekOffset: Int = 0,
    showNextMonthDays: Boolean = true,
    showPreviousMonthDays: Boolean = true,
    showHeader: Boolean = true,
    showWeekdays: Boolean = true
): State<CalendarConfig> {
    return remember {
        mutableStateOf(
            CalendarConfig(
                minDate = minDate,
                maxDate = maxDate,
                focusDate = focusDate,
                dayOfWeekOffset = dayOfWeekOffset,
                showNextMonthDays = showNextMonthDays,
                showPreviousMonthDays = showPreviousMonthDays,
                showHeader = showHeader,
                showWeekdays = showWeekdays
            )
        )
    }
}