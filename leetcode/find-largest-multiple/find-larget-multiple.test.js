import findLargest from './find-largest-multiple'

test.each`
  input                                                                       | expected
  ${[[10, 45, 90, 11], [23, 68, 29, 9], [49, 39, 23, 78], [46, 92, 21, 90]]}  | ${299880}
  ${[[34, 84, 75, 35], [55, 21, 89, 36], [75, 95, 35, 64], [25, 45, 95, 49]]} | ${496375}
`('$input => $expected', ({ input, expected }) => {
  expect(findLargest(input)).toEqual(expected)
})
