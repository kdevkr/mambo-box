# Kotlin

## How to learn
- [Learn Kotlin by Example](https://play.kotlinlang.org/byExample/overview)
- [Kotlin Koans](https://play.kotlinlang.org/koans/overview)

## Basic
- [Null safety](https://kotlinlang.org/docs/null-safety.html)
- [Conditions and loops](https://kotlinlang.org/docs/control-flow.html)
- [Destructuring declarations](https://kotlinlang.org/docs/destructuring-declarations.html)
- [Create DTOs](https://kotlinlang.org/docs/idioms.html#create-dtos-pojos-pocos)
- [Iterate over a range﻿](https://kotlinlang.org/docs/idioms.html#traverse-a-map-or-a-list-of-pairs)
- [Scope functions](https://kotlinlang.org/docs/scope-functions.html#function-selection)

### Kotlin Input/Output
```kt
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str = readln()

    bw.flush();bw.close()
}
```

## Tips

- [How to Use Kotlin Range Expressions](https://www.baeldung.com/kotlin/ranges)
- [Convert Between Int and Char in Kotlin](https://www.baeldung.com/kotlin/convert-between-int-and-char)
- [Convert String to Char in Kotlin](https://www.baeldung.com/kotlin/string-char-conversion)
- [Convert String Array to Int Array in Kotlin](https://www.baeldung.com/kotlin/array-string-integer-conversion)
- [Convert Array to List in Kotlin](https://www.baeldung.com/kotlin/array-to-list)
- [Swap Function in Kotlin](https://www.baeldung.com/kotlin/swap-utility)
- [Kotlin Companion Object](https://www.baeldung.com/kotlin/companion-object)
- [Kotlin TODO() Function](https://www.baeldung.com/kotlin/todo)
- [Kotlin Arrow Operator](https://www.baeldung.com/kotlin/arrow-operator)
