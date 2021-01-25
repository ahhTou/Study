

# Node快速部署服务器

```sh
serve [文件夹]
```

# 使用脚手架

直接在当前文件家创建

```sh
$ npx express-generator
```

 热部署

noodmon

```sh
安装
npm install -g nodemon

//使用
nodemon sth.js
```

配置项目中运行（脚手架）

`package.json`

```js
...  
"scripts": {
    "start": "nodemon ./bin/www"
  },
...
```

# 热部署

noodmon

```sh
安装
npm install -g nodemon

//使用
nodemon sth.js
```

配置项目中运行（脚手架）

`package.json`

```js
...  
"scripts": {
    "start": "nodemon ./bin/www"
  },
...
```

# Express

## 修改端口监听

`/bin/www.js`

```jsx
...
var port = normalizePort(process.env.PORT || '4000');
...
```

## 路由

# 工具类

## md5

```sh
npm install --save blueimp-md5
```

## 路径别名

```sh
npm i --save module-alias
```

在入口js中配置

```js
// 启动项目别名
require('module-alias/register')
```

在`package.json`中配置

```js
// Aliases
"_moduleAliases": {
  "@root"      : ".", // Application's root
  "@deep"      : "src/some/very/deep/directory/or/file",
  "@my_module" : "lib/some-file.js",
  "something"  : "src/foo", // Or without @. Actually, it could be any string
}
 
// Custom module directories, just like `node_modules` but with your private modules (optional)
"_moduleDirectories": ["node_modules_custom"],
```
