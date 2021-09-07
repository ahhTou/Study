# 基础知识

文档：数据对象 相当与一条记录

集合：数组 （含多个文档） 相当于一个表



# 在node.js中使用

## 安装Mongoose

```sh
npm install --save mongoose
```

## 第一次连接

>  使用node可以直接运行

```js
// 旧版本
// 1.1 引入mongoose
const mongoose = require('mongoose')

// 1.2.连接指定数据库(URL只有数据库是变化的)
mongoose.connect('mongodb://localhost:27017/tou_zp_test')

// 1.3．获取连接对象
const conn = mongoose.connection

// 1.4．绑定连接完成的监听(用来提示连接成功)
conn.on('connected', () => {
    console.log('√ Mongoose Connect Success')
})


// 新版本！！
const mongoose = require('mongoose')
const url = 'mongodb://localhost:27017/tou_zp'
mongoose.connect(url, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false,
}, (err) => {
    if (err) console.log('× MongoDB Connect Error')
    else console.log('√ MongoDB Connect Success')
})
```

## 得到实例

```js
// 2.1．字义schema(描述文档结构)
const userSchema = mongoose.Schema({
    // 指定文档结构 ： 属性名 | 属性值的类型 | 是否是必须的
    username: {type: String, require: true},
    password: {type: String, require: true},
    type: {type: String, require: true},
    header: {type: String}
})

// 2.2．定义 ModeL(与集合对应，可以操作集合)
const UserModel = mongoose.model('user', userSchema) // 集合的名称为Users
```

## 增

```js
// 创建UserModel的实例
const userModel = new UserModel({
    username: 'Tom',
    password: md5('123'),
    type: 'god',
})

// 完成时候的回调函数，参数是 err 和 user文档对象
userModel.save((err, user) => {
    if (!err) {
        console.log('保存成功 -> user is', user)
    }
})
```

## 查

简单查询

```js
// 只写一个参数 是 完成时候的回调函数
// 两个参数时候，第一个参数 是 过滤条件

// 通过回调函数得到错误和users信息
UserModel.find((err, users) => {
    if (!err) {
        console.log('find() 成功！')
        users.forEach(user => {
            console.log(user)
        })
    }
})

UserModel.findOne({_id: '5fcf8cb409441802581af211'}, (err, user) => {
    if (!err) {
        console.log('findOne() 成功')
        console.log(user)
    }
})

// 或， 查询 from 为userid 或者 to为userid的记录
ChatModel.find({'$or': [{from: userid}, {to: userid}]}, filter, function (err, chatMessages) {
    // 返回包含所有用户和当前用户相关的所有聊天消息的数据
    res.send({code: 0, data: {users, chatMessages}})
})
```

## 改

根据id改

```js
// id | 更新文档 | 回调函数
UserModel.findByIdAndUpdate(
    {_id: '5fcf8cb409441802581af211'}, // 过滤
    {username: 'Jack'}, // 更新内容
    {multi: false}, 
    (err, oldUser) => console.log(err, oldUser)
)

ChatModel.update({from, to, read: false}, // 条件
                 {read: true},   // 更新内容
                 {multi: true}, // 如果查询到多条，是否更新多条
                 (err, doc) => {
    console.log('/toRead', doc)
    res.send({code: 0, data: doc.nModified}) // 更新的数量
})
```

## 删

根据id删

```js
// 过滤条件 | 回调函数(错误信息， 执行数据{ 删除数量 | 是否成功 | 删除计数 })
UserModel.deleteOne({_id: '5fcf8cb409441802581af211'}, (err, doc) => {
    console.log('remove', err, doc)
})
```

## filter

可以让得到的结果 进行过滤，如password:0 可以让密码值消失

```js
const filter = {password: 0, __v: 0}

    UserModel.findOne({username, password: md5(password)}, filter, (err, user) => {
	...
    })

```