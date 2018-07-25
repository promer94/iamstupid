import twoSum from './twoSum'

it('two sum', () => {
  const numArray = [1, 2, 3, 4, 5]
  const target = 5
  const result = twoSum(numArray, target)
  expect(result).toEqual([[1, 2], [0, 3]])
})
