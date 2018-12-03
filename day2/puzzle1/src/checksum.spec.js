"use strict";
import {checksum, letterCount, containsALetterTimes} from "./checksum"
import {expect} from "chai";

describe("Checksum", () => {
    it("should compute a full input", () => {
        expect(checksum("abcdef\nbababc\nabbcde\nabcccd\naabcdd\nabcdee\nababab\n")).to.equal(12);
    });
    it("should compute a simple input", () => {
        expect(checksum("bababc\n")).to.equal(1);
    });
    describe("letter count", () => {
        it("counts each letter", () => {
            expect(letterCount("bababc")).to.deep.equal({"a": 2, "b": 3, "c": 1})
        });
    });
    describe("predicate on letter duplication", () => {
        it("find if one letter appears the right number of time", () => {
            expect(containsALetterTimes(2)({"a": 2, "b": 3, "c": 1})).to.be.true;
            expect(containsALetterTimes(3)({"a": 2, "b": 3, "c": 1})).to.be.true;
            expect(containsALetterTimes(4)({"a": 2, "b": 3, "c": 1})).to.be.false;
        });
    });
});