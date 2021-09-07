import React, {Component} from 'react'

import CommentAdd from '../comment-add/CommentAdd'
import CommentList from '../comment-list/CommentList'

class app extends Component {

    // 给组件对象 指定state
    state = {
        comments: [
            {username: 'Tom', content: 'React挺好的'},
            {username: 'Jack', content: 'React挺好的'},
        ]
    }

    addComment = comment => {
        const {comments} = this.state
        comments.unshift(comment)

        // 更新状态
        this.setState({comments})
    }

    deleteComment = index => {

        const {comments} = this.state
        comments.splice(index, 1)

        this.setState({comments})
    }


    render() {
        return (
            <div>
                <header>
                    <h1>发表评价</h1>
                </header>

                <div className="container">
                    <CommentAdd addComment={this.addComment}/>
                    <CommentList comments={this.state.comments}
                                 deleteComment={this.deleteComment}
                    />
                </div>
            </div>
        )
    }

}

export default app
