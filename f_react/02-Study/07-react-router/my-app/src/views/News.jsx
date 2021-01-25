import React, {Component} from 'react'

class News extends Component {
    state = {
        news: [
            'news001',
            'news001',
            'news001',
        ]
    }

    render() {
        return (
            <div>
                {
                    this.state.news.map((news, i) => (
                        <li key={i}>
                            <a href='???'>{news}</a>
                        </li>
                    ))
                }
            </div>
        )
    }
}

export default News
