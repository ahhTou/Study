# 使用

安装

```sh
yarn add react-app-rewired customize-cra
yarn add babel-plugin-import --dev
yarn add @babel/plugin-proposal-decorators
yarn add less-loader
```

使用

```js
const {override, fixBabelImports, addLessLoader, addWebpackAlias, addDecoratorsLegacy} = require('customize-cra')
const path = require('path')

const pathResolve = pathUrl => path.join(__dirname, pathUrl)

module.exports = override(
    // antd按需加载，不需要每个页面都引入“antd/dist/antd.css”了
    fixBabelImports('import', {
        libraryName: 'antd-mobile',
        style: 'css',
    }),
    // 添加装饰器的能力
    addDecoratorsLegacy(),
    // 配置路径别名
    addWebpackAlias({
        '@': pathResolve('src'),
		...
    }),
    addLessLoader({
        lessOptions: {
            javascriptEnabled: true,
            modifyVars: {
                '@brand-primary': '#f47983'
            }
        }

    })
)
```



