function solution(clothes) {
	let map = {};
	clothes.forEach((cloth) => {
		if (Object.keys(map).includes(cloth[1])) {
			map[cloth[1]].push(cloth[0]);
		} else {
			map[cloth[1]] = [cloth[0]];
		}
	});

	const nums = Object.values(map).map((kind) => kind.length);

	const answer = nums.reduce((acc, num) => acc * (num + 1), 1) - 1;
	return answer;
}
