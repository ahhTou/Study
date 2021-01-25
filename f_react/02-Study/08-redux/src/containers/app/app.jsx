import React, {Component} from 'react'
import PropTypes from 'prop-types'
import {connect} from 'react-redux'


import CommentAdd from '../../components/comment-add/CommentAdd'
import CommentList from '../../components/comment-list/CommentList'

import {addComment, deleteComment, getComments} from '../../redux/actions'

class App extends Component {

    static propTypes = {
        comments: PropTypes.array.isRequired,
        addComment: PropTypes.func.isRequired,
        deleteComment: PropTypes.func.isRequired,
        getComments: PropTypes.func.isRequired,
    }

    // 给组件对象 指定state
    state = {
        comments: []
    }

    componentDidMount() {
        this.props.getComments()
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

        const {comments, addComment, deleteComment} = this.props

        return (
            <div>
                <header>
                    <h1>发表评价</h1>
                </header>

                <div className="container">
                    <CommentAdd addComment={addComment}/>
                    <CommentList comments={comments}
                                 deleteComment={deleteComment}
                    />
                </div>
            </div>
        )
    }

}

export default connect(
    state => ({comments: state.comments}), // state就是一个comments数组
    {addComment, deleteComment, getComments}
)(App)
