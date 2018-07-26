import unittest
from twosum import two_sum
class TestTwoSum(unittest.TestCase):
    def test_function(self):
        self.assertEqual(two_sum([2,7,9,11],9),[[0,1]])
        self.assertEqual(two_sum([1,2,3,4,5],5),[[1,2],[0,3]])
        self.assertEqual(two_sum([2,1,5,3,2],4), [[1,3],[0,4]])

if __name__ == '__main__':  
    unittest.main() 