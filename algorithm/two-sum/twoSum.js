/**
 * @param {number[]} numArray
 * @param {number} target
 * @returns {number[]}
 */
export default function(numArray, target) {
  const dict = new Map()
  const result = []

  numArray.forEach((value, index) => {
    if (dict.has(value) === true) result.push([dict.get(value), index])
    else dict.set(target - value, index)
  })

  return result
}
