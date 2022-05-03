def solution(s):
    answer = []
    chk=[False]*(10**6+1)
    s=parsing(s)
    s.sort(key=lambda x:len(x))
    for i in range(len(s)):
        for j in range(len(s[i])):
            if not chk[s[i][j]]:
                answer.append(s[i][j])
                chk[s[i][j]]=True;
    return answer;

def parsing(line):
    line=line[1:-1]
    data=[]
    tmpArr=[]
    tmp=""
    for l in line:
        if l=='{':
            tmpArr=[]
        elif l==',':
            if len(tmp)!=0:
                tmpArr.append(int(tmp))
                tmp=''
        elif l=='}':
            if len(tmp)!=0:
                tmpArr.append(int(tmp))
                tmp=''
            if len(tmpArr)!=0:
                data.append(tmpArr);
        else:
            tmp+=l;
    return data;