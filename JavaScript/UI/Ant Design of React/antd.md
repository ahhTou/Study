# 安装

```sh
# 安装 组件库
yarn add antd
```



# 使用

在App.js中引入App.css,在app.css中引入

```css
@import '~antd/dist/antd.css';
```



# 自定义

首先把 `src/App.css` 文件修改为 `src/App.less`，然后修改样式引用为 less 文件。

```sh
$ yarn add @craco/craco
```



```diff
/* src/App.js */
- import './App.css';
+ import './App.less';
/* src/App.less */
- @import '~antd/dist/antd.css';
+ @import '~antd/dist/antd.less';
```

```js
/* package.json */
"scripts": {
-   "start": "react-scripts start",
-   "build": "react-scripts build",
-   "test": "react-scripts test",
  	"start": "craco start",
	"build": "craco build",
    "test": "craco test",
}
```



然后安装 `craco-less` 

```sh
$ yarn add craco-less
```

并修改 `craco.config.js` 文件如下。

```bash
const CracoLessPlugin = require('craco-less');

module.exports = {
  plugins: [
    {
      plugin: CracoLessPlugin,
      options: {
        lessLoaderOptions: {
          lessOptions: {
            modifyVars: { '@primary-color': '#1DA57A' },
            javascriptEnabled: true,
          },
        },
      },
    },
  ],
};
```

这里利用了 [less-loader](https://github.com/webpack/less-loader#less-options) 的 `modifyVars` 来进行主题配置，变量和其他配置方式可以参考 [配置主题](https://ant.design/docs/react/customize-theme-cn) 文档。修改后重启 `yarn start`，如果看到一个绿色的按钮就说明配置成功了。