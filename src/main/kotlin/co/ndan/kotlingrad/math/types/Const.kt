package co.ndan.kotlingrad.math.types


import co.ndan.kotlingrad.math.algebra.FieldPrototype
import co.ndan.kotlingrad.math.algebra.Field
import co.ndan.kotlingrad.math.calculus.Function

open class Const<X : Field<X>>(override val value: X, val prototype: FieldPrototype<X>) : Function<X>() {
  override val isConstant = true

  override fun differentiate(ind: Var<X>) = Zero(prototype)

  override fun toString(): String = value.toString()

  override fun plus(addend: Function<X>) =
    if (addend.isConstant) Const(addend.value + value, prototype) else super.plus(addend)

  override fun times(multiplicand: Function<X>) =
    if (multiplicand.isConstant) Const(multiplicand.value * value, prototype) else super.times(multiplicand)

  override fun inverse(): Const<X> = Const(value.inverse(), prototype)

  override fun unaryMinus(): Const<X> = Const(-value, prototype)
}