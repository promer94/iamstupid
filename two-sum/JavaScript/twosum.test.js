import twoSum from './twoSum'

test.each`
  numArray           | target | expected
  ${[2, 7, 9, 11]}   | ${9}   | ${[[0, 1]]}
  ${[1, 2, 3, 4, 5]} | ${5}   | ${[[1, 2], [0, 3]]}
  ${[2, 4, 3, 1, 5]} | ${5}   | ${[[0, 2], [1, 3]]}
`(
  'When $numArray and $target returns $expected',
  ({ numArray, target, expected }) => {
    expect(twoSum(numArray, target)).toEqual(expected)
  }
)
