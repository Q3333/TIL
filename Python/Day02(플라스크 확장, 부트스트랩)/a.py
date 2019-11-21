# x = int(input())
# print(x)

# for c in "string":
#     print(c)

# for i in range(0,5):
#     print(i, i**2)

# score = {
#     '수학':80,
#     '국어':90,
#     '음악':100
# }

# total_score = sum(score.values())
# avg = total_score/ len(score)

# print("전체 합은 : "  + str(total_score))
# print("평균은 : "  + str(avg))
# print("딕셔너리 values 값은 : " + str(score.values()))


# 2. 반 평균을 구하세요. 전체 평균
# scores = {
#     "a" : {
#         "수학" :80,
#         "국어" :90,
#         "음악" :100
#     },
#     "b" : {
#         "수학" :80,
#         "국어" :70,
#         "음악" :80
#     },
#     "c" : {
#         "수학" :50,
#         "국어" :70,
#         "음악" :60
#     },
#     "d" : {
#         "수학" :80,
#         "국어" :80,
#         "음악" :80
#     }
    
# }

# a_avg = sum(scores["a"].values()) / len(scores["a"])
# b_avg = sum(scores["b"].values()) / len(scores["b"])
# c_avg = sum(scores["c"].values()) / len(scores["c"])
# d_avg = sum(scores["d"].values()) / len(scores["d"])

# avg = (a_avg+b_avg+c_avg+d_avg) / len(scores)

# print(avg)


city = {
    '서울' : [-6,-10,5],
    '대전' : [-3,-5,2],
    '광주' : [0,-2,10],
    '부산' : [2,-2,9]
}

# #3-1 도시별 최근 3일의 온도 평균은?

# s_avg = sum(city['서울'])
# d_avg = sum(city['대전'])
# g_avg = sum(city['광주'])
# b_avg = sum(city['부산'])


# print("서울의 온도 평균은 : " + str(s_avg/len(city['서울'])))
# print("대전의 온도 평균은 : " + str(d_avg/len(city['대전'])))
# print("광주의 온도 평균은 : " + str(g_avg/len(city['광주'])))
# print("부산의 온도 평균은 : " + str(b_avg/len(city['부산'])))

# #답 코드
# for name, temp in city.items():
#     avg_temp = sum(temp) / len(temp)
#     print(f'{name} : 평균 기온은 {avg_temp} 입니다.')


#3-2 위에서 서울은 영상 2도였던 적이 있나요?
# A if 조건문 else B


print(city.items())

print("있어요") if 2 in city["서울"] else print("없어요")