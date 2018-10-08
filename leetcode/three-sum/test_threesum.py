import unittest
from three_sum import three_sum
class TestThreeSum(unittest.TestCase):
    def test_function(self):
        self.assertEqual(three_sum([0,0,0,0]),[[0,0,0]])
        self.assertEqual(three_sum([-25, -10, -7, -3, 2, 4, 8, 10]),[[-7, -3, 10], [-10, 2, 8]])
        self.assertEqual(three_sum([-1, 0, 1, 2, -1, -4]),[[-1, 0, 1], [-1, -1, 2]])