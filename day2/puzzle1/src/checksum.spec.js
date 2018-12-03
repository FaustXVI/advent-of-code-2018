"use strict";
import {checksum} from "./checksum"
import {expect} from "chai";

describe("Checksum", () => {
    it("fails", () => {
        expect(checksum(2)).to.equal(2);
    });
});