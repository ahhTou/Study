import React from 'react'

function cloneWithProps(e, props) {
    return React.cloneElement(
        e,
        props
    )
}

export {
    cloneWithProps,
}
