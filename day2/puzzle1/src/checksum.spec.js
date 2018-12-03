"use strict";
import {checksum} from "./checksum"
import {expect} from "chai";

describe("Checksum", () => {
    xit("fails", () => {
        expect(checksum("abcdef\nbababc\nabbcde\nabcccd\naabcdd\nabcdee\nababab\n")).to.equal(12);
    });
});