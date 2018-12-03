"use strict";
import {commonLetters, findIds} from "./findIds"
import {expect} from "chai";

describe("Checksum", () => {
    describe("find ids", () => {
        it("gives the common letters", () => {
            expect(findIds("abcde\nfghij\nklmno\npqrst\nfguij\naxcye\nwvxyz")).to.equal("fgij");
        });
    });
    describe("letters in common", () => {
        it("should give common letters between two words", () => {
            expect(commonLetters("a")("a")).to.equal("a");
            expect(commonLetters("ab")("a")).to.equal("a");
            expect(commonLetters("a")("ab")).to.equal("a");
        });
    });
});