import uniqueInOrder from './uniqueInOrder'

test.each`
  input                | expected
  ${'AAAABBBCCDAABBB'} | ${['A', 'B', 'C', 'D', 'A', 'B']}
  ${'ABBCcAD'}         | ${['A', 'B', 'C', 'c', 'A', 'D']}
  ${[1, 2, 2, 3, 3]}   | ${[1, 2, 3]}
`('$input ==> $expected ', ({ input, expected }) => {
  expect(uniqueInOrder(input)).toEqual(expected)
})
