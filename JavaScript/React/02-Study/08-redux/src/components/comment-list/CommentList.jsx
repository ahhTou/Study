import React, {Component} from 'react'
import PropTypes from 'prop-types'
import CommentItem from '../comment-item/CommentItem'

class CommentList extends Component {

    static propTypes = {
        comments: PropTypes.array.isRequired,
        deleteComment: PropTypes.array.isRequired
    }

    render() {
        const {comments, deleteComment} = this.props
        const display = comments.length === 0 ? 'block' : 'none'
        return (
            <div className="col-md-8">
                <h3 className="reply">评论回复: </h3>
                <h2 style={{display,}}>暂无评论...</h2>
                <ul className="list-group">
                    {
                        comments.map((c, index) =>
                            <CommentItem key={index}
                                         comment={c}
                                         index={index}
                                         deleteComment={deleteComment}
                            />
                        )
                    }
                </ul>
            </div>
        )
    }

}


export default CommentList
