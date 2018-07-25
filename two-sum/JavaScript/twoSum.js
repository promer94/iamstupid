/**
 * @param {number[]} numArray
 * @param {number} target
 * @returns {number[]}
 */
export default function(numArray, target) {
  const dict = {}
  const result = []
  for (let i = 0; i < numArray.length; i += 1) {
    if (dict[numArray[i]] !== undefined) {
      result.push([dict[numArray[i]], i])
    } else {
      dict[target - numArray[i]] = i
    }
  }
  /*
  numArray.map((value, index) => {
    if (dict[value] !== undefined) result.push([dict[value], index])
    else dict[target - value] = index
  })
  */
  return result
}
