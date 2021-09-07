# 了解Gulp

## 前端自动化打包构建工具

 => 打包：把文件压缩，整合，移动，混肴

了解一下前端的打包构建工具

- Gulp: **基于流的打包构建工具**
- `WebPack`: 基于JS文件的打包构建工具



## 什么是流

+ 流文件：流

- 一种文件传输格式
- 一段一段的文件传输

- **流格式**：流
  - 从头到尾的一个过程
  - 需要从 源 开始 一部一部经过加工
    - 每一步的步骤都需要依赖上一步的过程
    - 最终给出一个完整的成品
  - **Gulp 是基于流格式的一种打包构建工具**



## Gulp的依赖环境

- 依赖于 node 环境 进行开发
- 底层封装的内容就是 node 里面的读写文件



## Gulp 的 作用

- 对于 CSS 文件
  - 压缩
  - 转码 （如 自动添加前缀）
- 对于 JS 文件
  - 压缩
  - 转码 （如 ES6 转 ES5）
- 对于 HTML 文件
  - 压缩
  - 转码 （如 对格式的转换）
- 对于静态资源文件的处理
- 对于第三方文件的处理
- ...

# 安装和使用

## 命令

```bash
yarn add global gulp
npm install --global gulp

# 执行任务
gulp 任务名称
```

## 版本

- gulp@3 版本号是 gulp 3.x.x
- gulp@4 版本号是 gulp cli 2.x.x

# 使用Gulp

- 1. 准备一个项目

     - 需要确定好确定自己的目录结构
     - 分开源码和打包以后的内容

  2. 确定自己的目录结构

     ```markdown
     - demo
     	- src		源码
     	+ pages		html
     	+ css		css
     	+ js		js 
     	+ sass		sass
     	+ images	图片
     	+ vidoe 	视频
     	+ audios	音频
     	+ lib		第三方文件（Jquery, swiper,...）
     	+ fonts		文件图标文件
     ```

  3. 准备 一个 gulpfile.js 的文件

     - 必须有
     - Gulp 进行打包的依据
     - 我们在这个文件里面进行本项目的打包配置
     - Gulp 在运行的时候，会自动读取 gulpfile.js 文件里的配置
     - 按照你在 gulpfile.js 文件里的配置进行打包的工作
     - 注意：**直接写在根目录，和 `src` 同级**

  4. 为项目安装 Gulp 依赖

  5. 在 gulpfile.js 里 书写配置文件



# API

`gulp.task(任务名称， 任务处理函数)`

* **创建一个基于流的任务**

`gulp.src(路径)`

-  **找到源文件**

- `gulp.src('./a/b.html')`
- `gulp.src('./a/*.html')` 找到母录下的所有指定前缀文件
- `gulp.src('./a/**')` 找到目录下的所有文件
- `gulp.src('./a/** /*')` 找到 a 目录下所有子目录里面的所有文件
- `gulp.src('./a/** /*.html')` 找到 a 目录下所有子目录里面的所有html

`gulp.dest(路径)`

- 把一个内容放到指定目录
- `gulp.dest('./hello')` 把gulp接收到的内容放到 hello 目录下

`gulp.watch(路径信息， 任务名称)`

- 监控指定目录下的文件，一旦发生变化，重新执行后面的任务

`gulp.series(任务1, ...任务N)`

- 逐个执行多个任务，按顺序。

`gulp.parallel(任务1, ...任务N)`

- 并行开始多个任务

```js
// 1. 方式1
gulp.task('default', () => {

})

// 2. 方式2
const def = gulp.parallel(cssHandler, sassHandler, jsHandler)


module.exports = {
    cssHandler,
    sassHandler,
    jsHandler,
    HTMLHandler,
    imgHandler,
    videoHandler,
    audiosHandler,
    libHandler,
    default: def
}
```

`pipe()`

- 管道函数，所有gulp API 都说基于流，接受当前流，进入下一个流过程的管道函数
- `gulp.src().pipe(压缩任务)。pipe(转码).pipe(gulp.dest('./dest'))`

# 插件和任务

- Gulp 的各种插件就是用来执行各种各样的压缩混淆转码任务的

## CSS

`gulp-cssmin`

```js
// Gulp@3 写法
// 1. 创建一个打包css的任务
gulp.task('cssHandler@3', () => {
    // return gulp就可以捕获到任务的结束
    return gulp
        .src('./src/css/*.css')       // 1-1. 找到源文件
        .pipe(cssmin())     // 1-2. 压缩文件
        .pipe(gulp.dest('./dist/css/'))  // 1. 把压缩好的内容放到指定目录下
})
```



```js
// Gulp@4 写法
const cssHandler = function () {
    return gulp
        .src('./src/css/*.css')       // 1-1. 找到源文件
        .pipe(cssmin())     // 1-2. 压缩文件
        .pipe(gulp.dest('./dist/css/'))  // 1. 把压缩好的内容放到指定目录下
}

module.exports.cssHandler = cssHandler
```



`gulp-autoprefixer`

- 导入以后得到一个处理流文件的函数, 直接再管道函数里面使用, 需要传递参数

```js
// Gulp@4 写法
const cssHandler = function () {
    return gulp
        .src('./src/css/*.css')
        .pipe(autoPreFixer({
            browsers: ['last 2 versions']
        }))
        .pipe(cssmin())
        .pipe(gulp.dest('./dist/css/'))
}
exports.cssHandler = cssHandler
```

或者

```js
const cssHandler = function () {
    return gulp
        .src('./src/css/*.css')
        .pipe(autoPreFixer())
        .pipe(cssmin())
        .pipe(gulp.dest('./dist/css/'))
}
```

```json
{
  "browserslist": [
    "last 2 versions", 
    "FireFox < 20"
  ]
}
```

## SASS

> gulp-sass 转码`.scss`文件的时候，会自动读取.sass 文件里面的变量,会给你解析以后使用, 而不会直接将设置的变量和混合器文件转码

SASS转换问题

- SASS
- gulp-sass

只需要选择其中一个

- 如果使用Gulp 来配置项目，那么就不需要使用 SASS 工具

- 如果不使用Gulp 来配置项目，那么就需要使用SASS 工具

```js
const sass = require('gulp-sass')(require('sass'))

// sass
const sassHandler = function () {
    return gulp
        .src('./src/sass/*.scss')
        .pipe(sass())
        .pipe(gulp.src('./src/css/*.css'))
        .pipe(autoPreFixer())
        .pipe(cssmin())
        .pipe(gulp.dest('./dist/sass/'))
}
```



## JS

`gulp-uglify` 

- JS文件压缩

`gulp-babel`

- `gulp-babel@7`  一般使用在 `gulp@3`中
- `gulp-babel@8` 一般使用在  `gulp@4` 中

```bash
# gulp-balel
yarn add -D gulp-babel
# 需要安装两个包
yarn add -D @babel/core @babel/preset-env
```

```js
// js
const jsHandler = function () {
    return gulp
        .src('./src/js/*.js')
        .pipe(babel({
            presets: ['@babel/env']
        }))                             // ES6 转 ES5
        .pipe(uglify())                 // 代码压缩
        .pipe(gulp.dest('./dist/js/'))
}
```

## HTML

`gulp-htmlmin`

```js
// html
const HTMLHandler = function () {
    return gulp
        .src('./src/pages/*.html')
        .pipe(htmlMin({
            // 通过配置的东西进行压缩
            collapseWhitespace: true,           // 表示移除空格和换行
            removeEmptyAttributes: true,        // 移除空属性
            collapseBooleanAttributes: true,    // 移除 checked 类似的 布尔值
            removeAttributeQuotes: true,        // 移除 不是必须的引号
            minifyCSS: true,                    // 压缩 内嵌式 css 代码（只能基本压缩）
            minifyJS: true,                     // 压缩 内嵌式 js 代码 （只能基本压缩，不能转换和编译）
            removeStyleLinkTypeAttributes: true // 移除 style 和 link 标签上的 type
        }))
        .pipe(gulp.dest('./dist/pages/'))
}
```

## 其他

- 开发环境中

- 图片是不需要我们压缩的

  - 直接使用线上地址
  - 图片是 UI 处理好给我们的

- `gulp-imagesmin`

  - 专门用来压缩图片的（无损压缩）

    

```js
// 创建一个打包images、audios、videos 文件内的任务
const imgHandler = () => {
    return gulp
        .src('./src/images/**')
        .pipe(gulp.dest('./dist/images'))
}
const videoHandler = () => {
    return gulp
        .src('./src/images/**')
        .pipe(gulp.dest('./dist/images'))
}
const audiosHandler = () => {
    return gulp
        .src('./src/images/**')
        .pipe(gulp.dest('./dist/images'))
}

// 第三方
const libHandler = () => {
    return gulp
        .src('./src/lib/**/*')
        .pipe('./src/fonts/**/*')
        .pipe(gulp.dest('./dist/lib/'))
}
```

## 默认任务

```js
// 1. 方式1
gulp.task('default', () => {

})

// 2. 方式2
const def = gulp.parallel(cssHandler, sassHandler, jsHandler)


module.exports = {
    cssHandler,
    sassHandler,
    jsHandler,
    HTMLHandler,
    imgHandler,
    videoHandler,
    audiosHandler,
    libHandler,
    default: def
}
```



```bash
# 自动执行 defalut 任务
gulp
```

## 删除任务

`del`

```bash
yarn add -D del
```

## Gulp 服务器

以 **`dist`**目录当作根目录

`gulp-webserver`

```bash
yarn add -D gulp
```

```js
const webServerHandler = function () {
    return gulp
        .src('./dist')
        .pipe(webserver({
            host: 'localhost',
            port: '6888',
            livereload: true, // 热重启
            open: './pages/index.html', // 默认打开哪一个页面
            proxies: [
                {
                    source: '/api', // 代理标识符
                    target: ''      // 代理地址
                }
            ]
        }))
}
```

## 热更新

```js
// 监控任务
const watchHandler = function () {
    gulp.watch('./src/css/*', cssHandler)
    gulp.watch('./src/js/*', jsHandler)
    gulp.watch('./src/sass/*', sassHandler,)
    gulp.watch('./src/pages/*', HTMLHandler)
}
```

## 总览

```js
const def = gulp.series(
    delHandler,
    gulp.parallel(cssHandler, sassHandler, jsHandler, HTMLHandler),
    webServerHandler,
    watchHandler, // 监控
)
```
