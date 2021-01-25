import React from 'react'
import {connect} from 'react-redux'
import {increment, decrement, incrementAsync} from '../redux/actions'
import Counter from '../components/Counter'

export default connect(
    state => ({count: state}),
    {increment, decrement, incrementAsync}
)(Counter)
