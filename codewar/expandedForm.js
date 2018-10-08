function expandedForm(num) {
  if (num < 10) return `${num}`
  const over = num % Math.pow(10, num.toString().length - 1) //eslint-disable-line
  if (over === 0) return `${num}`
  return `${num - over} + ${expandedForm(over)}`
}

export default expandedForm
