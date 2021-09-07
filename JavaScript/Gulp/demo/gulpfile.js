/**
 * 书写本个项目的打包配置流程
 * 按照 gulp 的语法来进行配置
 *
 * 因为gulp 是依赖于node 环境运行的将来的运行也是以 node 为基础运行的
 * 书写gulpfile.js 文件就按照node 的模块化语法进行书写(CommonS)
 */

const gulp = require('gulp')
const cssmin = require('gulp-cssmin')
const autoPreFixer = require('gulp-autoprefixer')
const sass = require('gulp-sass')(require('sass'))
const uglify = require('gulp-uglify')
const babel = require('gulp-babel')
const htmlMin = require('gulp-htmlmin')
const del = require('del')
const webserver = require('gulp-webserver')
const fileInclude = require('gulp-file-include')


// Gulp@4 写法
const cssHandler = function () {
    return gulp
        .src('./src/css/*.css')             // 1-1. 找到源文件
        .pipe(autoPreFixer())               // 1-2. 增加（兼容性）前缀
        .pipe(cssmin())                     // 1-3. 压缩文件
        .pipe(gulp.dest('./dist/css/'))     // 1.4. 把压缩好的内容放到指定目录下
}

// sass
const sassHandler = function () {
    return gulp
        .src('./src/sass/*.scss')
        .pipe(sass())
        .pipe(autoPreFixer())
        .pipe(cssmin())
        .pipe(gulp.dest('./dist/css/'))
}

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

// html
const HTMLHandler = function () {
    return gulp
        .src('./src/pages/*.html')
        .pipe(fileInclude({
            prefix: '!gulp@',                  // 自定义的标识符
            basepath: './src/components'    // 基准目录
        }))
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

const delHandler = () => {
    return del(['./dist/'])
}

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

// 监控任务
const watchHandler = function () {
    gulp.watch('./src/css/*', cssHandler)
    gulp.watch('./src/js/*', jsHandler)
    gulp.watch('./src/sass/*', sassHandler,)
    gulp.watch('./src/pages/*', HTMLHandler)
}

// 默认任务
// 默认任务就是把所有的任务一起执行
// gulp-series gulp-parallel
// 这两个方法的返回值是一个函数, 返回值可以直接被当作任务函数使用
// 使用 task 的方式创建一个 default 任务

// 1. 方式1
// gulp.task('default', () => {
//
// })

// 2. 方式2
const def = gulp.series(
    delHandler,
    gulp.parallel(cssHandler, sassHandler, jsHandler, HTMLHandler),
    webServerHandler,
    watchHandler, // 监控
)


module.exports = {
    cssHandler,
    sassHandler,
    jsHandler,
    HTMLHandler,
    imgHandler,
    videoHandler,
    audiosHandler,
    libHandler,
    delHandler,
    webServerHandler,
    watchHandler,
    default: def
}