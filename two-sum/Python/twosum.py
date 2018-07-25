def two_sum(numArray, target):
    hashTable = dict()
    result = list()
    for index, value in enumerate(numArray):
        if value in hashTable:
            result.append([hashTable[value], index])
        else:
            hashTable[target-value] = index
    return result