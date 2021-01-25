var express = require('express')
var router = express.Router()
var formidable = require('formidable')
var fs = require('fs')

/* GET home page. */
router.get('/', function (req, res, next) {
    res.render('index', {title: 'Express'})
})
router.post('/hello', function (req, res, next) {
    const form = new formidable.IncomingForm()
    form.parse(req, (err, fields, files = {}) => {
        if (!err) {
            fs.readFile(files.fileUpload.path, (err, data) => {
                    if (!err) {
                        fs.writeFile('D:\\ttt\\1.jpg', data, (err) => {
                            if (!err) {
                                res.send('写入文件成功')
                            } else {
                                res.send('err')
                            }
                        })
                    }
                }
            )
        }
    })
})


module.exports = router
