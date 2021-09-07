# 启动

## 启动项目

## 引入JS

```html
<!-- 加载 React。-->
<!-- 注意: 部署时，将 "development.js" 替换为 "production.min.js"。-->
<script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>

<!-- 加载我们的 React 组件。-->
<script src="test.js"></script>
```



# 文档入门

## 1. Hello World

```jsx
ReactDOM.render(
  <h1>Hello, world!</h1>,
  document.getElementById('root')
);
```



## 2. JSX简介

#### 基础语法

```jsx
// 1. 特定属性可以使用 “” 也可以使用 {} 来使用某个变量
const element = (
    <h1 tabIndex="0">
        Hello, {formatName(user)}
    </h1>
)

// 2. 子元素
// 可以包含一个，也可以使用 () 包含多个
const e1 = <h1>I am `e1`</h1>
const e2 = (
    <div>
        <h1>hello!</h1>
        <h12>I AM `E2`</h12>
    </div>
)
```

#### 防止注入攻击

> React DOM 在渲染所有输入内容之前，默认会进行[转义](https://stackoverflow.com/questions/7381974/which-characters-need-to-be-escaped-on-html)。它可以确保在你的应用中，永远不会注入那些并非自己明确编写的内容。所有的内容在渲染之前都被转换成了字符串。这样可以有效地防止 [XSS（cross-site-scripting, 跨站脚本）](https://en.wikipedia.org/wiki/Cross-site_scripting)攻击。



## 3. 元素渲染

[元素渲染 – React (docschina.org)](https://react.docschina.org/docs/rendering-elements.html)

React 元素是[不可变对象](https://en.wikipedia.org/wiki/Immutable_object)。一旦被创建，你就无法更改它的子元素或者属性。一个元素就像电影的单帧：它代表了某个特定时刻的 UI。

根据我们已有的知识，更新 UI 唯一的方式是创建一个全新的元素，并将其传入 [`ReactDOM.render()`](https://react.docschina.org/docs/react-dom.html#render)。

考虑一个计时器的例子：

```jsx
function tick() {
    const element = (
        <div>
            <h1>Hello, World</h1>
            <h2>It's {new Date().toLocaleTimeString()}.</h2>
        </div>
    )

    ReactDOM.render(element, document.getElementById('root'))
}

setInterval(tick, 1000)
```

这个例子会在 [`setInterval()`](https://developer.mozilla.org/en-US/docs/Web/API/WindowTimers/setInterval) 回调函数，每秒都调用 [`ReactDOM.render()`](https://react.docschina.org/docs/react-dom.html#render)。



## 4. 组件 & Props

### 定义组件

定义组件最简单的方式就是编写 JavaScript 函数：

```jsx
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}
```

该函数是一个有效的 React 组件，因为它接收唯一带有数据的 “props”（代表属性）对象与并返回一个 React 元素。这类组件被称为“函数组件”，因为它本质上就是 JavaScript 函数。

你同时还可以使用 [ES6 的 class](https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Classes) 来定义组件：

```jsx
class Welcome extends React.Component {
  render() {
    return <h1>Hello, {this.props.name}</h1>;
  }
}
```

上述两个组件在 React 里是等效的。

我们将在[下一章节](https://react.docschina.org/docs/state-and-lifecycle.html)中讨论关于函数组件和 class 组件的额外特性。

### 混合组件

```jsx
function Counter() {
    return (
        <div>
            <WelCome name="A"/>
            <WelCome name="B"/>
            <WelCome name="C"/>
        </div>
    )
}

ReactDOM.render(
    <Counter />,
    document.getElementById('root')
)
```

### 拆分组件

原组件

```jsx
function Comment(props) {
    return (
        <div className="Comment">
            <div className="UserInfo">
                <img className="Avatar"
                     src={props.author.avatarUrl}
                     alt={props.author.name}
                />
                <div className="UserInfo-name">
                    {props.author.name}
                </div>
            </div>
            <div className="Comment-text">
                {props.text}
            </div>
            <div className="Comment-date">
                {formatDate(props.date)}
            </div>
        </div>
    )
}
```

可以拆分为

```jsx
function Comment(props) {
    return (
        <div className="Comment">

            <UserInfo user={props.author}/>

            <div className="Comment-text">
                {props.text}
            </div>
            <div className="Comment-date">
                {formatDate(props.date)}
            </div>
        </div>
    )
}

function UserInfo(props) {
    <div className="UserInfo">
        <Avatar user={props.user}/>
        <div className="UserInfo-name">
            {props.user.name}
        </div>
    </div>
}


function Avatar(props) {
    return (
        <img className="Avatar"
             src={props.user.avatarUrl}
             alt={props.user.name}
        />
    )
}

```



### 特性

**所有 React 组件都必须像纯函数一样保护它们的 props 不被更改。**

##  5.  State & 生命周期

代码不会重新渲染组件：

```jsx
// Wrong
this.state.comment = 'Hello';
```

而是应该使用 `setState()`:

```jsx
// Correct
this.setState({comment: 'Hello'});
```

此代码可能会无法更新计数器：

```jsx
// Wrong
this.setState({
  counter: this.state.counter + this.props.increment,
});
```

要解决这个问题，可以让 `setState()` 接收一个函数而不是一个对象。这个函数用上一个 state 作为第一个参数，将此次更新被应用时的 props 做为第二个参数：

```jsx
// Correct
this.setState((state, props) => ({
  counter: state.counter + props.increment
}));
```



## 6.事件处理

### 基本

常规

```jsx
function ActionLink() {
    function  handleClick(e){
        e.preventDefault()
        alert('Clicked')
    }

    return (
        <a href="#" onClick={handleClick}>
            Click Me
        </a>
    )
}
```

es6

```jsx
class ActionLink extends React.Component {
    handleClick(e) {
        e.preventDefault()
        alert('es6 Clicked')
    }

    render() {
        return (
            <a href="#" onClick={this.handleClick}>
                Click Me
            </a>
        )
    }

}
```

### 关于this

```jsx
constructor(props) {
    super(props)
    this.state = {isToggleOn: true}

    // 为了在回调中使用 `this`，这个绑定是必不可少的
    this.handleClick = this.handleClick.bind(this)
}

handleClick() {
    this.setState(state => ({
        isToggleOn: !state.isToggleOn
    }))
}

render() {
    return (
        <button onClick={this.handleClick}>
            {this.state.isToggleOn ? 'ON' : 'OFF'}
        </button>
    )
}
```

如果觉得使用 `bind` 很麻烦，这里有两种方式可以解决。如果你正在使用实验性的 [public class fields 语法](https://babeljs.io/docs/plugins/transform-class-properties/)，你可以使用 class fields 正确的绑定回调函数：

```jsx
class LoggingButton extends React.Component {
  // 此语法确保 `handleClick` 内的 `this` 已被绑定。  // 注意: 这是 *实验性* 语法。  handleClick = () => {    console.log('this is:', this);  }
  render() {
    return (
      <button onClick={this.handleClick}>
        Click me
      </button>
    );
  }
}
```

[Create React Counter](https://github.com/facebookincubator/create-react-app) 默认启用此语法。

如果你没有使用 class fields 语法，你可以在回调中使用[箭头函数](https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Functions/Arrow_functions)：

```jsx
class LoggingButton extends React.Component {
  handleClick() {
    console.log('this is:', this);
  }

  render() {
    // 此语法确保 `handleClick` 内的 `this` 已被绑定。    return (      <button onClick={() => this.handleClick()}>        Click me
      </button>
    );
  }
}
```

此语法问题在于每次渲染 `LoggingButton` 时都会创建不同的回调函数。在大多数情况下，这没什么问题，但如果该回调函数作为 prop 传入子组件时，这些组件可能会进行额外的重新渲染。我们通常建议在构造器中绑定或使用 class fields 语法来避免这类性能问题。

### 向事件处理程序传递参数

在循环中，通常我们会为事件处理函数传递额外的参数。例如，若 `id` 是你要删除那一行的 ID，以下两种方式都可以向事件处理函数传递参数：

```jsx
<button onClick={(e) => this.deleteRow(id, e)}>Delete Row</button>
<button onClick={this.deleteRow.bind(this, id)}>Delete Row</button>
```

上述两种方式是等价的，分别通过[箭头函数](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions)和 [`Function.prototype.bind`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_objects/Function/bind) 来实现。

在这两种情况下，React 的事件对象 `e` 会被作为第二个参数传递。如果通过箭头函数的方式，事件对象必须显式的进行传递，而通过 `bind` 的方式，事件对象以及更多的参数将会被隐式的进行传递。

## 7. 条件渲染

### 仅使用js语法

```jsx
class LoginControl extends React.Component {
  constructor(props) {
    super(props);
    this.handleLoginClick = this.handleLoginClick.bind(this);
    this.handleLogoutClick = this.handleLogoutClick.bind(this);
    this.state = {isLoggedIn: false};
  }

  handleLoginClick() {
    this.setState({isLoggedIn: true});
  }

  handleLogoutClick() {
    this.setState({isLoggedIn: false});
  }

  render() {
    const isLoggedIn = this.state.isLoggedIn;
    let button;
    if (isLoggedIn) {
      button = <LogoutButton onClick={this.handleLogoutClick} />;
    } else {
      button = <LoginButton onClick={this.handleLoginClick} />;
    }

    return (
      <div>
        <Greeting isLoggedIn={isLoggedIn} />
        {button}
      </div>
    );
  }
}

ReactDOM.render(
  <LoginControl />,
  document.getElementById('root')
);
```

### &&

```jsx
function Mailbox(props) {
  const unreadMessages = props.unreadMessages;
  return (
    <div>
      <h1>Hello!</h1>
      {unreadMessages.length > 0 &&        <h2>          You have {unreadMessages.length} unread messages.        </h2>      }    </div>
  );
}
```

之所以能这样做，是因为在 JavaScript 中，`true && expression` 总是会返回 `expression`, 而 `false && expression` 总是会返回 `false`。

因此，如果条件是 `true`，`&&` 右侧的元素就会被渲染，如果是 `false`，React 会忽略并跳过它。

### 三目运算符

```jsx
render() {
  const isLoggedIn = this.state.isLoggedIn;
  return (
    <div>
      {isLoggedIn        ? <LogoutButton onClick={this.handleLogoutClick} />
        : <LoginButton onClick={this.handleLoginClick} />      }
    </div>  );
}
```

### 阻止渲染

```jsx
function WarningBanner(props) {
  if (!props.warn) {    return null;  }
  return (
    <div className="warning">
      Warning!
    </div>
  );
}

...
...

  render() {
    return (
        ...
        ...
    );
  }
}
```



## 8. 列表 & key

### 常规

生成列表的放视类似使用map

```jsx
const nums = [1, 2, 3, 4, 5]
const list = nums.map(n => {
    return (
        <li> {n} </li>
    )
})

ReactDOM.render(
    <ul>
        {list}
    </ul>,
    document.getElementById('root')
)
```

通常你需要在一个[组件](https://react.docschina.org/docs/components-and-props.html)中渲染列表。

我们可以把前面的例子重构成一个组件，这个组件接收 `numbers` 数组作为参数并输出一个元素列表。

```jsx
function NumberList(props) {
  const numbers = props.numbers;
  const listItems = numbers.map((number) =>    <li>{number}</li>  );  return (
    <ul>{listItems}</ul>  );
}

const numbers = [1, 2, 3, 4, 5];
ReactDOM.render(
  <NumberList numbers={numbers} />,  document.getElementById('root')
);
```

当我们运行这段代码，将会看到一个警告 `a key should be provided for list items`，意思是当你创建一个元素时，必须包括一个特殊的 `key` 属性。我们将在下一节讨论这是为什么。

让我们来给每个列表元素分配一个 `key` 属性来解决上面的那个警告：

```jsx
...
  const listItems = numbers.map((number) =>
    <li key={number.toString()}>{number}</li>
  );
...
```

或者在组件遍历时声明key

```jsx
function ListItem(props) {
  // 正确！这里不需要指定 key：  
    return <li>{props.value}</li>;
}

function NumberList(props) {
  const numbers = props.numbers;
  const listItems = numbers.map((number) =>
    // 正确！key 应该在数组的上下文中被指定    
     <ListItem key={number.toString()} value={number} />
  );
  return (
    <ul>
      {listItems}
    </ul>
  );
}
```

### 在JSX中使用map

```jsx
...
return (
    <ul>
      {numbers.map((number) => 
                   <ListItem key={number.toString()} value={number} />)}    	
    </ul>
  );
```

### 注意

- 一般都在map中传入key值

    ```jsx
      const listItems = numbers.map((number) =>
         <ListItem key={number.toString()} value={number} />
      );
    ```

- 数组元素中使用的 key 在其兄弟节点之间应该是独一无二的。然而，它们不需要是全局唯一的。当我们生成两个不同的数组时，我们可以使用相同的 key 值

- key 不能作为props传递

    ```jsx
    // Post 组件可以读出 props.id，但是不能读出 props.key。
    const content = posts.map((post) =>
      <Post
        key={post.id}    id={post.id}    title={post.title} />
    );
    ```

## 9. 表单

### 受控的组件 

input & textarea

```jsx
class NameForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }

    handleSubmit(event) {
        alert('提交的名字: ' + this.state.value);
        event.preventDefault();
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                    名字:
                    <input type="text" value={this.state.value} onChange={this.handleChange} />
                    <textarea value={this.state.value} onChange={this.handleChange} />
                </label>
                {this.state.value}
                <input type="submit" value="提交" />
            </form>
        );
    }
}
```

selected

```jsx
class FlavorForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {value: 'coconut'};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    alert('你喜欢的风味是: ' + this.state.value);
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          选择你喜欢的风味:
          <select value={this.state.value} onChange={this.handleChange}>
            <option value="grapefruit">葡萄柚</option>
            <option value="lime">酸橙</option>
            <option value="coconut">椰子</option>
            <option value="mango">芒果</option>
          </select>
        </label>
        <input type="submit" value="提交" />
      </form>
    );
  }
}
```

### 不受控的

```jsx
<input type="file" />
```

### 控制多个表单

```jsx
class Reservation extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isGoing: true,
      numberOfGuests: 2
    };

    this.handleInputChange = this.handleInputChange.bind(this);
  }

  handleInputChange(event) {
    const target = event.target;
    const value = target.name === 'isGoing' ? target.checked : target.value;
    const name = target.name;
    this.setState({
      [name]: value    });
  }

  render() {
    return (
      <form>
        <label>
          参与:
          <input
            name="isGoing"            type="checkbox"
            checked={this.state.isGoing}
            onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          来宾人数:
          <input
            name="numberOfGuests"            type="number"
            value={this.state.numberOfGuests}
            onChange={this.handleInputChange} />
        </label>
      </form>
    );
  }
}
```

从 表单中 的name 得到需要改变的值

```jsx
          <input
            name="numberOfGuests"            type="number"
            value={this.state.numberOfGuests}
            onChange={this.handleInputChange} />
        </label>
```

然后通过onChange改变

```jsx
  handleInputChange(event) {
    const target = event.target;
    const value = target.name === 'isGoing' ? target.checked : target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }
```

其中

```jsx
this.setState({
  [name]: value
});
```
等同于

```jsx
var partialState = {};
partialState[name] = value;
this.setState(partialState);
```

### 控制输入

```jsx
ReactDOM.render(<input value="hi" />, mountNode);

// 解除
setTimeout(function() {
  ReactDOM.render(<input value={null} />, mountNode);
}, 1000);
```

## 10. 状态提升

- 两个子组件共享state
- 使用同一个父组件，传入props
- 但是子组件无法修改props
- 所以父组件通过props传入函数，子组件调用函数，来修改父组件的state来完成两个子组件共享state
- 这就是状态提升

实例( 自己写的例子 )

```jsx
class Father extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            name1: '小明',
            name2: '小刚'
        }
    }

    changeName(who) {
        console.log(who)
        this.setState({
            [who]: this.state[who] + 'Pro'
        })
    }

    render() {
        return (
            <div>
                I am father
                <Son name={this.state.name1}
                     bro={this.state.name2}
                     change={() => {
                         this.changeName('name1')
                     }}/>
                <Son name={this.state.name2}
                     bro={this.state.name1}
                     change={() => {
                         this.changeName('name2')
                     }}/>
            </div>
        )
    }
}

class Son extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div>
                I am son, my name is {this.props.name},
                my brother is {this.props.bro}
                <button onClick={() => this.props.change()}>改名</button>
            </div>
        )
    }

}

ReactDOM.render(
    <Father/>,
    document.getElementById('root')
)
```

## 11. 组合 vs 继承

类似于Vue中插槽

单插

```jsx
function Father() {
    return (
        <div>
            <div>Father</div>
            <div>
                {this.props.children}
            </div>
        </div>
    )

}

function Son() {
    return (
        <div>
            <Father>
                我是传入的内容
            </Father>
        </div>
    )

}
```

多插

```jsx
function Father2(props) {
    return (
        <div>
            <div>Father</div>
            <div>
                {props.left}
            </div>
            <div>
                {props.children.mid}
            </div>
            <div>
                {props.right}
            </div>
        </div>
    )

}


function Son2() {
    return (
        <div>
            <Father2
                left={(<div>我是左</div>)}
                right={(<div>我是右</div>)}
            >
                {{
                    mid: <div>我是中间</div>
                }}
            </Father2>
        </div>
    )

}
```

# 视频学习

## 01 refs

当id使用（类似vue），不推荐

```jsx
    showInput() {
        const input = this.refs.content
        alert(input.value)
	...
    }

    render() {
        return (
			...
                <label><input type="text" ref="content"/></label>
			...
        )
    }
}
```

使用表达式绑定值

**其中input指代当前元素**

```jsx
showInput() {
        alert(this.input.value)
    	...
    }

render() {
    return (
		...
         <label>
            <input type="text" ref={input => this.input = input}/>
        </label>

		...
    )
}
```
### 快速得到Refs

```jsx
myRef = React.createRef() // 仅能存储一个 ref
...
console.log(myRef.current.value)
...
<input type={'text'} ref={this.myRef}/>
```

## 02 event

```jsx
handler(event) {
    alert(event.target.value)
}

render() {
    return (
        <label><input type="text" placeholder="失去焦点提示" onBlur={this.handler}/></label>
    )
}
```

## 03 表单数据收集

使用refs

```jsx
handleSubmit(e) {
    const name = this.nameInput.value
    this.setState({name})
}
...
<input type="text" ref={input => this.nameInput = input}/>
```

使用onChange

```jsx
handleChange(e) {
    const pwd = e.target.value
    this.setState({pwd})
}
...
<input type="password" value={this.state.pwd} onChange={this.handleChange}/>

```

## 04 虚拟DOM 和 Diff算法

...



# 脚手架

## 安装

```sh
npx create-react-app my-app
cd my-app
npm start
```

```sh
# 全局安装
npm install -g create-react-app
# 构建一个my-app的项目
npx create-react-app my-app
cd my-app

# 启动编译当前的React项目，并自动打开 http://localhost:3000/
npm start
```

## State写法

```jsx
class app extends Component {
    
    // 给组件对象 指定state
    state = {
        comments: [
            {username: 'Tom', content: 'React挺好的'},
            {username: 'Jack', content: 'React挺好的'},
        ]
    }
}
```

## 类型检查

```sh
# 开发时依赖
npm install --save prop-types
```

在组件外

```jsx
CommentList.propTypes = {
    comments: PropTypes.array.isRequired
}
```

在组件内

```jsx
class CommentList extends Component { 
	static propTypes = {
    	comments: PropTypes.array.isRequired
	}
}
```

## 箭头函数

常规

```jsx
constructor(props) {
	...
    this.handleSubmit = this.handleSubmit.bind(this)
}

handleSubmit() {
	...
}
```

箭头函数( 没有自己的this )

```jsx
handleSubmit = () => {
    ...
}
```

## 按需加载

```sh
npm install react-app-rewired babel-plugin-import --save-dev
```

## 路径别名

### customize-cra

使用`customize-cra`

```sh
yarn add customize-cra react-app-rewired --dev
```

在`config-overrides.js`设置

```js
const { override } = require('customize-cra');

const path = require("path");

module.exports = override(
    config =>{
        config.resolve.alias = {
            "@": path.resolve(__dirname, "src")
        };
        return config
    },
);
```

### craco

安装

```sh
yarn add @craco/craco
```

配置

```js
const CracoLessPlugin = require('craco-less')
const path = require('path')

const pathResolve = pathUrl => path.join(__dirname, pathUrl)

module.exports = {
    webpack: {
        alias: {
            '@': pathResolve('src'),
            '@assets': pathResolve('src/assets'),
			...
        }
    },
    plugins: [
		...
    ],
}
```

## 跨域

在`package.json`配置

```js
"proxy": "http://localhost:4000"
```

# 网络请求

axios vs fetch

引入axios

```sh
$ npm install axios
```

or 引入js

```
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
```

```jsx
            axios.get(url)
                .then(res => {
                    console.log(res.data)
                })
                .catch(err => {
                    console.log(err)
                })


            fetch(url).then(res => {
                return res.json()
            })
                .then(data => {
                    console.log(data.data)
                })
                .catch(err => {
                    console.log(err)
                })
```

# 样式

动态绑定变量

```jsx
render() {
    const display = comments.length === 0 ? 'block' : 'none'
    return (
        <h2 style={{display,}}>暂无评论...</h2>
    )
}
```

# 组件通信

## 父子

不必多说

## 兄弟

订阅-发布

> PubSubJS

下载

```sh
npm install --save pubsub-js
```

引入

```js
import PubSub from 'pubsub-js'
 
// or when using CommonJS
const PubSub = require('pubsub-js');
```

使用

```js
// 发布
PubSub.publish('toLittle', '给兄弟组件信息')
...
// 订阅
PubSub.subscribe('toLittle', (msgName, msg) => {
	console.log('事件名称为' + msgName)
	this.setState({msg})
})
```

# 路由

React-Router

单页面应用必用（SPA）

## 安装

下载

```sh
// web 版本
npm install --save react-router-dom

yarn add react-router-dom
```

引入

```jsx
import {NavLink, Switch, Route, Redirect ...} from 'react-router-dom'
```

在index.js

> 需要包裹 <Counter />

```jsx
import React from 'react'
import {render} from 'react-dom'
import {BrowserRouter} from 'react-router-dom'
import Counter from './Counter'

render(
    (
        <BrowserRouter>
            <Counter/>
        </BrowserRouter>
    ),
    document.getElementById('root')
)
```

## 基础

跳转

```jsx
<NavLink className="list-group-item" to="/about">About</NavLink>
```

切换 和 重定向

```jsx
<Switch>
    {/*根据路由显示*/}
    <Route path='/about' component={About}/>
    <Route path='/home' component={Home}/>
    {/*重定向*/}
    <Redirect to="/about"/>
</Switch>
```

## 组件打包

配置点击后激活的classname

```jsx
<NavLink 
    className="list-group-item" 
    to="/Home" 
    activeClassName='activeClass'>
    Home
</NavLink>
```

每次都要定义activeClassName，可以打包，来改善该情况

```jsx
class MyNavLink extends Component {
    render() {
        return (
            <NavLink {...this.props} activeClassName="activeClass" />
        )
    }
}
```

```jsx
...
<MyNavLink className="list-group-item" to="/about">About</MyNavLink>
<MyNavLink className="list-group-item" to="/Home">Home</MyNavLink>
...
```

## 嵌套路由

按部就班

```jsx
<ul className='nac nac-tabs'>
    <li>
        <MyNavLink to='/home/news'>News</MyNavLink>
        <MyNavLink to='/home/msg'>Home</MyNavLink>
    </li>
</ul>

<div>
    <Switch>
        <Route path='/home/news' component={News}/>
        <Route path='/home/msg' component={Msg}/>
        <Redirect to='/home/news'/>
    </Switch>
</div>
```

## 路由组件传递参数

通过跳转带有参数的，路由匹配 通过 ``:params`` 的特殊格式路径传递到props

```jsx
<a href={`/home/msg/msgDetail/${m.id}`}>{m.title}</a>

<Route path='/home/msg/msgDetail/:id' component={MsgDetail}/>
```

可以通过props中的路由参数得到

```jsx
this.props.match.params
```

```jsx
render() {
    const {id} = this.props.match.params
    const find = allMessage.find(m => m.id === id * 1)
    return (
        <ul>
            <li>ID: {find.id}</li>
            <li>Title: {find.title}</li>
            <li>Content: {find.content}</li>
        </ul>
    )
}
```

## 路由链接和非路由链接

通过a标签等非路由标签进行跳转的就是非路由连接，会发送请求

```jsx
<a href={`/home/msg/msgDetail/${m.id}`}>{m.title}</a>
```

通过路由标签进行跳转，不会发送请求，就不是非路由链接

```jsx
<NavLink to={`/home/msg/msgDetail/${m.id}`}>{m.title}</NavLink>
...
<MyNavLink to={`/home/msg/msgDetail/${m.id}`}>{m.title}</MyNavLink>
```

## 两种路由跳转方式

> 通过标签

```jsx
<NavLink to={`/home/msg/msgDetail/${m.id}`}>{m.title}</NavLink>
```

> 通过JS

```jsx
showDetail = id => {
    this.props.history.push(`/home/msg/msgDetail/${id}`)
}

showDetail2 = id => {
    this.props.history.replace(`/home/msg/msgDetail/${id}`)
}

back = () => {
    this.props.history.goBack()
}

forward = () => {
    this.props.history.goForward()
}
```

# Redux

## 安装

```sh
npm install --save redux
```

## 基本

定义一个reducer

```jsx
export function counter(state = 0, action) {

    console.log('counter', state, action)

    switch (action.type) {
        case INCREMENT:
            return state + action.data
        case DECREMENT:
            return state - action.data
        default:
            return state
    }
}
```

在app中启用，且引入刚才定义了reducer（index.jsx）

```jsx
import React from 'react'
import ReactDOM from 'react-dom'
import {createStore} from 'redux'

import Counter from './components/Counter'

import {counter} from './redux/reducers'

// 生成一个store对象
const store = createStore(counter) // 内部会第一次调用，得到初始化state（init）

function render {
    ReactDOM.render(
        <Counter store={store}/>,
        document.getElementById('root')
    )
}

render()

// 订阅监听（state中状态变化了，就会调用重绘）
store.subscribe(function () {
    render()
})
```

## Get

通过store得到值

```jsx
const count = this.props.store.getState()
```

## Dispatch

通过store赋值

```jsx
this.props.store.dispatch({
    type: INCREMENT,
    data: number,
})
```

## 监听重绘

index.js中 通过监听，来启动setState的重绘页面的作用（在index.js中定义）

```js
// 订阅监听（state中状态变化了，就会调用重绘）
store.subscribe(function () {
    render()
})
```

## 优化后结构 类似Vuex

- store

    ```jsx
    import {createStore} from 'redux'
    import {counter} from './reducers'
    
    
    
    // 生成一个store对象
    const store = createStore(counter) // 内部会第一次调用，得到初始化state（init）
    
    export default store
    ```

- reducers

- actions

- actions-types

在index中引入

```js
import store from './redux/store'

function render() {
	...
}

render()
store.subscribe(function () {
    render()
})
```

## 减少耦合 React-Redux

用来减低redux 和 react 的耦合度

安装

```sh
npm install --save react-redux
```

### 使用

修改index.js

只需将<Counter />放入 <Provider />中进行托管

```jsx
...
import {Provider} from 'react-redux'

import Counter from './components/Counter'
import store from './redux/store'


ReactDOM.render(
    <Provider store={store}>
        <Counter />
    </Provider>,
    document.getElementById('root')
)
```

在使用到redux的组件中

```jsx
...
import {connect} from 'react-redux'
import {increment, decrement} from '../redux/actions'

class Counter extends Component {
	...
    incrementIfOdd = () => {
        const number = this.select.value * 1
        const {count} = this.props

        if (count % 2 === 0) return

        this.props.increment(number)
    }
    ...
    
    render() {
        return (
			...
        )
    }

}

// 将state 和 dispatch 作为参数传给 connect ，connect再返回一个接受组件的组件
export default connect(
    state => ({count: state}),
    {increment, decrement}
)(Counter)
```

### 规范

将文件分为Ui组件`` components`` 和 容器组件`` containers``

components

```jsx
import React, {Component} from 'react'
...

export default class Counter extends Component {
    ...
    render() {
        return (
        	...
        )
    }

}
```

containers

```jsx
import React from 'react'
import {connect} from 'react-redux'
import {increment, decrement} from '../redux/actions'
import Counter from '../components/Counter'

export default connect(
    // 通过 回调函数 得到state
    state => ({count: state}),
    {increment, decrement}
)(Counter)
```

## 异步请求 redux-thunk

安装插件

```sh
npm install --save redux-thunk
```

返回store时候，增加第二个中间件参数

```jsx
import {createStore, applyMiddleware} from 'redux'
import thunk from 'redux-thunk'

import {counter} from './reducers'


// 生成一个store对象 内部会第一次调用，得到初始化state（init）
const store = createStore(
    counter,
    applyMiddleware(thunk) // 应用异步中间件
)

export default store
```

配置actions时

```jsx
// 同步的action都返回一个对象
export const decrement = number => ({
    type: DECREMENT,
    data: number,
})

// 异步的action都返回一个函数
// 异步action
// 该写法相当于return一个函数
export const incrementAsync = number => (
    dispatch => {
        // 异步的代码
        setTimeout(() => {
            // 1s 之后才回去分化一个增加的action
            dispatch(increment(number))
        }, 1000)
    }
)
```

## 插件

安装浏览器插件 ``Redux DevTools``

安装

```sh
npm install --save-dev redux-devtools-extension
```

使用

store.js

```jsx
import {createStore, applyMiddleware} from 'redux'
import thunk from 'redux-thunk'
import {composeWithDevTools} from 'redux-devtools-extension'

import {counter} from './reducers'


// 生成一个store对象 内部会第一次调用，得到初始化state（init）
const store = createStore(
    counter,
    composeWithDevTools(applyMiddleware(thunk))// 应用异步中间件
)

export default store
```

## 暴露多个reducers

使用 ``combineReducers``

```jsx
import {ADD_COMMENT, DELETE_COMMENT, RECEIVE_COMMENTS} from './action-types'
import {combineReducers} from 'redux'

function comments(state = [], action) {
	...
    return state
}

function counter(state = 0, action) {
    ...
    return state
}

export default combineReducers({
    comments, counter
})

// redux向外暴露的是什么结构
// { counter: 2, comments: [] }
```

在 组件中 中

```jsx
...

export default connect(
    state => ({comments: state.comments}), // state就是一个comments数组
    {addComment, deleteComment, getComments}
)(App)
```

# 扩展

## setState

> setState在更新状态时候是异步更新，第一个参数是 更新的状态对象，第二个参数是回调函数，将在render()执行后执行

方式1 对象时

```js
        const {count} = this.state
        this.setState({
            // 异步更新
            count: count + 1
        }, () => {
            // 在更新后，render()之后调用的回调函数
            console.log(this.state.count)
        })
```

方式2 函数时

```js
// 可以收到 state 和 props
this.setState((state, props) => {
    return {count: state.count + 1}
})
```

对象式，是函数式的语法糖

## 懒加载

常规

```jsx
import About from './About'
import Home from './Home'

...
<Route path='/about' component={About}/>
<Route path='/home' component={Home}/>
```

懒加载

```jsx
const Home = lazy(() => import('./Home'))

const About = lazy(() => import('./About'))

<Suspense fallback={<h1>Loading...</h1>}>
	<Route path='/about' component={About}/>
	<Route path='/home' component={Home}/>
</Suspense>
```

## Hooks

### State Hook

> 在函数时组件时使用 State

```jsx
function Demo2() {

    // 首次调用后不会再执行
    // 第一个参数是State 值， 第二个是改变 值的 方法，每次新值都要重新写
    const [count, setCount] = React.useState(0)
    const [name, setName] = React.useState('tom')

    function add() {
        // setCount(count + 1) // 写法1
        setCount(count => count + 1) // 写法2
    }

    function changeName() {
        // setCount(count + 1) // 写法1
        setName(() => 'jack') // 写法2
    }

    return (
        <div>
            <h2>和 -> {count}</h2>
            <h2>名字 -> {name}</h2>
            <button onClick={add}>+1</button>
            <button onClick={changeName}>+1</button>
        </div>
    )
}
```



### EffectHook

```js
function Demo2() {
...

    React.useEffect(() => {
        // 第二个参数什么都不传 : 任何值改变时调用
        // 第二参数为空数组 : 仅在初始化时调用 componentDidMount
        // 第三个参数指定state : 指定的state改变时调用
        // 返回的函数,相当于 componentWillUnmount
    	...
        
        return () => {
            // 组件卸载时...componentWillUnmount
        }
    }, [])

...
}

```



### RefHooks

在函数组件中，使用ref

```jsx
const myRef = React.useRef()
...
console.log(myRef.current.value)
...
<input type={'text'} ref={myRef}/>
```



## Fragment

> 去掉文档碎片，骗过 jsx 语法， 相当于没有层级包括

```jsx
import React, {Component, Fragment} from 'react'

class Demo extends Component {
    render() {
        return (
            <Fragment>
                <input type={'text'}/>
                <input type={'text'}/>
                <input type={'text'}/>
            </Fragment>
        )
    }
}
```

也可以这样写

```jsx
        <>
            <input type={'text'}/>
            <input type={'text'}/>
            <input type={'text'}/>
        </>
```
但是`Fragment`

可以拥有key值，可以被遍历。

```jsx
   <Fragment key={1}></Fragment>
```
## Context

> 一种组件通信方式， 常用于 【祖组件】与 【后代组件】的通信

```jsx
// 用于保存 上下文 对象
const MyContext = React.createContext()

const {Provider, Consumer} = MyContext

class A extends Component {
    state = { val: {} }
    render() {
        const {val} = this.state
        return (
            <div>
                // 使用Provider 传给 所有 后代
                <Provider value={val}>
                    <B/>
                </Provider>
                ...or
                <MyContext.Provider>
                	<B/>
                </MyContext.Provider>
            </div>
        )
    }

}


class B extends Component {render() {return (<div><C/></div>)}}

class C extends Component {
    // 使用context必须声明该句
    static contextType = MyContext

    render() {
        return (
            <div>
                <h3>我是组件C</h3>
                <h4>我从B集成的val是: {this.context}</h4>
            </div>
        )
    }
}
```

如果使用的函数式组件，可以使用通用方法

```jsx
function C() {
    return (
        <div>
            <h3>我是组件C</h3>
            <h4>
                <Consumer>
                    {
                        value => `我从B集成的名字是是: ${value}`
                    }
                </Consumer>
            </h4>
        </div>
    )
}
```

## 组件优化

### Component的2个问题

> 1. 只要执行setState(),即使不改变状态数据,组件也会重新render()
>
> 2. 当前组件重新render,就会自动重新render子组件-=>效率低

### 效率高的做法

> 只有当组件的state或props数据发生改变时才主新render()

### 原因

> Component中的shouldComponentUpdate()总是返回true解决

### 解决

继承 `PureConponent`

```jsx
// 底层是浅对比，
class Parent extends PureComponent {
...
}
```

浅对比产生的问题

```js
// 不更新
const {stuArr} = this.state
stuArr.push('小刘')
this.setState({stuArr})

// 更新
this.setState({stuArr: [...stuArr, '小刘']})
```

## Render Props

> 类Vue具名插槽

> 通过A标签上的render(可以为任意名字) 传给 A内部一个组件，并且可以给render参数作为渲染内部这个组件的值

```jsx
class Parent extends Component {
    render() {
        return (
            <div>
                <h3>Parent</h3>
                <A render={name => <B name={name}/>}/>
            </div>
        )
    }
}

class A extends Component {
    state = {name: 'tom'}

    render() {
        const {name} = this.state
        return (
            <div>
                <h3>A</h3>
                {this.props.render(name)}
            </div>
        )
    }
}

class B extends Component {
    render() {
        return (
            <div>
                <h3>B, My Name is {this.props.name}</h3>
            </div>
        )
    }
}
```

## 错误边界

> 讲错误限制到组件，而不扩散到全体
>
> 今年限制组件内部的子组件

```jsx
state = {
    hasError: false,
}

// 用于 修改错误表示符号
static getDerivedStateFromError(error) {
    // 更新 state 使下一次渲染能够显示降级后的 UI
    return {hasError: true}
}

// 用于捕捉 错误
componentDidCatch(error, errorInfo) {
    console.log('统计错误，发送给后台')
}

render() {
    return (
        <div>
            {this.state.hasError ? <h2>请重试</h2> : <Child/>}
        </div>
    )
}
```

## 组件通信总结

- 父子组件

    - props
        - children props
        - render props

- 消息订阅发布

    - pubs-sub

- 集中式管理

    - redux
    - dva

- context

    - 生产者-消费者 模式

    > 父子组件:props
    > 兄弟组件:消息订阅-发布、集中式管理
    > 祖孙组件(跨级组件):消息订阅-发布、集中式管理、conText(开发用的少，封装插件用的多)





# 新的发现

## 修改Children

```jsx
<div>
    {
        React.Children.map(this.props.children, ((child, index) =>
                index === 2 ? child : React.cloneElement(
                    child,
                    {
                        children: '被改变的按钮' + index,
                        onClick: () => {
                            console.log('我被修改了')
                        }
                    }
                )
        ))
    }
</div>
```



