import {findIds} from "./findIds";

const getStdin = require('get-stdin');

getStdin()
    .then(findIds)
    .then(console.log);