const threeSum = function(nums) {
  nums.sort((a, b) => a - b)
  const answers = []
  let start = 0
  let low
  let high
  let sum
  while (start < nums.length && nums[start] <= 0) {
    high = nums.length - 1
    low = start + 1
    while (low < high) {
      sum = nums[start] + nums[low] + nums[high]
      if (sum < 0) {
        low += 1
        continue //eslint-disable-line
      }
      if (sum > 0) {
        high -= 1
        continue //eslint-disable-line
      }
      answers.push([nums[start], nums[low], nums[high]])
      while (nums[low] === nums[low + 1] && low + 1 < high) {
        low += 1
      }
      low += 1
    }
    while (nums[start] === nums[start + 1] && start + 1 < nums.length) {
      start += 1
    }
    start += 1
  }
  return answers.reverse()
}
export default threeSum
