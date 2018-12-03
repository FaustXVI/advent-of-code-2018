function letterCount(input) {
    const result = {};
    for (let i = 0; i < input.length; i++) {
        result[input.charAt(i)] = (result[input.charAt(i)] || 0) + 1;
    }
    return result;
}

let containsALetterTimes = n => word => {
    for (let letter in word) {
        if (word[letter] === n) {
            return true;
        }
    }
    return false;
};

function checksum(input) {
    const words = input.split("\n");
    const letterCounts = words.map(letterCount);
    const doubles = letterCounts.filter(containsALetterTimes(2)).length;
    const triples = letterCounts.filter(containsALetterTimes(3)).length;
    return doubles * triples;
}

export {checksum, letterCount, containsALetterTimes};