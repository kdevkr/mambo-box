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

## Cheetsheet
- [Kotlin Cheat Sheet](https://blog.kotlin-academy.com/kotlin-cheat-sheet-1137588c75a)
- [Kotlin Cheat sheet](https://alidehkhodaei.github.io/kotlin-cheat-sheet/)
- [Kotlin cheatsheet](https://devhints.io/kotlin)
