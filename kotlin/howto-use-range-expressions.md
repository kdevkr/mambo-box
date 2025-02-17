## Kotlin Ranges

코틀린에서 범위 표현을 위한 문법을 알아보자.

- [Ranges and progressions](https://kotlinlang.org/docs/ranges.html#ranges)
- [How to Use Kotlin Range Expressions](https://www.baeldung.com/kotlin/ranges)
- [The ..< Operator for Open-ended Ranges in Kotlin](https://www.baeldung.com/kotlin/open-ended-ranges-operator)
- [Learn Kotlin :: Kotlin Ranges](https://hyperskill.org/university/kotlin/kotlin-ranges)
- [NEW OPERATOR in Kotlin (and true open-ended ranges)](https://www.youtube.com/watch?v=v0AHdAIBnbs)

### Range
- `rangeTo` → `..`
- `rangeUntil` → `until` → `..<`

### Progression
- `step`
- `downTo`
- `reserved`

### How to use?!
```kt
var arr = intArrayOf(1, 2, 3, 4)
for (i in arr.indices) print(i) // 0123
for (i in 0..arr.lastIndex) print(i) // 0123
for (i in 0 until arr.size) print(i) // 0123
for (i in 0..<arr.size) print(i) // 0123
for (i in arr.lastIndex downTo 0) print(i) // 3210
for (i in arr.indices.reversed()) print(i) // 3210
```
