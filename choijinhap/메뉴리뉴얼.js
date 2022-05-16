function solution(orders, course) {
	let menu = new Map();

	//order에서 길이 len인 부분집합 menu에 갯수담기
	function combination(order, idx, len, prev) {
		if (prev.length === len) {
			let cur_key = prev.sort().join('');
			if (menu.has(cur_key)) {
				menu.set(cur_key, menu.get(cur_key) + 1);
			} else {
				menu.set(cur_key, 1);
			}
			return;
		}
		for (let i = idx; i < order.length; i++) {
			combination(order, i + 1, len, [...prev, order[i]]);
		}
	}

	//orders전부 course에서 len받아서 menu만들기
	orders.map((order) => course.map((num) => combination(order, 0, num, [])));

	//menu에서 갯수 1개 초과한 애들 길이 내림차순으로 정렬
	menu = [...menu.entries()]
		.filter((item) => item[1] > 1)
		.sort((a, b) => b[0].length - a[0].length);

	//menu에서 course길이 마다 최댓값 갖는 문자열 res에 담기
	let res = [];
	course.map((num) => {
		let max = 0;
		const tmp = menu.filter(([k, v]) => {
			if (max < v && k.length === num) max = v;
			return k.length === num;
		});
		tmp.filter((x) => x[1] === max).map((x) => res.push(x[0]));
	});
	console.log(res);
	return res.sort();
}
