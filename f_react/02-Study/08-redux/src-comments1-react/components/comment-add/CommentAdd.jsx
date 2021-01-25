import React, {Component} from 'react'
import PropTypes from 'prop-types'

class CommentAdd extends Component {

    state = {
        username: '',
        content: '',
    }

    static propTypes = {
        addComment: PropTypes.func.isRequired
    }

    handleSubmit = () => {
        // 收集数据
        const comment = this.state

        // 更新状态
        this.props.addComment(comment)

        // 清除输入状态
        this.setState({
            username: '',
            content: '',
        })
    }


    handleNameChange = event => {

        const username = event.target.value
        this.setState({username})
    }

    handleContentChange = event => {
        const content = event.target.value
        this.setState({content})
    }

    render() {
        const {username, content} = this.state
        return (
            <div>
                用户名<label><input type="text" value={username} onChange={this.handleNameChange}/></label>
                评论<label><input type="text" value={content} onChange={this.handleContentChange}/></label>
                <input
                    type="button"
                    className="btn btn-default pull-right"
                    onClick={this.handleSubmit}
                    value="提交"/>
            </div>
        )
    }

}

export default CommentAdd
