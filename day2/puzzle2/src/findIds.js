function findIds(input) {
    const words = input.split("\n");
    return firstWordWithDistance1(words[0], words.slice(1));
}

function firstWordWithDistance1(word, words) {
    const commons = words.map(commonLetters(word));
    const distance1 = commons.filter(letters => word.length - letters.length === 1);
    if(distance1.length === 0) return firstWordWithDistance1(words[0], words.slice(1));
    else return distance1[0];
}

let commonLetters = firstWord => secondWord => {
    let commons = "";
    for (let i = 0; i < Math.min(firstWord.length, secondWord.length); i++) {
        if(firstWord.charAt(i) === secondWord.charAt(i)) {
            commons += firstWord.charAt(i);
        }
    }
    return commons;
};

export {findIds,commonLetters};