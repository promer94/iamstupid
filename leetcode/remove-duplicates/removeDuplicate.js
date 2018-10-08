export const removeDuplicates = function(nums) {
  return nums.length === 0
    ? 0
    : nums.filter((value, index, array) => {
        return array.indexOf(value) === index
      })
}
