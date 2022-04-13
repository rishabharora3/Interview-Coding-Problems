import sys
def twoNumberSum(array, targetSum):
    # Write your code here.
    array.sort()
    sum_array = []
    sum_elements = -sys.maxsize - 1
    for i in range(len(array)):
        if sum_elements == targetSum:
            break
        for j in range(i+1, len(array)):
            sum_array = []
            sum_elements = array[i] + array[j]
            if sum_elements > targetSum:
                break
            elif sum_elements == targetSum:
                sum_array.append(array[i])
                sum_array.append(array[j])
                break
    return sum_array

