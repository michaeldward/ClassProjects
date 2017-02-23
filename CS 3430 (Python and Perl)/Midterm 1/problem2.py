def nested_list_sum(newlist):
    sum = 0
    for number in newlist:
        if isinstance(number, list):
            sum += nested_list_sum(number)
        else:
            sum += number
    return sum
