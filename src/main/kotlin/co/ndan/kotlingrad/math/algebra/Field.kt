package co.ndan.kotlingrad.math.algebra

interface Field<X> : CommutativeRing<X> {
  fun inverse(): X

  operator fun div(divisor: X): X
}