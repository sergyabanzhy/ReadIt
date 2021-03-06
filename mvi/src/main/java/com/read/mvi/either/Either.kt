package com.read.mvi.either

sealed class Either<out L, out R> {

    data class Left<out L>(val a: L) : Either<L, Nothing>()
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    val isRight get() = this is Right<R>
    val isLeft get() = this is Left<L>

    fun <L> leftRes(a: L) = Left(a)
    fun <R> rightRes(b: R) = Right(b)

    inline fun either(error: (L) -> Any, result: (R) -> Any): Any =
        when (this) {
            is Left -> error(a)
            is Right -> result(b)
        }

    inline fun right(function: (R) -> Unit): Either<L, R> {
        when (this) {
            is Right -> function.invoke(this.b)
        }
        return this
    }

    inline fun left(function: (L) -> Unit): Either<L, R> {
        when (this) {
            is Left -> function.invoke(this.a)
        }
        return this
    }
}

fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
    f(this(it))
}

fun <T, L, R> Either<L, R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> =
    when (this) {
        is Either.Left -> Either.Left(a)
        is Either.Right -> fn(b)
    }

fun <L, R> Either<L, R>.getOrElse(value: R): R =
    when (this) {
        is Either.Left -> value
        is Either.Right -> b
    }

fun <T, L, R> Either<L, R>.map(fn: (R) -> (T)): Either<L, T> = this.flatMap(fn.c(::rightRes))