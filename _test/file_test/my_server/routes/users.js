var express = require('express')
var router = express.Router()

/* GET users listing. */
router.get('/', function (req, res, next) {
    console.log('进来了，Sir')
})
router.post('/hello', function (req, res, next) {
    console.log('进来了，Sir')
})


module.exports = router
