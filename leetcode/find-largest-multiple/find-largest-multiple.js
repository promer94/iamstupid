/**
 *
 *  Given a 4 by 4 matrix
 *   10 45 90 11
 *   23 68 29 09
 *   49 39 23 78
 *   46 92 21 90
 *
 * Find the largest multiple of 3 consecutive numbers that are in a line：
 * For the first horizontal line, the two multiples are 10 * 45 * 90, or 45 * 90 * 11
 * This applies to horizontal, vertical, and diagonal lines.
 * @param {array} square two dimensional array [[],[]]
 **/

export default function findLargest(square) {
  const N = square.length
  let Max = 0
  let tmp = 0
  let a = 0
  const boarder = N - 3
  for (let i = 0; i < N; i += 1) {
    for (let j = 0; j <= boarder; j += 1) {
      a = square[i][j]
      if (i <= boarder) {
        tmp = a * square[i + 1][j] * square[i + 2][j]
        Max = Max > tmp ? Max : tmp
        tmp = a * square[i + 1][j + 1] * square[i + 2][j + 2]
        Max = Max > tmp ? Max : tmp
      }
      tmp = a * square[i][j + 1] * square[i][j + 2]
      Max = Max > tmp ? Max : tmp
      if (i > boarder) {
        tmp = a * square[i - 1][j + 1] * square[i - 2][j + 2]
        Max = Max > tmp ? Max : tmp
      }
    }
  }
  return Max
}
