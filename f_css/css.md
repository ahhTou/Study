



**提升指定样式规则的应用优先权。**

```css
.app {
    text-align: center !important;
}
```



# 样式

## Input

### range

横向

```css
input[type=range]{ 
    margin-top: 8px;/*上部分的填充值*/
    outline: none; 
    -webkit-appearance: none;/*清除系统默认样式*/  
    width:100% !important;  
    background: -webkit-linear-gradient(#ffc107, #ffc107) no-repeat, #ddd;  /*背景颜色，俩个颜色分别对应上下，自己尝试下就知道了嗯*/
    background-size: 33% 100%;/*设置左右宽度比例*/  
    height: 3px;/*横条的高度，细的真的比较好看嗯*/  
} 
 /*拖动块的样式*/  
input[type=range]::-webkit-slider-thumb {  
    -webkit-appearance: none;/*清除系统默认样式*/  
    height:16px;/*拖动块高度*/  
    width: 16px;/*拖动块宽度*/  
    background: #f8f9fa;/*拖动块背景*/ 
    border-radius: 50%; /*外观设置为圆形*/  
    border: solid 1px #ddd; /*设置边框*/  
}
```

竖向

```scss
input[type='range'] {
    $b: rgb(55, 55, 55);
    -webkit-appearance: slider-vertical; /*清除系统默认样式*/
    width: 3px;
    border: none;
    outline: none;

    height: 100px;
    background: linear-gradient($b, $b) no-repeat, rgb(150, 150, 150);
    border-radius: 3px;
}

//修改相应样式
input[type='range']::-webkit-slider-runnable-track {
    -webkit-appearance: none; /*清除系统默认样式*/

    width: 3px; /*拖动块宽度*/

    background: #cccccc; /*拖动块背景*/
}

input[type='range']::-webkit-slider-thumb {
    -webkit-appearance: none; /*清除系统默认样式*/
    height: 16px; /*拖动块高度*/
    width: 16px; /*拖动块宽度*/
    background: rgb(45, 45, 45); /*拖动块背景*/
    border-radius: 50%; /*外观设置为圆形*/
}
```