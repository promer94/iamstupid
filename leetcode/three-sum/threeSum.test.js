import threeSum from './threeSum'

test.each`
  input                              | expected
  ${[0, 0, 0, 0]}                    | ${[[0, 0, 0]]}
  ${[-25, -10, -7, -3, 2, 4, 8, 10]} | ${[[-7, -3, 10], [-10, 2, 8]]}
  ${[-1, 0, 1, 2, -1, -4]}           | ${[[-1, 0, 1], [-1, -1, 2]]}
`('$input ==> $expected ', ({ input, expected }) => {
  expect(threeSum(input)).toEqual(expected)
})
