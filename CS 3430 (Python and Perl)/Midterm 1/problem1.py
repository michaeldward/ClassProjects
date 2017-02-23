def most_freq_char(txt):
    all_letters = {}
    for char in txt:
        if char in all_letters.keys():
            all_letters[char] = all_letters[char] + 1
        else:
            all_letters[char] = 1
    for keys, values in all_letters.items():
        answer = list()
        answer.append(max(all_letters, key=all_letters.get))
        answer.append(all_letters[max(all_letters, key=all_letters.get)])
        return answer


