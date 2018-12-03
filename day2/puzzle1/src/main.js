import {checksum} from "./checksum";

const getStdin = require('get-stdin');

getStdin()
    .then(checksum)
    .then(console.log);