const uniqueInOrder = function(iterable) {
  return Array.prototype.filter.call(iterable, (value, index) => {
    return iterable[index - 1] !== value
  })
}
export default uniqueInOrder
