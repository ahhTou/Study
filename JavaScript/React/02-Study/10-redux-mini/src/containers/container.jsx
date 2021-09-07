import {connect} from '../libs/react-redux'
import Count from '../components/count'
import {decrement, increment} from '../redux/actions'

export default connect(
    state => ({count: state.count}),
    {increment, decrement}
)(Count)
