/**
 * @param {number[]} numArray
 * @param {number} target
 * @returns {number[]}
 */
export default function(numArray, target) {
  const dict = {}
  const result = []

  numArray.forEach((value, index) => {
    if (dict[value] !== undefined) result.push([dict[value], index])
    else dict[target - value] = index
  })

  return result
}
