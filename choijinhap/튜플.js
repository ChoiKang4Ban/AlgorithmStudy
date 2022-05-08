function solution(s) {
	const arr = JSON.parse(s.replace(/[{}]/g, (a) => (a === '{' ? '[' : ']'))).sort(
		(a, b) => a.length - b.length
	);
	const answer = arr.reduce((acc, e) => acc.concat(e.filter((x) => !acc.includes(x))));
	return answer;
}
