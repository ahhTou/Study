import React, {Component} from 'react'
import PropTypes from 'prop-types'

class CommentItem extends Component {
    constructor(props) {
        super(props)
        this.state = {}
    }

    static propTypes = {
        comment: PropTypes.object.isRequired,
        deleteComment: PropTypes.func.isRequired,
        index: PropTypes.number.isRequired,
    }

    handleClick = () => {
        const {comment, deleteComment, index} = this.props

        // 提示
        if (window.confirm(`确定删除${comment.username}的评论吗`)) {
            deleteComment(index)
        }

        // 确定后删除
    }

    render() {
        const {comment} = this.props
        return (
            <li className="list-group-item">
                <div className="handle">
                    {/* eslint-disable-next-line no-script-url */}
                    <a href="javascript:" onClick={this.handleClick}>删除</a>
                </div>
                <p className="user"><span>{comment.username}</span>说</p>
                <p><span>{comment.content}</span></p>
            </li>
        )
    }

}

export default CommentItem
