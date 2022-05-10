function solution(n, computers) {
	//parents: value=부모 idx=컴퓨터 번호
	const parents = [];
	for (let i = 0; i < n; i++) {
		parents.push(i);
	}

	//배열돌면서 연결된 컴퓨터 끼리 union
	computers.forEach((array, idx) => {
		array.forEach((e, i) => {
			if (e === 1) {
				union(idx, i);
			}
		});
	});

	//컴퓨터의 최상위 부모 리턴
	function find(computer) {
		if (computer === parents[computer]) return computer;
		return (parents[computer] = find(parents[computer]));
	}

	//컴퓨터 a, b union
	function union(a, b) {
		const aRep = find(a);
		const bRep = find(b);
		if (aRep === bRep) {
			return false;
		}
		parents[aRep] = bRep;
		return true;
	}

	//다른 네트워크 갯수 리턴
	return new Set(parents.map((child) => find(child))).size;
}
